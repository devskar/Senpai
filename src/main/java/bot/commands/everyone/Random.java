package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Check;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Arrays;

/**
 * Coded by Oskar#7402
 * At 29.05.2018
 * github.com/oskardevkappa/
 */

public class Random implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {


        //Checking if all arguments are given
        if((args.length < 2)){
            Messages.sendError("0004", event.getChannel());
            return;
        }

        //Checking if both are integers
        if(!(Check.isInteger(args[0]) || Check.isInteger(args[1]))){
            Messages.sendError("0002", event.getChannel());
            return;
        }

        //Setting up some variables
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);

        //Yeah I hope you understand what im doing here
        if(min > max){
            Messages.error(event.getChannel(), help());
            return;
        }

        //Getting a random numer in the range of min max
        java.util.Random r = new java.util.Random();
        String randomNum = String.valueOf(r.nextInt((max - min) + 1) + min);

        //Sends the number
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
        String[] abc = {"rndm", "dice"};
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

}
