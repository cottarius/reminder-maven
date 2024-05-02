package ru.cotarius.reminder.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class TelegramSender {
//    @Value("${spring.application.telegram.botToken}")
    private String tgToken = "5982691328:AAFalCNB5LRCPDU-nRxL_-RGxK3tnl5Sz3o";

//    @Value("${spring.application.telegram.chatId}")
    private int clientTelegramId = 1212558248;

    private final String urlToken = "https://api.telegram.org/bot"+tgToken+"/sendMessage";

    @Scheduled(cron = "* 1 * * * *")
    public void sendMessage() throws IOException {
        HttpURLConnection con = null;
        String urlParameters = "chat_id="+clientTelegramId+"&text="+"Здарова братуха";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {
            URL url = new URL(urlToken);
            con = (HttpURLConnection) url.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                String inputLine;
                content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());
        } finally {
            assert con != null;
            con.disconnect();
        }

    }
}
