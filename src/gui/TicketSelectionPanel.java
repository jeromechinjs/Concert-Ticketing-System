package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.*;

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
        
        setLayout(new BorderLayout());
        initUIComponents();
    }

    private void initUIComponents() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));  // Using GridLayout for form elements

        comboConcerts = new JComboBox<>(ticketInfos.toArray(new TicketInfo[0]));
        formPanel.add(new JLabel("Select Concert:"));
        formPanel.add(comboConcerts);

        comboTicketType = new JComboBox<>(new String[]{"Rock", "VIP", "Normal"});
        formPanel.add(new JLabel("Select Ticket Type:"));
        formPanel.add(comboTicketType);

        txtQuantity = new JTextField();
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(txtQuantity);

        btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.addActionListener(e -> addToCart());
        formPanel.add(btnAddToCart);

        btnCheckout = new JButton("Checkout");
        btnCheckout.addActionListener(e -> proceedToCheckout());
        formPanel.add(btnCheckout);

        add(formPanel, BorderLayout.CENTER);
    }

    private void addToCart() {
        try {
            TicketInfo selectedConcert = (TicketInfo) comboConcerts.getSelectedItem();
            String ticketType = (String) comboTicketType.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText());

            switch (ticketType) {
                case "Rock":
                    updateTicketList(rockZoneTickets, selectedConcert, quantity);
                    break;
                case "VIP":
                    updateTicketList(vipTickets, selectedConcert, quantity);
                    break;
                case "Normal":
                    updateTicketList(normalZoneTickets, selectedConcert, quantity);
                    break;
            }

            JOptionPane.showMessageDialog(this, "Added " + quantity + " " + ticketType + " tickets for " + selectedConcert.getArtist() + " to cart.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTicketList(ArrayList<? extends Ticket> tickets, TicketInfo concert, int quantity) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketInfo().equals(concert)) {
                // Here you would actually adjust ticket quantities, check availability, etc.
                break;
            }
        }
    }

    private void proceedToCheckout() {
        System.out.println("Proceeding to checkout..."); // Debug print
        ((CardLayout) getParent().getLayout()).show(getParent(), "Payment");
    }
}
