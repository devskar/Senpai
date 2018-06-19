package bot.commands.owner;

import bot.commands.Command;
import bot.other.CommandManagerDos;
import bot.other.PermissionState;
import bot.stuff.Check;
import com.google.gson.Gson;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Coded by Oskar#7402
 * At 01.06.2018
 * github.com/oskardevkappa/
 */

public class Test extends CommandManagerDos
{


    public Test(String[] names, int lenght, boolean shown, Permission perm, Message msg) {
        super(names, lenght, shown, perm, msg);
    }
}
