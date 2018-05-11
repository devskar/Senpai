package bot.commands.everyone;

import bot.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class Test implements Command{
    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (args.length < 0)
            event.getTextChannel().sendMessage("<0").queue();

        if (args.length < 1)
            event.getTextChannel().sendMessage("<1").queue();

        if (args.length == 1)
            event.getTextChannel().sendMessage("==1").queue();

    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void executed(boolean safe, MessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }
}
