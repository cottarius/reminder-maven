package ru.cotarius.reminder.telegram;//package ru.cotarius.reminder.telegram;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ScheduledTasks {
//    @Autowired
//    private TelegramBot telegramBot;
//
//    @Scheduled(cron = "10 * * * * *", zone = "Europe/Moscow")
//    public void sendReminderMessage(){
//        String message = "Напоминание";
//        telegramBot.sendMessage(message);
//    }
//}
