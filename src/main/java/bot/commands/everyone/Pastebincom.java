package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Messages;
import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.paste.PasteBuilder;
import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.response.Response;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Coded by Oskar#7402
 * At 30.05.2018
 * github.com/oskardevkappa/
 */

public class Pastebincom implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        StringBuilder builder = new StringBuilder();
        for(String s : args) {
            builder.append(s + " ");
        }

        String str = builder.toString();

        String[] arr = str.split("\\|");

        if (arr.length < 2){
            Messages.sendError("0004", event.getChannel());
            return;
        }

        String title = arr[0];
        String content = arr[1];


        PastebinFactory factory = new PastebinFactory();
        Pastebin pastebin = factory.createPastebin(Privat.PASTEBINTOKEN);

        // get a pastebuilder to build the paste I want to publish
        PasteBuilder pasteBuilder = factory.createPaste();

        pasteBuilder.setTitle(title);

        pasteBuilder.setRaw(content);

        pasteBuilder.setMachineFriendlyLanguage("text");

        pasteBuilder.setVisiblity(PasteVisiblity.Unlisted);

        pasteBuilder.setExpire(PasteExpire.OneHour);

        pasteBuilder.build();

        Paste paste = pasteBuilder.build();

        Response<String> postResult = pastebin.post(paste);

        if (postResult.hasError()) {
            event.getChannel().sendMessage(event.getMember().getAsMention() + " Sorry can't post your paste").queue();
            System.out.println(postResult.getError());
            return;
        }

        event.getChannel().sendMessage(event.getMember().getAsMention() + " Paste successfully created: " + postResult.get()).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <Title> | <Text>";
    }

    @Override
    public String description() {
        return "Posts something on Pastebin.com";
    }

    @Override
    public String[] alias() {
        return new String[]{"paste", "post", "pstbn"};
    }

    @Override
    public String name() {
        return "Pastebin";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
