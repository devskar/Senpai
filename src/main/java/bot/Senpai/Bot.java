
package bot.Senpai;

import bot.Privat;

import bot.commands.everyone.Error;
import bot.commands.moderator.Clear;
import bot.commands.moderator.MoveAll;
import bot.commands.owner.Guilds;
import bot.commands.owner.PN;
import bot.commands.owner.Say;
import bot.commands.owner.getInvite;
import bot.listener.*;
import bot.commands.everyone.*;
import bot.other.CommandManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

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

        jda.getPresence().setGame(Game.playing("on beta"));
    }

    public static void addCommands(){

        CommandManager.commands.add(new Botstats());
        CommandManager.commands.add(new Emotes());
        CommandManager.commands.add(new Error());
        CommandManager.commands.add(new Help());
        CommandManager.commands.add(new Invite());
        CommandManager.commands.add(new Perms());
        CommandManager.commands.add(new Ping());
        CommandManager.commands.add(new Random());
        CommandManager.commands.add(new Clear());
        CommandManager.commands.add(new Friends());
        CommandManager.commands.add(new MoveAll());
        CommandManager.commands.add(new Banner());
        CommandManager.commands.add(new User());
        CommandManager.commands.add(new Coin());
        CommandManager.commands.add(new YoMamma());
        CommandManager.commands.add(new Pastebincom());
        CommandManager.commands.add(new PN());
        CommandManager.commands.add(new Guilds());
        CommandManager.commands.add(new RoleAdd());
        CommandManager.commands.add(new Say());
        CommandManager.commands.add(new getInvite());
        CommandManager.commands.add(new League());
        CommandManager.commands.add(new Beta());

    }

    public static void addListener(){
        builder.addEventListener(
                new CommandManager(),
                new mentionListener(),
                //new selfMessageListener(),
                new Introduction(),
                new Conversatioin(),
                new PrivateMessage()
                //new invisibleListener()
                /*,
                new InsertStats()*/);
    }
}
