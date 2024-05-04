import java.util.Scanner;
//import java.io.IOException;

public class UI {
    Scanner scanner = new Scanner(System.in);

    public void mainMenuDisplay() {
        System.out.println("UNIVERSITY SYSTEM");
    }

    /**
     * @param max : auto validating the input lenght
     * @return an int of the choice selected by user
     */
    public int getChoice(int max) {
        int maxinput = max;
        int choice = 20202;
        do {
            System.out.println("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                print("Invalid Choice!");
                choice = 99999;
                scanner.nextLine();
            } else {
                choice = scanner.nextInt();
                scanner.nextLine();
            }
        } while (choice < 0 || choice > maxinput);

        return choice;
    }

    // ease the coding experience
    public void print(String x) {
        System.out.println(x);
    }

}
