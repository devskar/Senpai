package bot.stuff;

import bot.Senpai.Bot;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class Check {

    public static boolean tcByName(String name, Guild g){
        return g.getTextChannelsByName(name, false).size() != 0;
    }

    public static boolean tcByID(String id, Guild g){

        return g.getTextChannelById(id) != null;

    }

    public static boolean vcByName(String name, Guild g){

        return g.getVoiceChannelsByName(name, false).size() != 0;

    }

    public static boolean vcByID(String id, Guild g){

        return g.getVoiceChannelById(id) != null;
    }

    public static boolean mByName(String name, Guild g){

        return g.getMembersByName(name, false).size() != 0;
    }

    public static boolean mByID(String id, Guild g){

        return g.getMemberById(Long.getLong(id)) != null;

    }

    public static boolean uByIDpub(String id){

        return Bot.jda.getUserById(id) != null;

    }

    public static boolean isInteger(String numb) {
        try {
            Integer.parseInt(numb);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }

    }

    public static boolean isLong(String numb) {
        try {
            Long.getLong(numb);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDev(User u){

        return u.getId().equals("226011931935375360") || u.getId().equals("231422116338073600");

    }

    public static boolean Perms(Permission perm, Member m, Guild g){

        return g.getSelfMember().getPermissions().contains(perm) && m.getPermissions().contains(perm);

    }
}
