package bot.other;

import bot.Privat;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class commandParser {

    public commandContainer parser(String raw, MessageReceivedEvent event) {
        String beheaded = raw.replaceFirst(Privat.Prefix, "");
        String[] splitBeheaded = beheaded.split(" ");
        String invoke = splitBeheaded[0];
        ArrayList<String> split = new ArrayList<>();
        for ( String s : splitBeheaded) {
            split.add(s);
        }
        String[] args = new String[split.size() -1];
        split.subList(1, split.size()).toArray(args);
        event.getMessage().delete().queueAfter(3, TimeUnit.SECONDS);


        return new commandContainer(raw, beheaded, splitBeheaded, invoke, args, event);
    }

    public static class commandContainer {

        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public commandContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = rw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitBeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }

    }

}