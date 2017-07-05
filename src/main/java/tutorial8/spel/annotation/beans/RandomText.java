package tutorial8.spel.annotation.beans;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomText {

    public static String[] texts = {
            "I'll be back.",
            "Get out!",
            "I want your clothes!",
            "I am back :P",
            "I will punch you :O",
            "Run or Die!",
            "I am standing behind you!",
            null
    };

    public String getText() {
        Random random = new Random();

        return texts[random.nextInt(texts.length)];
    }
}
