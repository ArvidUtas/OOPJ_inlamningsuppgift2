import java.time.LocalDate;
import java.util.List;

public class ControlUtil {

    public String searchList(List<Customer> customerList, String searchedFor) {
        String activeUser = "Medlem";
        String expiredUser = "Före detta medlem";
        String incorrectUser = "Obehörig, alternativt inkorrekt inmatning";
        String toReturn = incorrectUser;
        LocalDate currentDate = LocalDate.now();

            for (Customer c : customerList) {
                if (c.getName().equalsIgnoreCase(searchedFor) ||
                        c.getIdNumber().equals(searchedFor.replace("-",""))) {
                    if (currentDate.minusYears(1).isBefore(c.getMembershipPaid())) {
                        toReturn = (activeUser + c);
                    } else {
                        toReturn = (expiredUser + c);
                    }
                    break;
                }
            }
        return toReturn;
    }
}
