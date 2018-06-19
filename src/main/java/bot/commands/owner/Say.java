package bot.commands.owner;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.FileManager;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;


/**
 * Coded by Oskar#7402
 * At 06.06.2018
 * github.com/oskardevkappa/
 */

public class Say implements Command {

    private final String path = "src/main/files/Errors.txt";

    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        if (!Check.isDev(event.getAuthor()))
        {
            event.getChannel().sendMessage("Missing permission").queue();
            return;
        }

        if (args.length < 1)
        {
            event.getChannel().sendMessage(help()).queue();
            return;
        }

        if(!FileManager.lookForBool(path, args[0]))
        {
            event.getChannel().sendMessage("Cannot find an emote with this name").queue();
            return;
        }

        String[] result = FileManager.lookFor(path, args[0]);

        if (result.length < 2)
        {
            System.out.println("Error in say");
        }

        event.getChannel().sendMessage(result[1]).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Sends a special emote kappa.";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "say";
    }

    @Override
    public boolean visible() {
        return false;
    }
}
