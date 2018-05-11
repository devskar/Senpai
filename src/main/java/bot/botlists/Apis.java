package bot.botlists;

import bot.Privat;
import bot.Senpai.Bot;
import bot.stuff.Stats;
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

        api.setStats(Privat.BOTID, Stats.Guilds());
    }

}
