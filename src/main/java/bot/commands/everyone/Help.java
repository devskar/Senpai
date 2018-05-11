package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.other.commandHandler;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 09.05.2018
 * github.com/oskardevkappa/
 */

public class Help implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Command[] cmds = commandHandler.commands.values().toArray(new Command[0]);

        if(args.length < 1){
            StringBuilder sb = new StringBuilder();

            sb.append("=== Help ===\n\n");
            for (Command c: cmds) {
                sb.append("= " + c.name() + " =\n" +
                        "[" + c.description() + "]\n");
            }

            sb.append("\nLoaded " + commandHandler.commands.size() + " Commands!");

            event.getTextChannel().sendMessage("```asciidoc\n" +
                    sb.toString() + "```").queue();
        }else{

            String command =  args[0];

            int i = 0;

            for (Command c: cmds) {
                if (command.equalsIgnoreCase(c.name())){
                    event.getTextChannel().sendMessage(Messages.embed(event.getGuild().getSelfMember()).setDescription(Messages.markdown("Command " + c.name(), c.help())).build()).queue();
                }else{
                    i++;
                }
            }

            if (i == cmds.length){
                Messages.sendError("0003", event.getTextChannel());
            }
        }

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + "\n " +
                Privat.Prefix + name() + "[Command]";
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
