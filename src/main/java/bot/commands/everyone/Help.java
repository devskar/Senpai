package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.other.commandHandler;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.concurrent.TimeUnit;

/**
 * Coded by Oskar#7402
 * At 09.05.2018
 * github.com/oskardevkappa/
 */

public class Help implements Command {

    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        Command[] cmds = commandHandler.commands.values().toArray(new Command[0]);

        int size = 0;

        if(args.length < 1){
            StringBuilder sb = new StringBuilder();

            sb.append("=== Help ===\n\n");
            for (Command c: cmds) {
                if(c.visible()) {
                    sb.append("= " + c.name() + " =\n" +
                            "[" + c.description() + "]\n");
                    size++;
                }
            }

            sb.append("\nLoaded " + size + " Commands!");

            event.getChannel().sendMessage("```asciidoc\n" +
                    sb.toString() + "```").queue();
        }else{

            String command =  args[0];

            int i = 0;

            for (Command c: cmds) {
                if (command.equalsIgnoreCase(c.name())){
                    event.getChannel().sendMessage(Messages.embed(event.getGuild().getSelfMember()).setDescription(Messages.markdown("Command " + c.name(), c.help())).build()).queue();
                }else{
                    i++;
                }
            }

            if (i == cmds.length){
                Messages.sendError("0003", event.getChannel());
            }
        }

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + "\n " +
                Privat.Prefix + name() + "[Command]";
    }

    @Override
    public String description() {
        return "Sends a help message.";
    }

    @Override
    public String[] alias() {
        return new String[0];
    }

    @Override
    public String name() {
        return "help";
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
