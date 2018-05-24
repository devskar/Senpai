package bot.commands.everyone;

import bot.Privat;
import bot.Senpai.Bot;
import bot.commands.Command;
import bot.stuff.Messages;
import bot.stuff.Stats;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class Botstats implements Command {

    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {
        EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember());
        eb.setTitle(Bot.jda.getSelfUser().getName() + "'s Stats");
        eb.setThumbnail(Bot.jda.getSelfUser().getAvatarUrl());

        String statsname[] = {"Guilds", "Members", "Member in VoiceChannel", "Categories", "VoiceChannels", "TextChannels", "Roles", "Emotes"};
        int stats[] = {Stats.Guilds(), Stats.Members(), Stats.MemberInVC(), Stats.Categories(), Stats.VoiceChannels(), Stats.TextChannels(), Stats.Roles(), Stats.Emotes()};

        for(int i = 0; i < statsname.length; i++){
            eb.addField(statsname[i], String.valueOf(stats[i]), true);
        }
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
        return new String[0];
    }

    @Override
    public String name() {
        return "botstats";
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
