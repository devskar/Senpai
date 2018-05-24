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
 * At 21.05.2018
 * github.com/oskardevkappa/
 */

public class Emojis implements Command{
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        List<Emote> emts = event.getGuild().getEmotes();

        StringBuilder sbnon = new StringBuilder();
        StringBuilder sbis = new StringBuilder();

        EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember());

        for ( Emote e: emts ) {

            if (!e.isAnimated()){
                sbnon.append("<:" + e.getName() + ":" + e.getId() + "> ");
            }else {
                sbis.append("<:" + e.getName() + ":" + e.getId() + "> ");
            }
        }

        if (sbis.toString().equals(""))
            sbis.append("-/-");
        if (sbnon.toString().equals(""))
            sbnon.append("-/-");

        eb.setTitle("Emojis of Guild " + event.getGuild().getName());
        eb.setThumbnail(event.getGuild().getIconUrl());
        eb.addBlankField(false);
        eb.addField("Non animated emojis", sbnon.toString(), false);
        eb.addField("Animated emojis", sbis.toString(), false);


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
        return new String[0];
    }

    @Override
    public String name() {
        return "emojis";
    }

    @Override
    public boolean visible() {
        return true;
    }

    @Override
    public void executed(boolean safe, GuildMessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, GuildMessageReceivedEvent event) {
        return false;
    }
}
