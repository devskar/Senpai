package bot.listener;

import bot.Senpai.Bot;
import bot.stuff.Check;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class selfMessageListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getMessage().getAuthor() == Bot.jda.getSelfUser()){
            if (Check.Perms( Permission.MESSAGE_MANAGE, event.getGuild().getSelfMember(), event.getGuild())) {
                event.getMessage().delete().queueAfter(60, TimeUnit.SECONDS);
            }
        }

    }
}
