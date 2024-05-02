//package ru.cotarius.reminder.telegram;
//
//import lombok.EqualsAndHashCode;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//
//import java.util.List;
//
//@Setter
//@EqualsAndHashCode(callSuper = true)
//@Service
//public class TelegramBot extends TelegramLongPollingBot{
//
//    @Value("${spring.application.telegram.botToken}")
//    private String botToken ;
//
//    @Value("${spring.application.telegram.chatId}")
//    private long chatId ;
//
//    @Override
//    public String getBotUsername() {
//        return "@Cotarius_bot";
//    }
//
//    @Override
//    public String getBotToken() {
//        return botToken;
//    }
//
//    @Scheduled(cron = "* 1 * * * *")
//    public void sendMessageAtSpecificTime(){
//        sendMessage(chatId);
//    }
//
//    private void sendMessage(long chatId){
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(chatId);
//        sendMessage.setText("Алоха");
//
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//    }
//
//    @Override
//    public void onUpdatesReceived(List<Update> updates) {
//        super.onUpdatesReceived(updates);
//    }
//}
