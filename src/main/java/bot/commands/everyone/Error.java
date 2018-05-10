package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.FileManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.File;

/**
 * Coded by Oskar#7402
 * At 10.05.2018
 * github.com/oskardevkappa/
 */

public class Error implements Command {

    private static final String path = "src/main/java/bot/files/Errors.txt";

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args[0].contains("#")){
            args[0].replace("#", "");
        }
        if(args[0].contains("Error")){
            args[0].replace("Error", "");
        }

        if (Check.isInteger(args[0])){
            if(FileManager.lookForBool(path, args[0])) {
                String[] Error = FileManager.lookFor(path, args[0]);


                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < Error.length; i++){
                    sb.append(Error[i] + " ");
                }

                event.getTextChannel().sendMessage(sb.toString().replace(args[0] + " ", "")).queue();
            }
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
        return new String[0];
    }

    @Override
    public String name() {
        return "error";
    }

    @Override
    public void executed(boolean safe, MessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }
}
