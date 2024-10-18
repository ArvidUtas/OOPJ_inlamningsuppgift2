import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ControlUtil {

    public String searchList(List<Customer> customerList, String searchedFor) {
        String activeUser = "Medlem ";
        String expiredUser = "Före detta medlem ";
        String incorrectUser = "Obehörig, alternativt inkorrekt inmatning";
        String toReturn = incorrectUser;
        String temp;
        LocalDate currentDate = LocalDate.now();

        try (Scanner sc = new Scanner(String.valueOf(customerList))) {
            for (Customer c : customerList) {
                temp = sc.nextLine();
                if (temp.toLowerCase().replace("-","").contains(searchedFor)) {
                    if (currentDate.minusYears(1).isBefore(c.getMembershipPaid())) {
                        toReturn = (activeUser + c);
                        break;
                    } else if (currentDate.minusYears(1).isAfter(c.getMembershipPaid())) {
                        toReturn = (expiredUser + c);
                        break;
                    }
                }
            }
        }
        return toReturn;
    }
}
