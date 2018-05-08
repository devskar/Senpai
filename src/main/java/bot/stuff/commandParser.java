package bot.stuff;

import bot.Privat;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class commandParser {

    public commandContainer parser(String raw, MessageReceivedEvent event) {
        String one = raw.replaceFirst(Privat.Prefix, "");
        String[] two = one.split(" ");
        String command = two[0];
        ArrayList<String> split = new ArrayList<>();
        for ( String s : two) {
            split.add(s);
        }
        String[] args = new String[split.size() -1];
        split.subList(1, split.size()).toArray(args);

        return new commandContainer(raw, one, two, command, args, event);
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
