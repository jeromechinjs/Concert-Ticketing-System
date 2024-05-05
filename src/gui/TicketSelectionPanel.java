package gui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.TicketInfo;
import model.RockZoneTicket;
import model.VIPTicket;
import model.NormalZoneTicket;

class TicketSelectionPanel extends JPanel {
    private JComboBox<TicketInfo> comboConcerts;
    private JComboBox<String> comboTicketType;
    private JTextField txtQuantity;
    private JButton btnAddToCart, btnCheckout;
    private ArrayList<TicketInfo> ticketInfos;
    private ArrayList<RockZoneTicket> rockZoneTickets;
    private ArrayList<VIPTicket> vipTickets;
    private ArrayList<NormalZoneTicket> normalZoneTickets;

    public TicketSelectionPanel(ArrayList<TicketInfo> ticketInfos,
                                ArrayList<RockZoneTicket> rockZoneTickets,
                                ArrayList<VIPTicket> vipTickets,
                                ArrayList<NormalZoneTicket> normalZoneTickets) {
        this.ticketInfos = ticketInfos;
        this.rockZoneTickets = rockZoneTickets;
        this.vipTickets = vipTickets;
        this.normalZoneTickets = normalZoneTickets;
        
        setLayout(new GridLayout(5, 2, 10, 10));  // Using GridLayout for simplicity

        comboConcerts = new JComboBox<>(ticketInfos.toArray(new TicketInfo[0]));
        add(new JLabel("Select Concert:"));
        add(comboConcerts);

        comboTicketType = new JComboBox<>(new String[]{"Rock", "VIP", "Normal"});
        add(new JLabel("Select Ticket Type:"));
        add(comboTicketType);

        txtQuantity = new JTextField();
        add(new JLabel("Quantity:"));
        add(txtQuantity);

        btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.addActionListener(e -> addToCart());
        add(btnAddToCart);

        btnCheckout = new JButton("Checkout");
        btnCheckout.addActionListener(e -> proceedToCheckout());
        add(btnCheckout);
    }

    private void addToCart() {
        // Example of adding to cart functionality, assuming cart management is handled elsewhere
        String selectedConcert = comboConcerts.getSelectedItem().toString();
        String ticketType = comboTicketType.getSelectedItem().toString();
        int quantity;
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
            JOptionPane.showMessageDialog(this, "Added " + quantity + " " + ticketType + " tickets for " + selectedConcert + " to cart.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void proceedToCheckout() {
        // Example of checkout functionality
        JOptionPane.showMessageDialog(this, "Proceeding to checkout...");
        // Transition to a payment panel or confirmation screen would occur here

        // Trigger panel switch to the payment panel or confirmation screen
    ((TicketSystemGUI) SwingUtilities.getWindowAncestor(this)).switchTo("Payment");
    }
}
