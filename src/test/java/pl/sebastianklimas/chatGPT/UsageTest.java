package pl.sebastianklimas.chatGPT;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsageTest {

    @Test
    public void testConstructorAndGetters() {
        // given
        int expectedPromptTokens = 10;
        int expectedCompletionTokens = 20;
        int expectedTotalTokens = 30;

        // when
        Usage usage = new Usage(expectedPromptTokens, expectedCompletionTokens, expectedTotalTokens);

        // then
        assertEquals(expectedPromptTokens, usage.getPrompt_tokens());
        assertEquals(expectedCompletionTokens, usage.getCompletion_tokens());
        assertEquals(expectedTotalTokens, usage.getTotal_tokens());
    }

    @Test
    public void testSetters() {
        // given
        Usage usage = new Usage();
        int newPromptTokens = 5;
        int newCompletionTokens = 15;
        int newTotalTokens = 25;

        // when
        usage.setPrompt_tokens(newPromptTokens);
        usage.setCompletion_tokens(newCompletionTokens);
        usage.setTotal_tokens(newTotalTokens);

        // then
        assertEquals(newPromptTokens, usage.getPrompt_tokens());
        assertEquals(newCompletionTokens, usage.getCompletion_tokens());
        assertEquals(newTotalTokens, usage.getTotal_tokens());
    }
}