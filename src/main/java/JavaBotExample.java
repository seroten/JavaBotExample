import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class JavaBotExample extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {


        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();


        if (command.equals("/myname")) {
            System.out.println(update.getMessage().getText());
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
            message.setChatId(update.getMessage().getChatId().toString());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "javaBotExample_bot";
    }

    @Override
    public String getBotToken() {
        return "5039043111:AAF6wWcc0ZesfN8rDDNY87935V5msXUQCao";
    }
}
