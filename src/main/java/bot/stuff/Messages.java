package bot.stuff;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.requests.RestAction;

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

    public static String markdown(String title, String content){

        if(title == null) {
            String Markdown = "```asciidoc\n" +
                    "[" + content + "] ```";
            return Markdown;
        }

        if(content == null){
            String Markdown = "```asciidoc\n" +
                    "= " + title + " = ```";
            return Markdown;
        }

        if(!(title == null && content == null)){
            String Markdown = "```asciidoc\n" +
                    "= " + title + " = \n" +
                    "[" + content + "] ```";
            return Markdown;
        }
        return null;
    }

}
