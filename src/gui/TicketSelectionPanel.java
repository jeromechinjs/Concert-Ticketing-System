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
    private boolean addedToCart = false; // validation check before proceeding to checkout

    public TicketSelectionPanel(
            ArrayList<TicketInfo> ticketInfos,
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
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // Using GridLayout for form elements

        comboConcerts = new JComboBox<>(ticketInfos.toArray(new TicketInfo[0]));
        formPanel.add(new JLabel("Select Concert:"));
        formPanel.add(comboConcerts);

        comboTicketType = new JComboBox<>(new String[] { "Rock", "VIP", "Normal" });
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

        btnCheckout = new JButton("Info");
        btnCheckout.addActionListener(e -> DisplaySeat(rockZoneTickets, vipTickets, normalZoneTickets));
        formPanel.add(btnCheckout);

        add(formPanel, BorderLayout.CENTER);
    }

    private void addToCart() {
        try {
            TicketInfo selectedConcert = (TicketInfo) comboConcerts.getSelectedItem();
            String ticketType = (String) comboTicketType.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText());
            int desiredNumber = 12; // Change this to your desired number for validation

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

            //ticketType[i].getPrice();

            addedToCart = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTicketList(ArrayList<? extends Ticket> tickets, TicketInfo concert, int inputQuantity) {

        int quantity = inputQuantity;

        // updated the available seat left
        int i = 0;

        for (Ticket ticket : tickets) {
            if (tickets.get(i).getTicketInfo().getArtist().equals(concert.getArtist())) {

                if (quantity > ticket.getAvailableTicket()) {
                    JOptionPane.showMessageDialog(this,
                            "Seat is limited!\n" + " Seat left: " + ticket.getAvailableTicket(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    int updatedSeat = ticket.getAvailableTicket() - quantity;
                    ticket.setAvailableTicket(updatedSeat);

                    JOptionPane.showMessageDialog(this, " Seat added: " + quantity + " \n " + concert + "\n" +
                            tickets.get(i));
                    break;
                }
            } else
                JOptionPane.showMessageDialog(this,
                        tickets.get(i).getTicketInfo() + " not matches " + concert);

            i++;
        }

    }

    private void proceedToCheckout() {
        if (addedToCart) { // if tickets not yet added to cart, display error dialog
            // calculate total to pay

            System.out.println("Proceeding to checkout..."); // Debug print
            ((CardLayout) getParent().getLayout()).show(getParent(), "Payment");
        } else {
            JOptionPane.showMessageDialog(this, "Nothin in cart. Please add to cart first.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void DisplaySeat(ArrayList<? extends Ticket> tickets, ArrayList<? extends Ticket> tickets2,
            ArrayList<? extends Ticket> tickets3) {
        for (Ticket ticket : tickets) {
            for (Ticket ticket2 : tickets2) {
                int ind = 0;
                for (Ticket ticket3 : tickets3) {
                    JOptionPane.showMessageDialog(this,
                            ticket.getTicketInfo().getArtist() + "\n-------------------\n" + " Seat Available: "
                                    + ticket.getAvailableTicket() + " Rock Price: RM" + ticket.getPrice()
                                    + "\n Seat Available: "
                                    + ticket.getAvailableTicket() + " VIP Price: RM" + ticket2.getPrice()
                                    + "\n Seat Available: "
                                    + ticket.getAvailableTicket() + " Normal Price: RM" + ticket3.getPrice());
                    ind++;

                }
                break;
            }
            break;
        }

    }
}
