package bot.stuff;

/**
 * Coded by Oskar#7402
 * At 26.05.2018
 * github.com/oskardevkappa/
 */

public class Util {

    public static int TimeConverter(int milsecs, String timeunit){

        timeunit = timeunit.toLowerCase();

        if(timeunit.equals("milliseconds"))
            return milsecs;
        else if(timeunit.equalsIgnoreCase("seconds"))
            return milsecs * 1000;
        else if(timeunit.equals("minutes"))
            return milsecs * 60000;
        else if(timeunit.equals("hours"))
            return milsecs * 3600000;
        else if(timeunit.equals("days"))
            return milsecs * 86400000;
        else if(timeunit.startsWith("mil"))
            return milsecs;
        else if(timeunit.startsWith("sec"))
            return milsecs * 1000;
        else if(timeunit.startsWith("min"))
            return milsecs * 60000;
        else if(timeunit.startsWith("m"))
            return milsecs * 60000;
        else if(timeunit.startsWith("h"))
            return milsecs * 3600000;
        else if(timeunit.startsWith("d"))
            return milsecs * 86400000;
        else
            return milsecs * 60000;
    }

}
