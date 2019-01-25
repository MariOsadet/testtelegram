package bot;

import org.junit.Assert;
import org.junit.Test;

public class TelegramNameTest {
    @Test
    public void testTelegramName() {
        final MyAmazingBot myAmazingBot = new MyAmazingBot();
        Assert.assertTrue(myAmazingBot.getBotUsername().length()>0);
        Assert.assertNotEquals("$NAME", myAmazingBot.getBotUsername());
    }
}
