package bot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public interface Command {

    void action(String[] args, MessageReceivedEvent event);

    void executed(boolean safe, MessageReceivedEvent event);

    boolean called(String[] args, MessageReceivedEvent event);
}
