package botService;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramBot;

import java.io.Serial;

public class MyBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {

        BotService botService = BotService.getBotService();

            if (update.hasMessage()){
                botService.messageHandler(update);
            }
            else if (update.hasCallbackQuery()){
                botService.callbackHandler(update);
            }
    }
    @SneakyThrows
    public void smsSender(SendMessage message){
        execute(message);
    }

    @Override
    public String getBotUsername() {
        return "t.me/transfeeer_bot";
    }

    @Override
    public String getBotToken() {
        return "7268589112:AAH5pWoOPRT65G-0vNOTe2tOx8gXF1af_fc";
    }

    static MyBot myBot;
    public static MyBot getMyBot(){
        if (myBot == null) myBot = new MyBot();
        return myBot;
    }
}
