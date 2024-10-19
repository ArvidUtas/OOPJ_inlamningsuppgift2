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
            try{
                input = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Okänt fel");
                e.printStackTrace();
                //TODO: fixa catchar och bättre exceptions
        }
        return input.trim().toLowerCase().replace("-","");
    }
}
