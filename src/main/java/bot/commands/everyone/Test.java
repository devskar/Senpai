package bot.commands.everyone;

import bot.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class Test implements Command{
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        if (args.length < 0)
            event.getChannel().sendMessage("<0").queue();

        if (args.length < 1)
            event.getChannel().sendMessage("<1").queue();

        if (args.length == 1)
            event.getChannel().sendMessage("==1").queue();

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
    public boolean visible() {
        return false;
    }

    @Override
    public void executed(boolean safe, GuildMessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, GuildMessageReceivedEvent event) {
        return false;
    }
}
