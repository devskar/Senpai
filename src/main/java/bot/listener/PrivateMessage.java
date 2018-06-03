package bot.listener;

import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 31.05.2018
 * github.com/oskardevkappa/
 */

public class PrivateMessage extends ListenerAdapter {

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {

        if (event.getAuthor() != event.getJDA().getSelfUser()) {
            event.getJDA().getUserById("226011931935375360").openPrivateChannel().complete().sendMessage(event.getAuthor().getName() + ": " + event.getMessage().getContentRaw()).queue();
        }
    }
}
