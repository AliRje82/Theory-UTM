import java.io.File;
import java.util.Scanner;

/**
 * Main class for test UTM and TM
 */
public class Main {
    /**
     * Test Case:
     * 
     * @throws Exception
     */
    public static void run(String[] turingMachine, String[] input) throws Exception {
        TM tm = new TM(turingMachine);
        tm.print();
        BTM btm = tm.TMtoBTM();
        UTM utm = new UTM();
        utm.run(btm, input);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        // Add turing machine
        File add = new File("Add.txt");
        Scanner addDescription = new Scanner(add);
        String[] addMachine = new String[4];
        for (int i = 0; i < 4; i++) {
            addMachine[i] = addDescription.nextLine();
        }
        addDescription.close();
        Scanner scan = new Scanner(System.in);
        String t = scan.nextLine();
        String[] input = new String[t.length()];
        for (int i = 0; i < t.length(); i++) {
            input[i] = String.valueOf(t.charAt(i));
        }
        Main.run(addMachine, input);
        // Multiplication turing machine
        File multiplication = new File("mult.txt");
        Scanner multiplicationDescription = new Scanner(multiplication);
        String[] multiplicationMachine = new String[4];
        for (int i = 0; i < 4; i++) {
            multiplicationMachine[i] = multiplicationDescription.nextLine();
        }
        multiplicationDescription.close();
        scan = new Scanner(System.in);
        t = scan.nextLine();
        input = new String[t.length()];
        for (int i = 0; i < t.length(); i++) {
            input[i] = String.valueOf(t.charAt(i));
        }
        scan.close();
        Main.run(multiplicationMachine, input);

    }

}