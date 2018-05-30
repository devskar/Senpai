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

        tc.sendMessage(eb.build()).queue();
    }

    public static EmbedBuilder embed(Member m){

        EmbedBuilder eb = new EmbedBuilder();

            if(m.getRoles().size() == 0){
                eb.setColor(Color.white);
            }else{
                eb.setColor(m.getRoles().get(0).getColor());
            }
        return eb;
    }

    public static String markdown(String title, String text){

        String content = text;

        if (content != null) {

            while (content.endsWith(" ")) {
                content = content.substring(0, text.length() - 1);
            }

            while (content.startsWith(" ")) {
                content = content.replaceFirst(" ", "");
            }
        }

        if(title == null) {
            String Markdown = "```asciidoc\n" +
                    "[" + content + "]```";
            return Markdown;
        }

        if(content == null){
            String Markdown = "```asciidoc\n" +
                    "= " + title + " =```";
            return Markdown;
        }

        if(!(title == null && content == null)){
            String Markdown = "```asciidoc\n" +
                    "= " + title + " =\n" +
                    "[" + content + "]```";
            return Markdown;
        }
        return null;
    }

    public static void sendError(String id, TextChannel tc){
        tc.sendMessage("`Error#" + id + "`").queue();
    }

    public static String MarkDownStart = "```asciidoc\n";
    public static String MarkDownEnd = "```";

}
