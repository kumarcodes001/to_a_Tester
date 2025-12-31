import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class junit_setup {

    String message = "BrowserStack is the intended message" ;
    @Test
    public void testMessage() {
        System.out.println("Inside testMessage()");
        assertEquals("BrowserStack is the intended message", message);
    }
}

