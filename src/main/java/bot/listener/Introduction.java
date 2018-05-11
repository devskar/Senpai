package bot.listener;

import bot.Privat;
import bot.commands.everyone.Error;
import bot.commands.everyone.Help;
import bot.stuff.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class Introduction extends ListenerAdapter {

    @Override
    public void onGuildJoin(GuildJoinEvent event) {


        TextChannel tc = event.getGuild().getDefaultChannel();

        String msg =
                "Okay hei, I am your Senpai. " +
                "\nI need to send this message because you maybe don't understand how I work. " +
                "\nI am a small but with a lot of buggs :). I am using an error system, that means if you doing a command wrong you will get (hopefully) an error with an ID (Error#ID) then you can do: `" + new Error().help() + "`." +
                "\nand if you want to know how the command works you can do `" + Privat.Prefix + new Help().name() + " [command]`." +
                "\nIf there are any questions left you can join my [Support Server](" + Privat.SERVERINVITE + ")." +
                "\n AND YEAH I KNOW MY ENGLISH IS BAD THANKS.";

        EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember()).setDescription(msg).setAuthor(event.getJDA().getSelfUser().getName(), null, event.getJDA().getSelfUser().getAvatarUrl());

        tc.sendMessage(eb.build()).queue();

    }
}
