package pl.sebastianklimas.chatGPT;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Engine {
    private final static String API_URL = "https://api.openai.com/v1/chat/completions";
    private final static String API_KEY = "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"; // Tquillaa
    private final static String API_MODEL = "gpt-3.5-turbo";

    private final static MessageService messageService = new MessageService();

    public static MessageService getMessageService() {
        return messageService;
    }

    public static String getApiUrl() {
        return API_URL;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getApiModel() {
        return API_MODEL;
    }



    public static String askChatGPT(Message message) {
        HttpURLConnection connection = makeConnectionToChatGPT();
        buildRequestBody(connection, message);
        return getResponse(connection);
    }

    public static void reset() {
        messageService.getMessages().clear();
    }

    public static HttpURLConnection makeConnectionToChatGPT() {
        try {
            URL url = URI.create(API_URL).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");

            return connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void buildRequestBody(HttpURLConnection connection, Message message) {
        try {
            messageService.getMessages().add(message);
            Request request = new Request();
            request.setModel(API_MODEL);
            request.setMessages(messageService.getMessages());
            String body = request.toString();
//            System.out.println(body);
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getResponse(HttpURLConnection connection) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder resp = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                resp.append(inputLine);
            }
            in.close();

            Response response = new ObjectMapper().readValue(resp.toString(), Response.class);

            Message message = response.getChoices().get(0).getMessage();
            message.setRole(message.getRole());
            message.setContent(message.getContent().replaceAll("\n", " "));
            messageService.getMessages().add(message);

            return message.getContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
