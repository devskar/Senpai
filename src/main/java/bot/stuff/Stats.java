package bot.stuff;

import bot.Senpai.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class Stats {

    static JDA jda = Bot.jda;

    public static int Roles(){
        int i = 0;
        for (Guild g: jda.getGuilds() ) {
            i = i + g.getRoles().size();
        }
        return i;
    }

    public static int Guilds(){
        return jda.getGuilds().size();
    }

    public static int VoiceChannels(){
        int i = 0;
        for (Guild g : jda.getGuilds()){
            i = i + g.getVoiceChannels().size();
        }
        return i;
    }

    public static int TextChannels(){
        int i = 0;
        for (Guild g : jda.getGuilds()){
            i = i + g.getTextChannels().size();
        }
        return i;
    }

    public static int Members(){
        int i = 0;
        for (Guild g : jda.getGuilds()){
            i = i + g.getMembers().size();
        }
        return i;
    }

    public static int MemberInVC(){
        int i = 0;
        for (Guild g : jda.getGuilds()){
            i = i + g.getVoiceStates().size();
        }
        return i;
    }

    public static int Emotes(){
        int i = 0;
        for (Guild g : jda.getGuilds()){
            i = i + g.getEmotes().size();
        }
        return i;
    }

    public static int Categories(){
        int i = 0;
        for (Guild g : jda.getGuilds()){
            i = i + g.getCategories().size();
        }
        return i;
    }

}
