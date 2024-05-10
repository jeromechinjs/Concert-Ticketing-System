package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.TicketInfo;
import model.RockZoneTicket;
import model.VIPTicket;
import model.NormalZoneTicket;

class DetailedTicketManagementPanel extends JPanel {
    private JTextField txtArtist, txtDate, txtVenue, txtPrice, txtQuantity;
    private JComboBox<String> cbTicketType;
    private JButton btnAddTicket, btnUpdateTicket, btnDeleteTicket, btnGoToLogin;
    private JList<String> listTickets;
    private DefaultListModel<String> modelTickets;

    public DetailedTicketManagementPanel(ArrayList<TicketInfo> ticketInfos, ArrayList<RockZoneTicket> rockZoneTickets,
            ArrayList<VIPTicket> vipTickets, ArrayList<NormalZoneTicket> normalZoneTickets) {
        setLayout(new BorderLayout());
        modelTickets = new DefaultListModel<>();
        updateTicketList(rockZoneTickets, vipTickets, normalZoneTickets);

        listTickets = new JList<>(modelTickets);
        add(new JScrollPane(listTickets), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(0, 2));
        txtArtist = new JTextField();
        txtDate = new JTextField();
        txtVenue = new JTextField();
        txtPrice = new JTextField();
        txtQuantity = new JTextField();

        cbTicketType = new JComboBox<>(new String[] { "Rock", "VIP", "Normal" });
        formPanel.add(new JLabel("Ticket Type:"));
        formPanel.add(cbTicketType);

        formPanel.add(new JLabel("Artist:"));
        formPanel.add(txtArtist);
        formPanel.add(new JLabel("Date:"));
        formPanel.add(txtDate);
        formPanel.add(new JLabel("Venue:"));
        formPanel.add(txtVenue);
        formPanel.add(new JLabel("Price:"));
        formPanel.add(txtPrice);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(txtQuantity);

        btnAddTicket = new JButton("Add Ticket");
        btnAddTicket.addActionListener(e -> addTicket(ticketInfos, rockZoneTickets, vipTickets, normalZoneTickets));
        btnAddTicket.setBackground(new Color(120, 255, 126));
        formPanel.add(btnAddTicket);

        btnUpdateTicket = new JButton("Update Ticket");

        btnUpdateTicket.addActionListener(e -> updateTicket());
        btnUpdateTicket.setBackground(new Color(253, 255, 109));
        formPanel.add(btnUpdateTicket);

        btnDeleteTicket = new JButton("Delete Ticket");
        btnDeleteTicket.addActionListener(e -> deleteTicket());
        btnDeleteTicket.setBackground(new Color(255, 144, 120));
        formPanel.add(btnDeleteTicket);

        btnGoToLogin = new JButton("Back to Login");
        btnGoToLogin.addActionListener(e -> switchToLogin());
        formPanel.add(btnGoToLogin);

        add(formPanel, BorderLayout.SOUTH);
    }

    private void updateTicketList(ArrayList<RockZoneTicket> rockZoneTickets, ArrayList<VIPTicket> vipTickets,
            ArrayList<NormalZoneTicket> normalZoneTickets) {
        modelTickets.clear();
        rockZoneTickets.forEach(ticket -> modelTickets.addElement("Rock: " + ticket.toString()));
        vipTickets.forEach(ticket -> modelTickets.addElement("VIP: " + ticket.toString()));
        normalZoneTickets.forEach(ticket -> modelTickets.addElement("Normal: " + ticket.toString()));
    }

    private void addTicket(ArrayList<TicketInfo> ticketInfos, ArrayList<RockZoneTicket> rockZoneTickets,
            ArrayList<VIPTicket> vipTickets, ArrayList<NormalZoneTicket> normalZoneTickets) {
        TicketInfo newTicketInfo = new TicketInfo(txtArtist.getText(), txtDate.getText(), txtVenue.getText());
        ticketInfos.add(newTicketInfo);
        int price = Integer.parseInt(txtPrice.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());

        switch (cbTicketType.getSelectedItem().toString()) {
            case "Rock":
                rockZoneTickets.add(new RockZoneTicket(price, newTicketInfo, quantity));
                break;
            case "VIP":
                vipTickets.add(new VIPTicket(price, newTicketInfo, quantity));
                break;
            case "Normal":
                normalZoneTickets.add(new NormalZoneTicket(price, newTicketInfo, quantity));
                break;
        }
        updateTicketList(rockZoneTickets, vipTickets, normalZoneTickets);
        JOptionPane.showMessageDialog(this, "Ticket added successfully!");
    }

    private void updateTicket() {
        // Get the selected ticket from the list
        String selectedTicket = listTickets.getSelectedValue();
        if (selectedTicket != null) {
            // Implement the logic to update the ticket details
            // For example:
            String newArtist = txtArtist.getText();
            String newDate = txtDate.getText();
            String newVenue = txtVenue.getText();
            String newPrice = txtPrice.getText();
            String newQuantity = txtQuantity.getText();

            // Update the ticket details in the list
            modelTickets.set(listTickets.getSelectedIndex(), selectedTicket);
            // Notify the user about the update
            JOptionPane.showMessageDialog(this, "Ticket updated successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No ticket selected!");
        }
    }

    private void deleteTicket() {
        int selectedIndex = listTickets.getSelectedIndex();
        if (selectedIndex != -1) {
            // Remove the selected ticket from the list
            modelTickets.remove(selectedIndex);
            // Notify the user about the deletion
            JOptionPane.showMessageDialog(this, "Ticket deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No ticket selected!");
        }
    }

    private void switchToLogin() {
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "Login");
    }
}
