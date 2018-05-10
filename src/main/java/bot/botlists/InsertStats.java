package bot.botlists;


import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 10.05.2018
 * github.com/oskardevkappa/
 */

public class InsertStats extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        new Apis();
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        new Apis();
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent event) {
        new Apis();
    }
}
