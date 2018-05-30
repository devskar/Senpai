package bot.commands.everyone;

import bot.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Coded by Oskar#7402
 * At 30.05.2018
 * github.com/oskardevkappa/
 */

public class Coin implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        ThreadLocalRandom r = ThreadLocalRandom.current();

        int i = r.nextInt(1, 2);

        String answere = null;

        if (i == 1)
            answere = "Yes";
        if (i == 2)
            answere = "No";



        event.getChannel().sendMessage(answere).queue();



    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String description() {
        return "Gives you a yes no answer!";
    }

    @Override
    public String[] alias() {
        return new String[]{"flip", "coinflip", "yn", "flipcoin"};
    }

    @Override
    public String name() {
        return "coin";
    }

    @Override
    public boolean visible() {
        return false;
    }
}
