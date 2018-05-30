package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.FileManager;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Coded by Oskar#7402
 * At 30.05.2018
 * github.com/oskardevkappa/
 */

public class YoMamma implements Command {

    private static final String path = "src/main/java/bot/files/YoMamma.txt";

    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        if (event.getMessage().getMentionedMembers().size() < 1){
            Messages.sendError("0009", event.getChannel());
            return;
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int line = random.nextInt(1, FileManager.lineCount(path));

        String joke = FileManager.getLine(path, line);

        event.getChannel().sendMessage(joke + " " + event.getMessage().getMentionedMembers().get(0).getAsMention()).queue();
    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <@user>";
    }

    @Override
    public String description() {
        return "Insult someones mama";
    }

    @Override
    public String[] alias() {
        return new String[]{"insult"};
    }

    @Override
    public String name() {
        return "YoMamma";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
