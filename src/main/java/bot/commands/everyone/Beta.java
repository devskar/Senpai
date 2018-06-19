package bot.commands.everyone;

import bot.Senpai.Bot;
import bot.commands.Command;
import net.dv8tion.jda.bot.entities.ApplicationInfo;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.function.Consumer;

/**
 * Coded by Oskar#7402
 * At 17.06.2018
 * github.com/oskardevkappa/
 */

public class Beta implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event)
    {
        event.getJDA().asBot().getApplicationInfo().queue(new Consumer<ApplicationInfo>() {
            @Override
            public void accept(ApplicationInfo applicationInfo)
            {

                Member m = event.getGuild().getMemberById(applicationInfo.getOwner().getId());
                event.getChannel().sendMessage("Owner: " + m.getAsMention() + "\n ID: " + m.getUser().getId()).queue();
            }
        });
    }

    @Override
    public String help()
    {
        return null;
    }

    @Override
    public String description()
    {
        return null;
    }

    @Override
    public String[] alias()
    {
        return new String[0];
    }

    @Override
    public String name()
    {
        return "beta";
    }

    @Override
    public boolean visible()
    {
        return false;
    }
}
