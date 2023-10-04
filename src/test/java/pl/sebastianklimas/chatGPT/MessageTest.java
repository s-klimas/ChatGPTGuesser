package pl.sebastianklimas.chatGPT;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTest {

    @Test
    public void testConstructorAndGetters() {
        // given
        String expectedRole = "user";
        String expectedContent = "Hello, ChatGPT!";

        // when
        Message message = new Message(expectedRole, expectedContent);

        // then
        assertEquals(expectedRole, message.getRole());
        assertEquals(expectedContent, message.getContent());
    }

    @Test
    public void testSetters() {
        // given
        Message message = new Message();
        String newRole = "assistant";
        String newContent = "How can I help you?";

        // when
        message.setRole(newRole);
        message.setContent(newContent);

        // then
        assertEquals(newRole, message.getRole());
        assertEquals(newContent, message.getContent());
    }

    @Test
    public void testToString() {
        // given
        Message message = new Message("user", "Hello");

        // when
        String messageString = message.toString();

        // then
        assertEquals("{\"role\": \"user\", \"content\": \"Hello\"}", messageString);
    }
}