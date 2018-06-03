package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.other.CommandManager;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Coded by Oskar#7402
 * At 28.05.2018
 * github.com/oskardevkappa/
 */

public class Help implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {


        List<Command> cmds = CommandManager.commands;


        int size = 0;

        //Checking if any arguments are given
        if(args.length == 0){
            StringBuilder sb = new StringBuilder();

            sb.append("=== Help ===\n\n");
            for (Command c: cmds) {
                //Checks if the command should be shown
                if(c.visible()) {
                    //Adding all commands
                    sb.append("= " + c.name().toLowerCase() + " =\n" +
                            "[" + c.description() + "]\n" +
                            "Aliases: " + Arrays.toString(c.alias()).toLowerCase() + "\n\n");
                    size++;
                }
            }

            sb.append("\nLoaded " + size + " Commands!");


            //Sending help message
            event.getChannel().sendMessage("```asciidoc\n" +
                    sb.toString() + "```").queue();

        }else{
            //here we go to the help Message foreach command
            String command =  args[0];

            int i = 0;
            int x = 0;
            //Now we looking throw each command and all his aliases
            for (Command c: cmds) {

                //Creating a list and paste every name of a command in there
                List<String> all = new ArrayList<>();
                all.addAll(Arrays.asList(c.alias()));
                all.add(c.name());

                //Now we lookin for all of these commands and if there is a match we send the help message
                for (String cmd : all ) {
                    x++;
                    if (command.equalsIgnoreCase(cmd)) {

                        StringBuilder sb = new StringBuilder();

                        sb.append("=== Help for " + c.name().toLowerCase() + "===\n\n");

                        sb.append("Usage: \n[" + c.help() + "]\n\n" +
                                  "Description: \n[" + c.description() + "]\n\n" +
                                  "Aliases: \n" + Arrays.toString(c.alias()).toLowerCase() + "\n\n");

                        //Sending help message
                        event.getChannel().sendMessage("```asciidoc\n" +
                                sb.toString() + "```").queue();

                    } else {
                        //We are adding a number here so we can check if we ran throw all commands
                        i++;
                    }
                }
            }

            //Check it
            if (i == x){
                Messages.sendError("0003", event.getChannel());
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
    public boolean visible() {
        return true;
    }

}
