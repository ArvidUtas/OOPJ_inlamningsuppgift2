import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public Main (){
        UserInput userInput = new UserInput();
        IOUtil ioUtil = new IOUtil();
        ControlUtil controlUtil = new ControlUtil();
        List<Customer> customerList = ioUtil.getList();
        String outPath = "src/PTlogg.txt";

        while (true) { //TODO gör bättre loop
            String searchedFor = userInput.getUserInput(false, null);
            String customerIs = controlUtil.searchList(customerList, searchedFor);
            System.out.println("Kunden är: " + customerIs);
            if (customerIs.startsWith("Medlem")) {
                ioUtil.printToFile(customerIs, outPath);
            }
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}