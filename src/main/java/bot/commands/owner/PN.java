package bot.commands.owner;

import bot.Privat;
import bot.Senpai.Bot;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 31.05.2018
 * github.com/oskardevkappa/
 */

public class PN implements Command {


    @Override
    public void action(String[] args, GuildMessageReceivedEvent event)
    {

        if (!Check.isDev(event.getAuthor()))
            return;

        if (args.length < 2)
        {
            Messages.sendError("0004", event.getChannel());
            return;
        }

        if (!Check.isLong(args[0]))
        {
            Messages.sendError("0002", event.getChannel());
            return;
        }

        String id = args[0];

        if (!Check.uByIDpub(id))
        {
            Messages.sendError("0010", event.getChannel());
            return;
        }

        if (event.getMessage().getMentionedMembers().get(0) == event.getGuild().getSelfMember())
        {

            Messages.sendError("0011", event.getChannel());
            return;
        }

        User u = Bot.jda.getUserById(id);

        StringBuilder msgBuilder = new StringBuilder();

        for (String s: args)
        {
            msgBuilder.append(s).append(" ");
        }

        String msg = msgBuilder.toString();

        msg = msg.replace(u.getId() + " ", "");

        String finalMsg = msg;

        u.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(finalMsg).queue());
        }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <ID> <Message>";
    }

    @Override
    public String description() {
        return "Sends an user a private Message.";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "pn";
    }

    @Override
    public boolean visible() {
        return false;
    }
}
