
package bot.Senpai;

import bot.Privat;
import bot.commands.everyone.*;
import bot.commands.everyone.Error;
import bot.commands.moderator.Clear;
import bot.commands.moderator.MoveAll;
import bot.commands.owner.Guilds;
import bot.commands.owner.dbtest;
import bot.commands.owner.getInvite;
import bot.listener.*;
import bot.other.GameHandler;
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


    public static void main(String args[]){

        new database().Connect();

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
        GameHandler.start();
    }

    public static void addCommands(){
        commandHandler.commands.put(new Help().name(), new Help());
        commandHandler.commands.put(new Ping().name(), new Ping());
        commandHandler.commands.put(new Random().name(), new Random());
        commandHandler.commands.put(new Invite().name(), new Invite());
        commandHandler.commands.put(new Error().name(), new Error());
        commandHandler.commands.put(new MoveAll().name(), new MoveAll());
        commandHandler.commands.put(new Clear().name(), new Clear());
        commandHandler.commands.put(new Botstats().name(), new Botstats());
        commandHandler.commands.put(new User().name(), new User());
/*        commandHandler.commands.put(new JoinMessage().name(), new JoinMessage());*/
        commandHandler.commands.put("test", new Test());
        commandHandler.commands.put(new Emojis().name(), new Emojis());
        commandHandler.commands.put(new Guilds().name(), new Guilds());
        commandHandler.commands.put(new getInvite().name(), new getInvite());
        //commandHandler.commands.put("eval", new Eval());
        commandHandler.commands.put(new Perms().name(), new Perms());
        commandHandler.commands.put(new dbtest().name(), new dbtest());
    }

    public static void addListener(){
        builder.addEventListener(
                new commandListener(),
                new mentionListener(),
                new selfMessageListener(),
                new Introduction(),
                new invisibleListener()
                /*,
                new InsertStats()*/);
    }
}
