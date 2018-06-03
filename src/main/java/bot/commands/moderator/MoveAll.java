package bot.commands.moderator;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Objects;

/**
 * Coded by Oskar#7402
 * At 11.05.2018
 * github.com/oskardevkappa/
 */

public class MoveAll implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        ///Checking length
        if (args.length < 1){
            Messages.sendError("0004", event.getChannel());
            return;
        }

        //Checking if the Member is in an VoiceChannel
        if (!event.getMember().getVoiceState().inVoiceChannel()){
            Messages.sendError("0005", event.getChannel());
            return;
        }

        //Checking the Permission
        if (!Check.Perms(Permission.VOICE_MOVE_OTHERS, event.getMember(), event.getGuild())){
            Messages.sendError("0001", event.getChannel());
        }

        //I'm now checking if the VoiceChannel exists
        String idorname = args[0];
        VoiceChannel currentvc = event.getMember().getVoiceState().getChannel();
        VoiceChannel aftervc;

        if (Check.vcByID(idorname, event.getGuild())){
            aftervc = event.getGuild().getVoiceChannelById(idorname);
        }else if (Check.vcByName(idorname, event.getGuild())){
            aftervc = event.getGuild().getVoiceChannelsByName(idorname, false).get(0);
        }else{
            Messages.sendError("0003", event.getChannel());
            return;
        }

        String membersize = String.valueOf(currentvc.getMembers().size());


        //Move da bois
        for (Member m : currentvc.getMembers()) {
            event.getGuild().getController().moveVoiceMember(m, aftervc).queue();
        }

        //Send Message
        event.getChannel().sendMessage(Objects.requireNonNull(Messages.markdown("Moved Members", "Moved " + membersize + " Members from " + currentvc.getName() + " to " + aftervc.getName() + "."))).queue();
    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " [VoiceChannel (id or name)]";
    }

    @Override
    public String description() {
        return "Moves all members from your current VoiceChannel into another.";
    }

    @Override
    public String[] alias() {
        return new String[]{"movea"};
    }

    @Override
    public String name() {
        return "moveall";
    }

    @Override
    public boolean visible() {
        return true;
    }

}
