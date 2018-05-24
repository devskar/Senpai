package bot.commands.everyone;

import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.*;

/**
 * Coded by Oskar#7402
 * At 23.05.2018
 * github.com/oskardevkappa/
 */

public class Perms implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {



        Permission[] perms = {Permission.MESSAGE_WRITE, Permission.MESSAGE_READ, Permission.MESSAGE_MANAGE, Permission.MESSAGE_ADD_REACTION, Permission.MESSAGE_EMBED_LINKS, Permission.ADMINISTRATOR};

        EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember());

        for (Permission p: perms ) {

            String value = null;
                if (Check.Perms(p, event.getGuild().getSelfMember(), event.getGuild()))
                    value = "✅";
                else
                    value ="⛔";

            eb.addField(p.getName(), value, true);
            }


        event.getChannel().sendMessage(eb.build()).queue();

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
        return "perms";
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
