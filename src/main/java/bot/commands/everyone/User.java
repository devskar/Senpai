package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.time.format.DateTimeFormatter;

/**
 * Coded by Oskar#7402
 * At 12.05.2018
 * github.com/oskardevkappa/
 */

public class User implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        Guild g = event.getGuild();
        EmbedBuilder eb;

        if(args.length < 1){
            eb = eb(event.getMember(), g);
        }else if (!(event.getMessage().getMentionedMembers().size() < 1)){
            eb = eb(event.getMessage().getMentionedMembers().get(0), g);
        }else if(Check.isLong(args[0])){
            if(Check.mByID(args[0], g));
            eb = eb(g.getMemberById(args[0]), g);
        }else if(Check.mByName(args[0], g)){
            eb = eb(g.getMembersByName(args[0], false).get(0), g);
        }else{
            eb = eb(event.getMember(), g);
        }

        event.getChannel().sendMessage(eb.build()).queue();
    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " [Mention/ID/Username]";
    }

    @Override
    public String description() {
        return "Gives you informations about an user.";
    }

    @Override
    public String[] alias() {
        return new String[]{"member"};
    }

    @Override
    public String name() {
        return "user";
    }

    @Override
    public boolean visible() {
        return true;
    }


    public class UserInfo {

        private String name, avatar, id, joineddate, nickname, onlinestatus, hrole;
        private Game game;
        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        private UserInfo(Member m){

            this.avatar = m.getUser().getEffectiveAvatarUrl();
            this.name = m.getUser().getName();
            this.game = m.getGame();
            this.nickname = m.getNickname();
            this.id = m.getUser().getId();
            this.onlinestatus = m.getOnlineStatus().toString();
            this.joineddate = m.getJoinDate().format(formatter);
            this.hrole = hrole(m);

        }

    }

    private String nickname(UserInfo ui){
        String nname;
        if (ui.nickname == null){
            nname = "-/-";
        }else{
            nname = ui.nickname;
        }
        return nname;
    }

    private String game(UserInfo ui){
        String game;
        if (ui.game == null){
            game = "-/-";
        }else{
            game = ui.game.getName();
        }
        return game;
    }

    private String hrole(Member m){
        String hrole;
        if (m.getRoles().size() == 0){
            hrole = "-/-";
        }else{
            hrole = m.getRoles().get(0).getName();
        }
        return hrole;
    }

    private EmbedBuilder eb(Member m, Guild g){

        UserInfo ui = new UserInfo(m);

        EmbedBuilder eb = Messages.embed(g.getSelfMember());
        eb.setTitle(":cop: User info");
        eb.setThumbnail(ui.avatar);
        eb.addField("Name", ui.name, false);
        eb.addField("ID", ui.id, false);
        eb.addField("Nickname", nickname(ui), false);
        eb.addField("Game", game(ui), false);
        eb.addField("OnlineStatus", ui.onlinestatus, false);
        eb.addField("Highest role", ui.hrole, false);
        eb.addField("Joined Date", ui.joineddate, false);

        return eb;
    }
}
