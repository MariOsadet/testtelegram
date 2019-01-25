package bot;

import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import redis.RedisConsumer;
import redis.RedisProducer;

import java.util.List;


public class MyAmazingBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            SendMessage sendMessage = new SendMessage()
                    .setChatId(chatId)
                    .setText(messageText);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.hasMessage() && update.getMessage().hasPhoto()) {
            long chat_id = update.getMessage().getChatId();
            List<PhotoSize> photoSizes = update.getMessage().getPhoto();
            String fileId = photoSizes.get(0).getFileId();

            RedisProducer producer = new RedisProducer();
            try {
                producer.produce(fileId);

                RedisConsumer consumer = new RedisConsumer();
                consumer.consum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private void sendImage() {
        SendDocument document = new SendDocument();
    }


    public String getBotUsername() {
        return System.getProperty("telegramToken", "");
    }


    @Override
    public String getBotToken() {
        return System.getProperty("telegramName", "");
    }

    public void onClosing() {

    }
}
