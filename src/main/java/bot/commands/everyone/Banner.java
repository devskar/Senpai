package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.Messages;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Coded by Oskar#7402
 * At 30.05.2018
 * github.com/oskardevkappa/
 */

public class Banner implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        int widht = 150;
        int height = 30;
/*
        if(args.length < 2){
            Messages.sendError("", event.getChannel());
        }*/

        BufferedImage bi = new BufferedImage(widht, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();

        g.setFont(new Font("SansSerif", Font.BOLD, 24));

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("Oskar", 10, 20);

        StringBuilder sb = new StringBuilder();

        for(int y = 0; y < height; y++){
            for (int x = 0; x < widht; x++){
                sb.append(bi.getRGB(x, y) == -16777216 ? " " : "a");
            }

            System.out.println(sb);


        }

    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <The Char that should fill the gaps> <The others>";
    }

    @Override
    public String description() {
        return "Sends you a Banner of a Word you send";
    }

    @Override
    public String[] alias() {
        return new String[]{"ascii"};
    }

    @Override
    public String name() {
        return "banner";
    }

    @Override
    public boolean visible() {
        return false;
    }
}
