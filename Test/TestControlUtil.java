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
        assertEquals("Medlem 7703021234\tAlhambra Aromes\t2024-07-01\n",
                cu.searchList(customerList, activeUser));
        assertEquals("Medlem 7703021234\tAlhambra Aromes\t2024-07-01\n",
                cu.searchList(customerList, activeUserName));
        assertEquals("Före detta medlem 8512021234\tChamade Coriola\t2018-03-12\n",
                cu.searchList(customerList, expiredUser));
        assertEquals("Obehörig, alternativt inkorrekt inmatning",
                cu.searchList(customerList, incorrectUser));
        assertNotEquals(cu.searchList(customerList, expiredUser), cu.searchList(customerList, activeUser));
    }
}
