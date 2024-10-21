import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput {

    public String getUserInput(boolean testMode, String optionalTestInput){
        Scanner sc;
        String input = "";
        if (testMode){
            sc = new Scanner(optionalTestInput);
        }
        else {
            sc = new Scanner(System.in);
        }
        System.out.println("Ange namn eller 10-siffrigt personnummer (\"exit\" för att avsluta):");
        try {
            input = sc.nextLine();
        } catch (NoSuchElementException e) {
            System.err.println("Indata saknas");
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.err.println("Inläsningens ström är stängd");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Okänt fel");
            e.printStackTrace();
        }
        return input.trim();
    }
}
