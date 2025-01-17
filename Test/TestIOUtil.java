import org.junit.jupiter.api.Test;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestIOUtil {
    IOUtil ioUtil = new IOUtil();

    @Test
    void getListTest(){
        List<Customer> customerList = ioUtil.getList();
        assertEquals(14, customerList.size());
        assertNotEquals(0, customerList.size());
        assertEquals("7805211234", customerList.getLast().getIdNumber());
        assertEquals("Nahema Ninsson", customerList.getLast().getName());
        assertEquals("7703021234", customerList.getFirst().getIdNumber());
        assertEquals("Alhambra Aromes", customerList.getFirst().getName());
    }

    @Test
    void printToFileTest(){
        Customer c1 = new Customer("1234567890", "Sven Svensson", LocalDate.parse("2024-07-01"));
        Customer c2 = new Customer("1234567899", "Sanna Annsson", LocalDate.parse("2023-07-01"));
        Customer c3 = new Customer("1234567800", "Anna Sannsson", LocalDate.parse("2022-07-01"));
        String outPath = "Test/PTloggTest.txt";
        //to empty file:
        try(PrintWriter writer = new PrintWriter(outPath)) {
            writer.print("");
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            e.printStackTrace();
        }
        ioUtil.printToFile(c1.toString(), outPath);
        ioUtil.printToFile(c2.toString(), outPath);
        ioUtil.printToFile(c3.toString(), outPath);

        try(BufferedReader buf = new BufferedReader(new FileReader(outPath))){
            String temp = buf.readLine();
            assertTrue(temp.startsWith("1234567890"));
            temp = buf.readLine();
            assertTrue(temp.contains("Sanna Annsson"));
            temp = buf.readLine();
            assertFalse(temp.endsWith("2022-07-01"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        }
    }
}