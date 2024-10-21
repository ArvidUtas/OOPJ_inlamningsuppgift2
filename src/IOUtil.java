import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class IOUtil {

    public List<Customer> getList() {
        Path inPath = Paths.get("src/customer_data.txt");
        List<Customer> customerList = new ArrayList<>();
        String idNumber;
        String name;
        String membershipPaid;

        try (Scanner sc = new Scanner(inPath)) {
            while (sc.hasNext()) {
                idNumber = sc.useDelimiter("[,\n]").next();
                name = sc.next().trim();
                membershipPaid = sc.next().trim();
                customerList.add(new Customer(idNumber, name, LocalDate.parse(membershipPaid)));
            }
        } catch (NoSuchElementException e) {
            System.err.println("Indata saknas");
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.err.println("Inläsningens ström är stängd");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Okänt IO fel vid läsning från fil");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Okänt fel");
            e.printStackTrace();
        }
        return customerList;
    }

    public void printToFile(String customer, String outpath) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outpath, true))) {
            writer.write(customer.substring(customer.indexOf("\t") + 1, customer.lastIndexOf("\t")) +
                    "\t" + dateTime +"\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Okänt fel vid utskrift till fil");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Okänt fel");
            e.printStackTrace();
        }
    }
}
