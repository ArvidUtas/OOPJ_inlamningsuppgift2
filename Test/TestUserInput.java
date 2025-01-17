import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserInput {
    UserInput ui = new UserInput();

    @Test
    void getUserInputTest() {

        String testinput1 = " James Brown ";
        String testinput2 = " 19010101-1234";

        assertEquals("James Brown", ui.getUserInput(true, testinput1));
        assertEquals("19010101-1234", ui.getUserInput(true, testinput2));
        assertNotEquals(" 19010101-1234", ui.getUserInput(true, testinput2));
    }
}
