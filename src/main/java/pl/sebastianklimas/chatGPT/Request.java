package pl.sebastianklimas.chatGPT;

import java.util.List;

public class Request {
    private String model;
    private List<Message> messages;

    public Request() {
    }

    public Request(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"model\": \"").append(model).append("\", \"messages\": ");
        sb.append(messages.toString());
        sb.append("}");
        return sb.toString();
    }
}
