import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestControlUtil {
    ControlUtil cu = new ControlUtil();
    String activeUser = "7703021234";
    String activeUserName = "alhambra aromes";
    String expiredUser = "8512021234";
    String incorrectUser = "8001011234";

    @Test
    void searchListTest() {
        IOUtil ioUtil = new IOUtil();
        List<Customer> customerList = ioUtil.getList();
        assertEquals("Medlem", cu.searchList(customerList, activeUser));
        assertEquals("Medlem", cu.searchList(customerList, activeUserName));
        assertEquals("Före detta medlem", cu.searchList(customerList, expiredUser));
        assertEquals("Obehörig, alternativt inkorrekt inmatning", cu.searchList(customerList, incorrectUser));
        assertNotEquals(cu.searchList(customerList, expiredUser), cu.searchList(customerList, activeUser));
    }
}
