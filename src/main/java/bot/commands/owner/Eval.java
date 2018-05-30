package bot.commands.owner;

import bot.commands.Command;
import bot.stuff.Check;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.MessageFormat;

/**
 * Coded by Oskar#7402
 * At 22.05.2018
 * github.com/oskardevkappa/
 */

public class Eval implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        if(!Check.isDev(event.getAuthor()))
            return;

        ScriptEngine se = new ScriptEngineManager().getEngineByName("Nashorn");
        try {
            se.eval("var imports = new JavaImporter(" +
                    "java.nio.file," +
                    "Packages.net.dv8tion.jda.core," +
                    "java.lang," +
                    "java.lang.management," +
                    "java.text," +
                    "java.sql," +
                    "java.util," +
                    "java.time," +
                    "Packages.com.sun.management" +
                    ");");
        } catch (ScriptException er) {
            er.printStackTrace();
        }
        se.put("jda", event.getJDA());
        se.put("guild", event.getMessage().getGuild());
        se.put("channel", event.getMessage().getChannel());
        se.put("message", event.getMessage());
        se.put("author", event.getMessage().getAuthor());

        String modified_msg = String.join(" ", args)
                .replace("getToken", "getChannel()()ById(channel.getId()).sendMessage(\"UnsupportedOperationException(\\\"Nice try m8!\\\")\").queue");
        modified_msg = modified_msg.replaceAll("#", "().");

        try {
            Object out = se.eval(
                    "{" +
                            "with (imports) {" +
                            modified_msg +
                            "}" +
                            "};");

            if (out == null) {
                out = "Your action..<promise pending>";
            }

            event.getMessage().getChannel().sendMessage(new StringBuilder().append("```Java\n").append(modified_msg)
                    .append("```Evaluated successfully:").toString()).queue();
            new MessageBuilder().appendCodeBlock(out.toString(), "Java").buildAll(MessageBuilder.SplitPolicy.NEWLINE, MessageBuilder.SplitPolicy.SPACE, MessageBuilder.SplitPolicy.ANYWHERE).forEach(message -> event.getChannel().sendMessage(message).queue());
        } catch (ScriptException er) {
            event.getMessage().getChannel().sendMessage(new StringBuilder().append("```Java\n").append(modified_msg)
                    .append(MessageFormat.format("``` ```Java\nAn exception was thrown:{0}```", er.toString())).toString()).queue();
        }

    }


    @Override
    public String help() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean visible() {
        return true;
    }

}
