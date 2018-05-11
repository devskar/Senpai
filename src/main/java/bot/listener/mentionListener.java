package bot.listener;

import bot.Privat;
import bot.Senpai.Bot;
import bot.stuff.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class mentionListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentDisplay().equals("@" + event.getGuild().getSelfMember().getEffectiveName())){
            EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember()).setTitle("Hi I am your Senpai")

                    .setDescription("I am coded by oskar#7402 and Im listening to the Prefix `" + Privat.Prefix + "`.\n" +
                    "If you got any questions you can join my [Support Server](" + Privat.SERVERINVITE + ").\n"
                    + "If you want to invite the Senpai bot click [here](" + Privat.BOTINVITE + ").\n"
                    + "You can find my github documentation [here](" + Privat.GITHUBREPO + ")."
                    )

                    .setAuthor("Hi i am your Senpai", null, Bot.jda.getSelfUser().getAvatarUrl());
            event.getTextChannel().sendMessage(eb.build()).queue();
        }

    }
}
