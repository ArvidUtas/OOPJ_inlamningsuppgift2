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
        assertEquals("kund", cu.searchList(customerList, activeUser));
        assertEquals("kund", cu.searchList(customerList, activeUserName));
        assertEquals("före detta kund", cu.searchList(customerList, expiredUser));
        assertEquals("obehörig eller inkorrekt inmatning", cu.searchList(customerList, incorrectUser));
        assertNotEquals(cu.searchList(customerList, expiredUser), cu.searchList(customerList, activeUser));
    }
}
