import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static JDA jda;

    public static void main(String[] args) {
        try {
            jda = new JDABuilder(AccountType.BOT).addEventListener(new GnomeListener()).setToken(tokenGet()).buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }

    public static String tokenGet() {

        Path path = Paths.get("","token.txt");
        Charset charset = Charset.forName("ISO-8859-1");
        String test = "";
        try {
            List<String> lines = Files.readAllLines(path, charset);
            for (String line : lines) {
                test = line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return test;
    }
}
