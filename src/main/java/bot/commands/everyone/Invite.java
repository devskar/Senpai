package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.function.Consumer;

/**
 * Coded by Oskar#7402
 * At 29.05.2018
 * github.com/oskardevkappa/
 */

public class Invite implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        Guild g = event.getGuild();

        //Just checking if the user is allowed to create an invite
        if (Check.Perms(Permission.CREATE_INSTANT_INVITE, event.getMember(), event.getGuild())) {

            //Creating the invite and get the Url
            final String[] inv = new String[1];
            g.getTextChannels().get(0).createInvite().setMaxAge(0).queue(new Consumer<net.dv8tion.jda.core.entities.Invite>() {
                @Override
                public void accept(net.dv8tion.jda.core.entities.Invite invite) {
                    inv[0] = invite.getURL();
                }
            });

            //Send the invite
            event.getChannel().sendMessage("Here is your invite " + event.getMember().getAsMention() + " " + inv[0]).queue();
        } else{

            event.getChannel().sendMessage("Error#0001").queue();
        }

    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Let the bot create an invite.";
    }

    @Override
    public String[] alias() {
        return new String[]{"inv"};
    }

    @Override
    public String name() {
        return "invite";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
