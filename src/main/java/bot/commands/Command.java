package bot.commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public interface Command {

    void action(String[] args, GuildMessageReceivedEvent event);

    String help();

    String description();

    String[] alias();

    String name();

    boolean visible();


}
