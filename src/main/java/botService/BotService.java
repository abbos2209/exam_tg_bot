package botService;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotService {
    Long chatId;
    MarkupService markupService = MarkupService.getMarkupService();
    MyBot myBot = MyBot.getMyBot();
    public void messageHandler(Update update){
           chatId = update.getMessage().getChatId();
           if (update.getMessage().getText().equals("/start")){
               SendMessage message = new SendMessage();
               message.setText("welcome to bot!");
               message.setReplyMarkup(markupService.getMarkup(new String[][]{{"my cards","add card"},{"transfer","history"},{"deposite"}}));
               message.setChatId(chatId);
               myBot.smsSender(message);
           }
    }

    public void callbackHandler(Update update){

    }


    static BotService botService;
    public static BotService getBotService(){
        if (botService == null) botService = new BotService();
        return botService;
    }
}
