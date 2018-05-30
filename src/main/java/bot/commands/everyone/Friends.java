package bot.commands.everyone;

import bot.Privat;
import bot.Senpai.Bot;
import bot.commands.Command;
import bot.stuff.Messages;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Objects;

/**
 * Coded by Oskar#7402
 * At 30.05.2018
 * github.com/oskardevkappa/
 */

public class Friends implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        //New StringBuilder to ez add all Members
        StringBuilder sb = new StringBuilder();
        StringBuilder sba = new StringBuilder();

        for (User u : Bot.jda.getUsers()  ) {

            if (u.getDiscriminator().equals(event.getAuthor().getDiscriminator())){
                if(!(u == event.getAuthor())) {
                    sb.append(u.getName()).append("#").append(u.getDiscriminator()).append("\n");
                }
            }
        }

        for (Member m : event.getGuild().getMembers()  ) {

            if (m.getUser().getDiscriminator().equals(event.getAuthor().getDiscriminator())){
                if(!(m.getUser() == (event.getAuthor()))) {
                    sb.append(m.getUser().getName()).append("#").append(m.getUser().getDiscriminator()).append("\n");
                }
            }
        }

        if ("".contentEquals(sb)){
            sb.append("You got no Friends :c");
        }

        if ("[]".contentEquals(sb)){
            sb.append("Test");
        }

        if ("".contentEquals(sba)){
            sba.append("You got no Friends :c");
        }

        if ("[]".contentEquals(sba)){
            sba.append("Test");
        }

        event.getChannel().sendMessage(Objects.requireNonNull(Messages.markdown("Your Friends " + event.getAuthor().getName(), sb.toString())) + Objects.requireNonNull(Messages.markdown("Your Friends on this Server " + event.getAuthor().getName(), sb.toString()))).queue();



    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Gives you a List with all ppl that got the same Discriminator as you (usefuller for Nitro Users)";
    }

    @Override
    public String[] alias() {
        return new String[]{"Tag", "Discriminator"};
    }

    @Override
    public String name() {
        return "Friends";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
