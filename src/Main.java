import gui.TicketSystemGUI;
import util.Initializer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Your existing initialization code
        Initializer init = new Initializer();
        // Assuming TicketSystemGUI handles everything including initialization
        TicketSystemGUI gui = new TicketSystemGUI();
        gui.setVisible(true);
    }
}
