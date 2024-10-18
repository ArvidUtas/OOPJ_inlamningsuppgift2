import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IOUtil {

    public List<Customer> getList() {
        Path inPath = Paths.get("src/customer_data.txt");
        List<Customer> customerList = new ArrayList<>();
        String idNumber;
        String name;
        String membershipPaid;
        try (Scanner sc = new Scanner(inPath)) {
            while (sc.hasNext()) {
                idNumber = sc.useDelimiter("[,\n]").next();  //TODO: varför funkar det här?
                name = sc.next().trim();
                membershipPaid = sc.next().trim();
                customerList.add(new Customer(idNumber, name, LocalDate.parse(membershipPaid)));
            }
        } catch (NoSuchElementException | IOException e) {
            // TODO: fixa catchar
        }
        return customerList;
    }

    public void printToFile(String customer, String outpath) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outpath, true))) {
            writer.write(customer.trim() + "\t\t" + dateTime +"\n");
            writer.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
