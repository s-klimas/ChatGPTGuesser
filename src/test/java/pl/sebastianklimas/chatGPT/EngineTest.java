package pl.sebastianklimas.chatGPT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EngineTest {

    private HttpURLConnection mockConnection;

    @BeforeEach
    public void setUp() {
        mockConnection = mock(HttpURLConnection.class);
    }

    @Test
    public void testBuildRequestBody() throws IOException {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MessageService messageService = Engine.getMessageService();
        messageService.getMessages().clear();
        Message message = new Message("user", "Tell me something");

        when(mockConnection.getOutputStream()).thenReturn(outputStream);

        // given
        Engine.buildRequestBody(mockConnection, message);

        // then
        String requestBody = outputStream.toString();
        assertTrue(requestBody.contains("Tell me something"));
    }

    @Test
    public void testGetResponse() throws IOException {
        // given
        InputStream inputStream = new ByteArrayInputStream("{\"choices\": [{\"message\": {\"role\": \"assistant\", \"content\": \"It's something\"}}]}".getBytes());
        when(mockConnection.getInputStream()).thenReturn(inputStream);

        // given
        String response = Engine.getResponse(mockConnection);

        // then
        assertEquals("It's something", response);
    }
}
