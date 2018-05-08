package bot.commands.everyone;

import bot.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class Ping implements Command {
    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("pong").queue();
    }

    @Override
    public void executed(boolean safe, MessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }
}
