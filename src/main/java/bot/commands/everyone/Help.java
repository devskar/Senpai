package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.other.commandHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 09.05.2018
 * github.com/oskardevkappa/
 */

public class Help implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        StringBuilder sb = new StringBuilder();

        Command[] cmds = commandHandler.commands.values().toArray(new Command[0]);

        sb.append("=== Help ===\n\n");
        for (Command c: cmds) {
            sb.append("= " + c.name() + " =\n" +
                      "[" + c.description() + "]\n");
        }

        sb.append("\nLoaded " + commandHandler.commands.size() + " Commands!");

        event.getTextChannel().sendMessage("```asciidoc\n" +
                                            sb.toString() + "```").queue();
    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Sends a help message.";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "help";
    }

    @Override
    public void executed(boolean safe, MessageReceivedEvent event) {
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }
}
