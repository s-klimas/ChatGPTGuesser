package pl.sebastianklimas.chatGPT;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChoiceTest {

    @Test
    public void testConstructorAndGetters() {
        // given
        int expectedIndex = 1;
        Message expectedMessage = new Message("role", "content");
        String expectedFinishReason = "stop";

        // when
        Choice choice = new Choice(expectedIndex, expectedMessage, expectedFinishReason);

        // then
        assertEquals(expectedIndex, choice.getIndex());
        assertEquals(expectedMessage, choice.getMessage());
        assertEquals(expectedFinishReason, choice.getFinish_reason());
    }

    @Test
    public void testSetters() {
        // given
        Choice choice = new Choice();
        int newIndex = 2;
        Message newMessage = new Message("role", "content");
        String newFinishReason = "stop";

        // when
        choice.setIndex(newIndex);
        choice.setMessage(newMessage);
        choice.setFinish_reason(newFinishReason);

        // then
        assertEquals(newIndex, choice.getIndex());
        assertEquals(newMessage, choice.getMessage());
        assertEquals(newFinishReason, choice.getFinish_reason());
    }
}