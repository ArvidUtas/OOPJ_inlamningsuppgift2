import java.time.LocalDate;

public class Customer {
    private String idNumber;
    private String name;
    private LocalDate membershipPaid;

    public Customer(String idNumber, String name, LocalDate membershipPaid) {
        this.idNumber = idNumber;
        this.name = name;
        this.membershipPaid = membershipPaid;
    }

    public LocalDate getMembershipPaid() {
        return membershipPaid;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\t" + idNumber + "\t" + name + "\t" + membershipPaid;
    }
}
