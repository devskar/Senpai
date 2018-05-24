package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 10.05.2018
 * github.com/oskardevkappa/
 */

public class Invite implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        Guild g = event.getGuild();
        if (Check.Perms(Permission.CREATE_INSTANT_INVITE, event.getMember(), event.getGuild())) {
            String inv = g.getTextChannels().get(0).createInvite().setMaxAge(0).complete().getURL();
            event.getChannel().sendMessage(inv).queue();
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
        return new String[0];
    }

    @Override
    public String name() {
        return "invite";
    }

    @Override
    public boolean visible() {
        return true;
    }

    @Override
    public void executed(boolean safe, GuildMessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, GuildMessageReceivedEvent event) {
        return false;
    }
}
