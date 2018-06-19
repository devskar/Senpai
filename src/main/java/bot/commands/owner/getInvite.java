package bot.commands.owner;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.function.Consumer;

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

        final String[] inv = new String[1];

        jda.getGuildById(args[0]).getTextChannels().get(0).createInvite().setMaxUses(1).setMaxAge(0).queue(new Consumer<Invite>() {
            @Override
            public void accept(Invite invite) {
                inv[0] = invite.getURL();
            }
        });

        event.getChannel().sendMessage(inv[0]).queue();

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
