package ru.cotarius.reminder.telegram;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TelegramSender {
    private final String tgToken = "5982691328:AAFalCNB5LRCPDU-nRxL_-RGxK3tnl5Sz3o";
    private int clientTelegramId = 1212558248;
    private final String urlToken = "https://api.telegram.org/bot"+tgToken+"/sendMessage";

    public void sendMessage(int chatId, String message) throws IOException {
        HttpURLConnection con = null;
        String urlParameters = "chat_id="+chatId+"&text="+message;
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
