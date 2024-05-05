package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.*;
import util.Initializer;
import java.awt.event.ActionEvent;

public class TicketSystemGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards; // A panel that uses CardLayout
    private LoginPanel loginPanel;
    private RegistrationPanel registrationPanel;
    private TicketSelectionPanel ticketSelectionPanel;
    private PaymentPanel paymentPanel;
    private DetailedTicketManagementPanel detailedTicketManagementPanel;
    private UserManagementPanel userManagementPanel;  // Assuming this panel is implemented similarly
    private PaymentCompletionPanel paymentCompletionPanel;

    public TicketSystemGUI() {
        super("Ticket System");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        // Initialize data models or utilities
        Initializer initializer = new Initializer();
        ArrayList<Person> persons = initializer.personInit();
        ArrayList<TicketInfo> ticketInfos = initializer.ticketInit();
        ArrayList<RockZoneTicket> rockTickets = initializer.rockZoneTicketsInit();
        ArrayList<VIPTicket> vipTickets = initializer.vipTicketsInit();
        ArrayList<NormalZoneTicket> normalTickets = initializer.normalZoneTicketsInit();

        // Setup the card layout and panels
        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) (cards.getLayout());
        
        // Instantiate the panels with necessary data
        loginPanel = new LoginPanel(persons);
        registrationPanel = new RegistrationPanel(persons);
        ticketSelectionPanel = new TicketSelectionPanel(ticketInfos, rockTickets, vipTickets, normalTickets);
        paymentPanel = new PaymentPanel(); // Modify constructor as needed to pass data
        detailedTicketManagementPanel = new DetailedTicketManagementPanel(ticketInfos, rockTickets, vipTickets, normalTickets);
        userManagementPanel = new UserManagementPanel(persons); // Assumes this panel is created for managing users
        paymentCompletionPanel = new PaymentCompletionPanel(this::handleBuyMoreTickets, this::handleLogout);

        // Add panels to CardLayout
        cards.add(loginPanel, "Login");
        cards.add(registrationPanel, "Register");
        cards.add(ticketSelectionPanel, "Ticket Selection");
        cards.add(paymentPanel, "Payment");
        cards.add(detailedTicketManagementPanel, "Manage Tickets");
        cards.add(userManagementPanel, "User Management");
        cards.add(paymentCompletionPanel, "PaymentCompletion");

        // Add the card panel to the JFrame
        getContentPane().add(cards);
        cardLayout.show(cards, "Login"); // Start with the Login panel
    }

    private void handleBuyMoreTickets(ActionEvent e) {
        cardLayout.show(cards, "Ticket Selection");
    }

    private void handleLogout(ActionEvent e) {
        cardLayout.show(cards, "Login");
    }

    public void switchTo(String card) {
        cardLayout.show(cards, card);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicketSystemGUI gui = new TicketSystemGUI();
            gui.setVisible(true);
        });
    }
}
