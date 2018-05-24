package bot.listener;

import bot.Privat;
import bot.other.commandHandler;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class commandListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if(event.getMessage().getContentDisplay().startsWith(Privat.Prefix)){
                commandHandler.handlerCommand(commandHandler.parse.parser(event.getMessage().getContentDisplay(), event));

        }
    }
}