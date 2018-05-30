package bot.commands.everyone;

import bot.Privat;
import bot.Senpai.Bot;
import bot.commands.Command;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 29.05.2018
 * github.com/oskardevkappa/
 */

public class Ping implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        event.getChannel().sendMessage(Messages.embed(event.getGuild().getSelfMember()).setDescription("Ping: " + Bot.jda.getPing() + "ms").build()).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Shows the ping of the bot.";
    }

    @Override
    public String[] alias() {
        return new String[]{"connection", "conn"};
    }

    @Override
    public String name() {
        return "ping";
    }

    @Override
    public boolean visible() {
        return true;
    }

}
