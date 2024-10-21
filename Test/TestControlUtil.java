import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestControlUtil {
    ControlUtil cu = new ControlUtil();
    String activeUser = "7703021234";
    String activeUserName = "alhambra aromes";
    String expiredUser = "8512021234";
    String incorrectUser = "8001011234";
    LocalDate currentDate = LocalDate.now();
    LocalDate dateOfMembershipExpiry = LocalDate.parse("2025-07-01");

    @Test
    void searchListTest() {
        IOUtil ioUtil = new IOUtil();
        List<Customer> customerList = ioUtil.getList();

        if (currentDate.isBefore(dateOfMembershipExpiry)) {
            assertEquals("Medlem\t7703021234\tAlhambra Aromes\t2024-07-01",
                    cu.searchList(customerList, activeUser));
            assertEquals("Medlem\t7703021234\tAlhambra Aromes\t2024-07-01",
                    cu.searchList(customerList, activeUserName));
        }
        else {
            assertEquals("Före detta medlem\t7703021234\tAlhambra Aromes\t2024-07-01",
                    cu.searchList(customerList, activeUser));
            assertEquals("Före detta medlem\t7703021234\tAlhambra Aromes\t2024-07-01",
                    cu.searchList(customerList, activeUserName));
        }
        assertEquals("Före detta medlem\t8512021234\tChamade Coriola\t2018-03-12",
                cu.searchList(customerList, expiredUser));
        assertEquals("Obehörig, alternativt inkorrekt inmatning",
                cu.searchList(customerList, incorrectUser));
        assertNotEquals(cu.searchList(customerList, expiredUser), cu.searchList(customerList, activeUser));
    }

    @Test
    void controlMembershipActiveTest () {
        LocalDate lessThanAYearAgo = LocalDate.now().minusMonths(5);
        LocalDate moreThanAYearAgo = LocalDate.now().minusYears(2);

        assertTrue(cu.controlMembershipActive(lessThanAYearAgo));
        assertFalse(cu.controlMembershipActive(moreThanAYearAgo));
    }
}
