package bot.commands.owner;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import static bot.Senpai.Bot.jda;

/**
 * Coded by Oskar#7402
 * At 21.05.2018
 * github.com/oskardevkappa/
 */

public class getInvite implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        if(!Check.isDev(event.getAuthor()))
            return;

        net.dv8tion.jda.core.entities.Invite inv = jda.getGuildById(args[0]).getTextChannels().get(0).createInvite().setMaxAge(0).complete();

        event.getChannel().sendMessage(inv.getURL()).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <ID>";
    }

    @Override
    public String description() {
        return "Gives you an invite of a guild.";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "getInvite";
    }

    @Override
    public boolean visible() {
        return false;
    }

}
