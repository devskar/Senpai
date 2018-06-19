package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Messages;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

/**
 * Coded by Oskar#7402
 * At 16.06.2018
 * github.com/oskardevkappa/
 */

public class League extends Orianna implements Command  {

    private GuildMessageReceivedEvent event;



    @Override
    public void action(String[] args, GuildMessageReceivedEvent event)
    {


        if (args.length < 1)
        {
            Messages.sendError("0004", event.getChannel());
            return;
        }

        this.event = event;

        setRiotAPIKey(Privat.RIOTAPIKEY);
        setDefaultRegion(Region.EUROPE_WEST);

        switch (args[0])
        {
            case "profile":

                break;

            case "top":
                top();
                break;

        }
    }

    @Override
    public String help()
    {
        return "";
    }

    @Override
    public String description()
    {
        return "Gives you information about League of Legends.";
    }

    @Override
    public String[] alias()
    {
        return new String[]{"lol"};
    }

    @Override
    public String name()
    {
        return "League";
    }

    @Override
    public boolean visible()
    {
        return true;
    }


    private void top()
    {

        String string = Orianna.getRunes().toString();

        event.getChannel().sendMessage(string).queue();

    }
}
