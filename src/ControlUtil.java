import java.time.LocalDate;
import java.util.List;

public class ControlUtil {

    public String searchList(List<Customer> customerList, String searchedFor) {
        String activeUser = "Medlem";
        String expiredUser = "Före detta medlem";
        String incorrectUser = "Obehörig, alternativt inkorrekt inmatning";
        String toReturn = incorrectUser;

            for (Customer c : customerList) {
                if (c.getName().equalsIgnoreCase(searchedFor) ||
                        c.getIdNumber().equals(searchedFor.replace("-",""))) {
                    if (controlMembershipActive(c.getMembershipPaid())) {
                        toReturn = (activeUser + c);
                    }
                    else {
                        toReturn = (expiredUser + c);
                    }
                    break;
                }
            }
        return toReturn;
    }

    public boolean controlMembershipActive (LocalDate datePaid){
        LocalDate currentDate = LocalDate.now();

        return currentDate.minusYears(1).isBefore(datePaid);
    }
}
