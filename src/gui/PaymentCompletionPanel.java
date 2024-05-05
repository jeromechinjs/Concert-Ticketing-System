package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaymentCompletionPanel extends JPanel {
    private JLabel lblChange;
    private JButton btnBuyMoreTickets;
    private JButton btnLogout;

    public PaymentCompletionPanel(ActionListener buyMoreListener, ActionListener logoutListener) {
        setLayout(new GridLayout(3, 1));  // Simple grid layout for the components

        // Label to display change
        lblChange = new JLabel("Change Returned: $0.00", SwingConstants.CENTER);
        add(lblChange);

        // Button to buy more tickets
        btnBuyMoreTickets = new JButton("Buy More Tickets");
        btnBuyMoreTickets.addActionListener(buyMoreListener);
        add(btnBuyMoreTickets);

        // Button to logout
        btnLogout = new JButton("Logout");
        btnLogout.addActionListener(logoutListener);
        add(btnLogout);
    }

    public void setChange(double change) {
        lblChange.setText("Change Returned: $" + String.format("%.2f", change));
    }
}
