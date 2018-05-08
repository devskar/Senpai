package bot.commands.everyone;

import bot.commands.Command;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class Random implements Command {
    @Override
    public void action(String[] args, MessageReceivedEvent event) {

    if((args.length < 1)){

        Messages.error(event.getTextChannel(), "test");

    }

    }

    @Override
    public void executed(boolean safe, MessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }
}
