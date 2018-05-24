package bot.other;

import bot.Senpai.Bot;
import bot.stuff.Stats;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Game;

import java.time.Instant;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Coded by Oskar#7402
 * At 09.05.2018
 * github.com/oskardevkappa/
 */

public class GameHandler {

    public static void start(){

        JDA jda = Bot.jda;
        Timer t = new Timer();
        t.schedule(new TimerTask() {

            public void run() {

                int count = 0;
                if(count == 4) count =0;
                switch(count){
                    case 0: jda.getPresence().setGame(Game.watching("out for commands!"));
                        break;
                    case 1: jda.getPresence().setGame(Game.listening("your calls!"));
                        break;
                    case 2: jda.getPresence().setGame(Game.playing("in another League"));
                        break;
                    case 3: jda.getPresence().setGame(Game.playing("with " + Stats.Members() + " Users!"));
                        break;
                }count ++;
            }
        }, Date.from(Instant.now()), 30000);
    }



}
