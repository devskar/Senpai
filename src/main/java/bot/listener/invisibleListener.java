package bot.listener;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 23.05.2018
 * github.com/oskardevkappa/
 */

public class invisibleListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if(event.getMember().getOnlineStatus() == OnlineStatus.OFFLINE){

            event.getChannel().sendMessage("It's not cool to hide from stalkers. " + event.getMember().getAsMention()).queue();

        }

    }
}
