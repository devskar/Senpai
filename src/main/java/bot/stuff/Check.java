package bot.stuff;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class Check {

    public static boolean tcByName(String name, Guild g){

        if(g.getTextChannelsByName(name, false).size() == 0){
            return false;
        }else{
            return true;
        }
    }

    public static boolean tcByID(String id, Guild g){

        if(g.getTextChannelById(id) == null){
            return false;
        }else{
            return true;
        }
    }

    public static boolean vcByName(String name, Guild g){

        if(g.getTextChannelsByName(name, false).size() == 0){
            return false;
        }else{
            return true;
        }
    }

    public static boolean vcByID(String id, Guild g){

        if(g.getTextChannelById(id) == null){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isInteger(String numb) {
        try {
            Integer.parseInt(numb);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDev(User u){

        if(u.getId().equals("226011931935375360") || u.getId().equals("231422116338073600")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean Perms(Permission perm, Member m, Guild g){

        if(g.getSelfMember().getPermissions().contains(perm) && m.getPermissions().contains(perm)){
            return true;
        }else{
            return false;
        }

    }

}
