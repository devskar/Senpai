package bot.commands.owner;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import static bot.Senpai.Bot.jda;

/**
 * Coded by Oskar#7402
 * At 21.05.2018
 * github.com/oskardevkappa/
 */

public class Guilds implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        if (!Check.isDev(event.getAuthor()))
            return;

        PrivateChannel pc = event.getAuthor().openPrivateChannel().complete();
        StringBuilder sb = new StringBuilder();

        int i = 0;

        for(Guild g : jda.getGuilds()){
            i++;
            String msize;
            msize = String.valueOf(g.getMembers().size());

            sb.append("Name: " + g.getName() + "\n" +
                    "Owner: " + g.getOwner().getUser().getName() + "\n" +
                    "Members: " + msize + "\n" +
                    "ID: " + g.getId() + "\n\n");
        }

        pc.sendMessage(sb.toString()).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "List of Guilds";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "guilds";
    }

    @Override
    public boolean visible() {
        return false;
    }

}
