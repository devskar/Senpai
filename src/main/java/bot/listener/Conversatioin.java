package bot.listener;


import bot.Privat;
import ml.duncte123.CleverBot4J.CleverbotAPI;
import ml.duncte123.CleverBot4J.CleverbotBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Coded by Oskar#7402
 * At 30.05.2018
 * github.com/oskardevkappa/
 */

public class Conversatioin extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {




        if (!event.getMessage().getContentRaw().startsWith("Sen: "))
            return;

        //String str = event.getMessage().getContentRaw().replaceFirst("Sen:", "");

        try {
            CleverbotAPI api = new CleverbotBuilder()
                    .setApiKey(Privat.CLEVERBOTIOAPIKEY)
                    .setUserKey(Privat.CLEVERBOTIOUSERKEY)
                    .build();

            String question = "Just a small town girl";
                String answer = api.askQuestion(question);
            System.out.println(answer);

        } catch (Exception e) {
           e.printStackTrace();
        }
    }

}
