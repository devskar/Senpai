package bot.stuff;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class Messages {

    public static void error(TextChannel tc, String content){

        EmbedBuilder eb = new EmbedBuilder()
                .setColor(Color.red)
                .setTitle("Error")
                .setDescription(":warning: " + content);

        tc.sendMessage(eb.build()).queue(msg -> {msg.delete().queueAfter(5, TimeUnit.SECONDS);});
    }

    public static EmbedBuilder embed(Member m){

        EmbedBuilder eb = new EmbedBuilder()
                .setColor(m.getRoles().get(0).getColor());

        return eb;

    }


}
