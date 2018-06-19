package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import com.oracle.webservices.internal.api.message.ContentType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.requests.Requester;
import okhttp3.MultipartBody;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Coded by Oskar#7402
 * At 03.06.2018
 * github.com/oskardevkappa/
 */

public class Color implements Command {
    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        BufferedImage image = new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        g.setColor(java.awt.Color.red);



    }

    @Override
    public String help() {
        return Privat.Prefix + name();
    }

    @Override
    public String description() {
        return "Gives you a random color.";
    }

    @Override
    public String[] alias() {
        return new String[]{"randomcolor", "randomcol", "col"};
    }

    @Override
    public String name() {
        return "Color";
    }

    @Override
    public boolean visible() {
        return false;
    }
}
