package bot.stuff;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Oskar
 * on 05.05.2018
 * github.com/oskardevkappa/
 */


public class FileManager {

    public static String[] lookFor(String file, String content) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(content)) {
                    String[] out = line.split(" ");
                    return out;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void write(String file, String content){

        String out = content + "\n";

        try {
            java.nio.file.Files.write(Paths.get(file), out.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean lookForBool(String file, String search){

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while( (line = br.readLine()) != null ) {
                if ( line.toLowerCase().startsWith(search)) {
                    return true;
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void clearLine(String file, String content){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int lineCount(String path){

        int lines = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));

            while (br.readLine() != null) {
                lines++;
            }
         return lines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static String getLine(String path, int line){

        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while(i != line){
                br.readLine();
                i++;
            }

            if (i == line){
                return br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
