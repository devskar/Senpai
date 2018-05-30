package bot.commands.moderator;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Util;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageReaction;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Coded by Oskar#7402
 * At 26.05.2018
 * github.com/oskardevkappa/
 */

public class Giveaway implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {


        String one = event.getMessage().getContentDisplay().replace(Privat.Prefix + name() + " ", "");
        String two[] = one.split("\\.");
        String price = two[0];
        int delay = Integer.parseInt(two[2]);
        String mcount = two[1];
        String timeunit = two[3];


        Message msg = event.getChannel().sendMessage("You can win " + price).complete();
        Emote emote = null;
        msg.addReaction(emote).queue();

        List<Member> members;


        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {

                for (MessageReaction mr : msg.getReactions()){
                    mr.getReactionEmote();
                }

            }
        }, Util.TimeConverter(delay, timeunit));
    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <Price>|<Winners(Amount)>|<Time>|<Timeunit(sec/min/hours/days)>";
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
        return "ga";
    }

    @Override
    public boolean visible() {
        return false;
    }


}
