package bot.other;


import bot.Privat;
import bot.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Coded by Oskar#7402
 * At 28.05.2018
 * github.com/oskardevkappa/
 */

public class CommandManager extends ListenerAdapter {

    public static List<Command> commands = new ArrayList<>();
    private String prefix = Privat.realPrefix;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        System.out.println("(" + event.getGuild().getName() + " " + event.getChannel().getName() + "" + ") " + "[" + event.getAuthor().getName() + "] " + event.getMessage().getContentRaw());

        for (Command cmd : commands) {
            //Adding all aliases to a List + the name because im to bored to add all the names to the aliases array
            List<String> aliases = new ArrayList<>();
            aliases.add(cmd.name());
            aliases.addAll(Arrays.asList(cmd.alias()));

            //Creating a List so you can write the commands with a gap and without one
            List<String> starts = new ArrayList<>();

            for (String s : aliases ) {
                starts.add(prefix + s);
                starts.add(prefix + " " + s);
            }

            //Making a String so you can wirte the command in any case you want
            String command = event.getMessage().getContentRaw();

            //Checking if the Message starts with the Command and if then executing the command
            for (String start : starts) {
                if (command.toLowerCase().startsWith(start.toLowerCase())) {
                    cmd.action(argsConverter(command, start), event);
                    return;
                }
            }
        }
    }

    public String[] argsConverter(String raw, String cmd){

        String command = cmd.replace(prefix, "");

        while (command.endsWith(" ")) {
            command = command.substring(0, command.length() - 1);
        }

        while (command.startsWith(" ")) {
            command = command.replaceFirst(" ", "");
        }

        String one = raw.replaceFirst("(?i)" + prefix, "").replaceFirst("(?i)" + command, "");

        while (one.startsWith(" ")) {
            one = one.replaceFirst(" ", "");
        }


        if (one.equals(""))
            return new String[0];

        return one.split(" ");
    }
}
