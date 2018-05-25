package bot.commands.owner;

import bot.Senpai.database;
import bot.commands.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 24.05.2018
 * github.com/oskardevkappa/
 */

public class dbtest implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        for (Guild g : event.getJDA().getGuilds()) {
            for (Member m : g.getMembers()) {
                new database().writeUser(m.getUser());
            }
        }
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
        return "dbtest";
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
