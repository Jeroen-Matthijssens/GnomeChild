import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class GnomeListener extends ListenerAdapter{

    public void onMessageReceived (MessageReceivedEvent event) {
        String msg = event.getMessage().getContent();

        if (msg.startsWith(".test")) {
            String name = event.getAuthor().getName();

            String response = name + ", this is test that tests test.";

            event.getTextChannel().sendMessage(response).queue();
        }
    }

}
