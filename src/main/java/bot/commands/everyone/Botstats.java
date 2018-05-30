package bot.commands.everyone;

import bot.Privat;
import bot.Senpai.Bot;
import bot.commands.Command;
import bot.stuff.Messages;
import bot.stuff.Stats;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 28.05.2018
 * github.com/oskardevkappa/
 */

public class Botstats implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        //New EmbedBuilder for the information's and setting up some
        EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember());
        eb.setTitle(Bot.jda.getSelfUser().getName() + "'s Stats");
        eb.setThumbnail(Bot.jda.getSelfUser().getAvatarUrl());

        //List of names
        String statsname[] = {"Guilds", "Members", "Member in VoiceChannel", "Categories", "VoiceChannels", "TextChannels", "Roles", "Emotes"};

        //List of stats
        int stats[] = {Stats.Guilds(), Stats.Members(), Stats.MemberInVC(), Stats.Categories(), Stats.VoiceChannels(), Stats.TextChannels(), Stats.Roles(), Stats.Emotes()};

        //Now lets bring them together
        for(int i = 0; i < statsname.length; i++){
            eb.addField(statsname[i], String.valueOf(stats[i]), true);
        }

        //Aaaand send the message
        event.getChannel().sendMessage(eb.build()).queue();
    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Gives you the statistics of the Senpai bot.";
    }

    @Override
    public String[] alias() {
        return new String[]{"Stats"};
    }

    @Override
    public String name() {
        return "Botstats";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
