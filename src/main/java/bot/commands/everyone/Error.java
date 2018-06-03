package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.FileManager;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 28.05.2018
 * github.com/oskardevkappa/
 */

public class Error implements Command {

    // TODO: 29.05.2018 Adding Comments

    private static final String path = "src/main/files/Errors.txt";

    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        //Checking if all arguments are given
        if(args.length < 1){
            Messages.sendError("0004", event.getChannel());
            return;
        }

        //Just if somebody writes the whole error
        if(args[0].contains("#")){
            args[0].replace("#", "");
        }
        if(args[0].toLowerCase().contains("error")){
            args[0].replaceAll("(?i)" + "Error", "");
        }

        if (Check.isInteger(args[0])){
            if(FileManager.lookForBool(path, args[0])) {
                String[] Error = FileManager.lookFor(path, args[0]);

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < Error.length; i++){
                    sb.append(Error[i] + " ");
                }

                event.getChannel().sendMessage(Messages.markdown("Error#" + args[0], sb.toString().replace(args[0], ""))).queue();
            }else{
                Messages.sendError("0003", event.getChannel());
            }
        }else{
            Messages.sendError("0002", event.getChannel());
        }

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " [id]";
    }

    @Override
    public String description() {
        return "Gives you a description of an error.";
    }


    @Override
    public String[] alias() {
        return new String[]{"Err"};
    }

    @Override
    public String name() {
        return "Error";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
