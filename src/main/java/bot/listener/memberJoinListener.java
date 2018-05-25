package bot.listener;

import bot.Senpai.database;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 24.05.2018
 * github.com/oskardevkappa/
 */

public class memberJoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        new database().writeUser(event.getUser());

    }
}
