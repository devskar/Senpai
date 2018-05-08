package bot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class Bot {

    public static JDABuilder builder;
    public static JDA jda;

    public static void main(String[] args){

        builder = new JDABuilder(AccountType.BOT)
                .setAutoReconnect(true)
                .setToken(Privat.TOKEN);

        try {
            jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addCommands();
        addListener();
    }

    public static void addCommands(){



    }

    public static void addListener(){


    }

}
