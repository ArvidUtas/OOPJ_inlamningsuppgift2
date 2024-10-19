import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserInput {
    UserInput ui = new UserInput();

    @Test
    void getUserInputTest() {

        String testinput1 = " James brown ";
        String testinput2 = " 19010101-1234";

        assertEquals("james brown", ui.getUserInput(true, testinput1));
        assertEquals("190101011234", ui.getUserInput(true, testinput2));
        assertNotEquals(" 19010101-1234", ui.getUserInput(true, testinput2));
    }
}
