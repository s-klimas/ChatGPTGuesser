package pl.sebastianklimas.chatGPT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageServiceTest {

    private MessageService messageService;

    @BeforeEach
    public void setUp() {
        messageService = new MessageService();
    }

    @Test
    public void testGetMessages() {
        // given
        List<Message> expectedMessages = new ArrayList<>();
        expectedMessages.add(new Message("user", "Hello there"));
        expectedMessages.add(new Message("assistant", "General Kenobi"));

        // when
        messageService.setMessages(expectedMessages);
        List<Message> actualMessages = messageService.getMessages();

        // then
        assertEquals(expectedMessages, actualMessages);
    }

    @Test
    public void testSetMessages() {
        // given
        List<Message> newMessages = new ArrayList<>();
        newMessages.add(new Message("user", "Hello there"));
        newMessages.add(new Message("assistant", "General Kenobi"));

        // when
        messageService.setMessages(newMessages);
        List<Message> actualMessages = messageService.getMessages();

        // then
        assertEquals(newMessages, actualMessages);
    }
}