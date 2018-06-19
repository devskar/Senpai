package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

/**
 * Coded by Oskar#7402
 * At 03.06.2018
 * github.com/oskardevkappa/
 */

public class RoleAdd implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        List<net.dv8tion.jda.core.entities.Role> roles = event.getGuild().getRolesByName(args[0], true);

        if (args.length < 1)
        {
            Messages.sendError("0004", event.getChannel());
            return;
        }

        if (roles.size() < 1)
        {
            Messages.sendError("0013", event.getChannel());
            return;
        }

        if (!event.getMember().hasPermission(Permission.MANAGE_ROLES))
        {
            Messages.sendError("0001", event.getChannel());
            return;
        }

        int i = 0;

        for (Member m : event.getGuild().getMembers())
        {

            if (event.getGuild().getSelfMember().canInteract(m) && event.getGuild().getSelfMember().canInteract(roles.get(0)) && event.getMember().canInteract(m))
            {
                event.getGuild().getController().addSingleRoleToMember(m, roles.get(0)).queue();
                i++;
            }
        }

        String content = Messages.markdown("Roles added", "Added role " + roles.get(0).getName() + " to " + i + "/" + event.getGuild().getMembers().size() + " Members.");

        assert content != null;
        event.getChannel().sendMessage(content).queue();

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <Role>";
    }

    @Override
    public String description() {
        return "Adds a role to every user on the server.";
    }

    @Override
    public String[] alias() {
        return new String[]{"roleadd", "addrole", "roleeveryone"};
    }

    @Override
    public String name() {
        return "role";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
