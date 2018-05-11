package bot.commands.moderator;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.FileManager;
import bot.stuff.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class JoinMessage implements Command {

    private static final String path = "src/main/java/bot/files/JoinMessage.txt";

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (!Check.Perms(Permission.MANAGE_CHANNEL, event.getMember(), event.getGuild())){
            Messages.sendError("0001", event.getTextChannel());
            return;
        }

        if (args.length < 2){
            Messages.sendError("0004", event.getTextChannel());
            return;
        }

        if (!Check.isLong(args[0])){
            Messages.sendError("0002", event.getTextChannel());
            return;
        }

        if(!Check.tcByID(args[0], event.getGuild())){
            Messages.sendError("0008", event.getTextChannel());
            return;
        }

        FileManager.write(path, event.getGuild().getId());

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " [ChannelID] [Message (You can use %user% and %guild%)]";
    }

    @Override
    public String description() {
        return "Set the joinmessage when a user joins.";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "joinmessage";
    }

    @Override
    public void executed(boolean safe, MessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }
}
