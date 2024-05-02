package ru.cotarius.reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;



import java.io.IOException;

@SpringBootApplication
@PropertySource({"classpath:application.yml"})
public class ReminderApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ReminderApplication.class, args);
////		TelegramSender sender = new TelegramSender();
////		sender.sendMessage(1212558248, "Как жизнь?");
//
//		TelegramSender sender = new TelegramSender();
//		sender.sendMessage();
//
//		TelegramBot telegramBot = new TelegramBot();
//		telegramBot.sendMessageAtSpecificTime();
	}

}
