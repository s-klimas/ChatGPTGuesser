package pl.sebastianklimas.chatGPT;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    List<Message> messages = new ArrayList<>();

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
