package pl.sebastianklimas.chatGPT;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {

    @Test
    public void testConstructorAndGetters() {
        // given
        String expectedModel = "gpt-3.5-turbo";
        List<Message> expectedMessages = new ArrayList<>();
        expectedMessages.add(new Message("user", "Hello there"));
        expectedMessages.add(new Message("assistant", "General Kenobi"));

        // when
        Request request = new Request(expectedModel, expectedMessages);

        // then
        assertEquals(expectedModel, request.getModel());
        assertEquals(expectedMessages, request.getMessages());
    }

    @Test
    public void testSetters() {
        // given
        Request request = new Request();
        String newModel = "gpt-4.0";
        List<Message> newMessages = new ArrayList<>();
        newMessages.add(new Message("user", "Hello there"));
        newMessages.add(new Message("assistant", "General Kenobi"));

        // when
        request.setModel(newModel);
        request.setMessages(newMessages);

        // then
        assertEquals(newModel, request.getModel());
        assertEquals(newMessages, request.getMessages());
    }

    @Test
    public void testToString() {
        // given
        String model = "gpt-3.5-turbo";
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("user", "Hello there"));
        messages.add(new Message("assistant", "General Kenobi"));

        Request request = new Request(model, messages);

        // when
        String requestString = request.toString();

        // then
        assertEquals("{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"Hello there\"}, {\"role\": \"assistant\", \"content\": \"General Kenobi\"}]}", requestString);
    }
}