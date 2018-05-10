package bot.botlists;

import bot.Privat;
import bot.Senpai.Bot;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.discordbots.api.client.DiscordBotListAPI;

/**
 * Coded by Oskar#7402
 * At 10.05.2018
 * github.com/oskardevkappa/
 */

public class Apis extends ListenerAdapter {

    public Apis(){
        discordbotsorg();


    }

    public static void discordbotsorg(){

        DiscordBotListAPI api = new DiscordBotListAPI.Builder()
                .token(Privat.DiscordbotsorgToken)
                .build();

        String botId = "443447273175908352";
        int serverCount = Bot.jda.getGuilds().size();
        api.setStats(botId, serverCount);
    }

}
