package bot.Senpai;

import bot.Privat;
import bot.botlists.InsertStats;
import bot.commands.everyone.*;
import bot.commands.everyone.Error;
import bot.listener.commandListener;
import bot.other.commandHandler;
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

        addCommands();
        addListener();

        try {
            jda = builder.buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void addCommands(){
        commandHandler.commands.put(new Help().name(), new Help());
        commandHandler.commands.put("ping", new Ping());
        commandHandler.commands.put("random", new Random());
        commandHandler.commands.put("invite", new Inivte());
        commandHandler.commands.put("error", new Error());
    }

    public static void addListener(){
        builder.addEventListener(
                new commandListener()/*,
                new InsertStats()*/);
    }
}
