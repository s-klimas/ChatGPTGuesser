package pl.sebastianklimas.chatGPT;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseTest {

    @Test
    public void testConstructorAndGetters() {
        // given
        String expectedId = "response-123";
        String expectedObject = "response";
        long expectedCreated = System.currentTimeMillis();
        String expectedModel = "gpt-3.5-turbo";
        List<Choice> expectedChoices = new ArrayList<>();
        expectedChoices.add(new Choice(1, new Message("assistant", "Hi"), "stop"));
        Usage expectedUsage = new Usage(1, 10, 100);

        // when
        Response response = new Response(expectedId, expectedObject, expectedCreated, expectedModel, expectedChoices, expectedUsage);

        // then
        assertEquals(expectedId, response.getId());
        assertEquals(expectedObject, response.getObject());
        assertEquals(expectedCreated, response.getCreated());
        assertEquals(expectedModel, response.getModel());
        assertEquals(expectedChoices, response.getChoices());
        assertEquals(expectedUsage, response.getUsage());
    }

    @Test
    public void testSetters() {
        // given
        Response response = new Response();
        String newId = "response-456";
        String newObject = "new-response";
        long newCreated = System.currentTimeMillis();
        String newModel = "gpt-4.0";
        List<Choice> newChoices = new ArrayList<>();
        newChoices.add(new Choice(2, new Message("assistant", "How can I help you?"), "stop"));
        Usage newUsage = new Usage(2, 20, 200);

        // when
        response.setId(newId);
        response.setObject(newObject);
        response.setCreated(newCreated);
        response.setModel(newModel);
        response.setChoices(newChoices);
        response.setUsage(newUsage);

        // then
        assertEquals(newId, response.getId());
        assertEquals(newObject, response.getObject());
        assertEquals(newCreated, response.getCreated());
        assertEquals(newModel, response.getModel());
        assertEquals(newChoices, response.getChoices());
        assertEquals(newUsage, response.getUsage());
    }
}