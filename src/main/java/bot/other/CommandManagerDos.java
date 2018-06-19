package bot.other;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;

/**
 * Coded by Oskar#7402
 * At 08.06.2018
 * github.com/oskardevkappa/
 */

public abstract class CommandManagerDos {

    private final String[] names;
    private final int lenght;
    private final boolean shown;
    private final Permission perm;
    private final Message msg;

    public CommandManagerDos(String[] names, int lenght, boolean shown, Permission perm, Message msg){
        this.names = names;
        this.lenght = lenght;
        this.shown = shown;
        this.perm = perm;
        this.msg = msg;
    }

    public void action(){

    }
}

