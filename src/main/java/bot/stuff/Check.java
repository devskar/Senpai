package bot.stuff;

import net.dv8tion.jda.core.entities.Guild;

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

}
