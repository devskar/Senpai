package bot.commands.owner;

import bot.commands.Command;
import bot.stuff.Check;
import com.google.gson.Gson;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Coded by Oskar#7402
 * At 01.06.2018
 * github.com/oskardevkappa/
 */

public class Test implements Command
{


    @Override
    public void action(String[] args, GuildMessageReceivedEvent event)
    {

        if (!Check.isDev(event.getAuthor()))
            return;


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
        return "test";
    }

    @Override
    public boolean visible() {
        return false;
    }
}
