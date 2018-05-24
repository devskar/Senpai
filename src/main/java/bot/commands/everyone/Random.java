package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import sun.plugin2.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 08.05.2018
 * github.com/oskardevkappa/
 */

public class Random implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

    if((args.length < 2)){
        Messages.sendError("0004", event.getChannel());
        return;
    }

        if(!(Check.isInteger(args[0]) || Check.isInteger(args[1]))){
            Messages.sendError("0002", event.getChannel());
            return;
        }

    int min = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);

    if(min > max){
        Messages.error(event.getChannel(), help());
        return;
    }

    java.util.Random r = new java.util.Random();
    String randomNum = String.valueOf(r.nextInt((max - min) + 1) + min);



    event.getChannel().sendMessage(Messages.embed(event.getGuild().getSelfMember()).setDescription(
            "\uD83C\uDFB2 Random result \n" +
                    Messages.markdown("You rolled a " + randomNum, null)).build()).queue();
    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " [numb1] [numb2]";
    }

    @Override
    public String description() {
        return "Gives you a random number in a range you can choose.";
    }

    @Override
    public String[] alias() {
        String[] abc = {"rndm", "random", "dice"};
        return abc;
    }

    @Override
    public String name() {
        return "random";
    }

    @Override
    public boolean visible() {
        return true;
    }

    @Override
    public void executed(boolean safe, GuildMessageReceivedEvent event) {

    }

    @Override
    public boolean called(String[] args, GuildMessageReceivedEvent event) {
        return false;
    }
}
