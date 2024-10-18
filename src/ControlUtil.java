import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ControlUtil {

    public String searchList(List<Customer> customerList, String searchedFor) {
        String activeUser = "kund";
        String expiredUser = "före detta kund";
        String incorrectUser = "obehörig eller inkorrekt inmatning";
        String toReturn = incorrectUser;
        String temp;
        LocalDate currentDate = LocalDate.now();

        searchedFor = searchedFor.trim();
        try (Scanner sc = new Scanner(String.valueOf(customerList))) {
            for (Customer c : customerList) {
                temp = sc.nextLine();
                if (temp.toLowerCase().contains(searchedFor.toLowerCase())) {
                    if (currentDate.minusYears(1).isBefore(c.getMembershipPaid())) {
                        toReturn = activeUser;
                        break;
                    } else if (currentDate.minusYears(1).isAfter(c.getMembershipPaid())) {
                        toReturn = expiredUser;
                        break;
                    }
                }
            }
        }
        return toReturn;
    }
}
