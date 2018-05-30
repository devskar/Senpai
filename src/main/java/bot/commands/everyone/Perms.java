package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 29.05.2018
 * github.com/oskardevkappa/
 */

public class Perms implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {


        //Array of permissions the bot should have
        Permission[] perms = {Permission.MESSAGE_WRITE, Permission.MESSAGE_READ, Permission.MESSAGE_MANAGE, Permission.MESSAGE_ADD_REACTION, Permission.MESSAGE_EMBED_LINKS, Permission.ADMINISTRATOR};

        //New EmbedBuilder
        EmbedBuilder eb = Messages.embed(event.getGuild().getSelfMember());

        //Now checking if the bot got the permissions from the array
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
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "List of permissions Senpai should have.";
    }

    @Override
    public String[] alias() {
        return new String[]{"Permissions"};
    }

    @Override
    public String name() {
        return "perms";
    }

    @Override
    public boolean visible() {
        return true;
    }

}
