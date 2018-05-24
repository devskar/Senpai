package bot.commands.moderator;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class Clear implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        TextChannel tc = event.getChannel();


        if(args.length < 1){
            Messages.sendError("0004", event.getChannel());

        }

        if (!Check.isInteger(args[0])){
            Messages.sendError("0002", event.getChannel());
            return;
        }

        int amount = Integer.parseInt(args[0]);

        if (!(amount > 1)){
            Messages.sendError("0007", tc);
            return;
        }

        if (!(amount <= 100)){
            Messages.sendError("0006", tc);
            return;
        }

        if (!Check.Perms(Permission.MESSAGE_MANAGE, event.getMember(), event.getGuild())){
            Messages.sendError("0001", tc);
            return;
        }

        event.getMessage().delete().queue();

        MessageHistory history = tc.getHistory();
        List<Message> msgs = history.retrievePast(amount).complete();
        tc.deleteMessages(msgs).queue();

        String msg = Messages.markdown("Successfully deleted Messages", "Deleted " + msgs.size() + " Messages in " + tc.getName() + ".");
        tc.sendMessage(msg).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + "[amount (between 1 and 100)]";
    }

    @Override
    public String description() {
        return "Clears an amount of messages.";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "clear";
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
