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
    private JButton btnAddTicket, btnUpdateTicket, btnDeleteTicket;
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

        cbTicketType = new JComboBox<>(new String[]{"Rock", "VIP", "Normal"});
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
        formPanel.add(btnAddTicket);

        btnUpdateTicket = new JButton("Update Ticket");
        // Implementation needed for update functionality
        formPanel.add(btnUpdateTicket);

        btnDeleteTicket = new JButton("Delete Ticket");
        // Implementation needed for delete functionality
        formPanel.add(btnDeleteTicket);

        add(formPanel, BorderLayout.SOUTH);
    }

    private void updateTicketList(ArrayList<RockZoneTicket> rockZoneTickets, ArrayList<VIPTicket> vipTickets, ArrayList<NormalZoneTicket> normalZoneTickets) {
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
}
