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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMembershipPaid() {
        return membershipPaid;
    }

    public void setMembershipPaid(LocalDate membershipPaid) {
        this.membershipPaid = membershipPaid;
    }

    @Override
    public String toString() {
        return idNumber + "\t" + name + "\t" + membershipPaid + "\n";
    }
}
