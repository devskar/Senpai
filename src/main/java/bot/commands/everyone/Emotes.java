package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

/**
 * Coded by Oskar#7402
 * At 28.05.2018
 * github.com/oskardevkappa/
 */

public class Emotes implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        //Creating a List with all Emotes of the guild
        List<Emote> emts = event.getGuild().getEmotes();

        //2 StringBuilder. 1 for the animated and one for the normal Emotes
        StringBuilder sbnon = new StringBuilder();
        StringBuilder sbis = new StringBuilder();

        //Checking which are animated and which are not
        for ( Emote e: emts ) {

            if (!e.isAnimated()){
                sbnon.append("<:").append(e.getName()).append(":").append(e.getId()).append("> ");
            }else {
                sbis.append("<:").append(e.getName()).append(":").append(e.getId()).append("> ");
            }
        }

        //Adding a mark if there are no emojis
        if (sbis.toString().equals(""))
            sbis.append("-/-");
        if (sbnon.toString().equals(""))
            sbnon.append("-/-");

        //Initializing an EmbedBuilder and adding things
        EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember());
        eb.setTitle("Emotes of Guild " + event.getGuild().getName());
        eb.setThumbnail(event.getGuild().getIconUrl());
        eb.addBlankField(false);
        eb.addField("Non animated emotes", sbnon.toString(), false);
        eb.addField("Animated emotes", sbis.toString(), false);

        //And sending this shit
        event.getChannel().sendMessage(eb.build()).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Gives you a list of all custom emojis from your guild.";
    }

    @Override
    public String[] alias() {
        return new String[]{"Emotes", "Reactions"};
    }

    @Override
    public String name() {
        return "Emtoes";
    }

    @Override
    public boolean visible() {
        return true;
    }

}
