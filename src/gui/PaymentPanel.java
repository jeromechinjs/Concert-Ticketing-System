package gui;

import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JPanel {
    private JTextField txtAmountPaid;
    private JButton btnSubmitPayment;
    private double totalCost = 100.00; // This should be dynamically calculated based on the tickets

    public PaymentPanel() {
        setLayout(new GridLayout(2, 2));
        add(new JLabel("Total Cost: $" + totalCost));
        txtAmountPaid = new JTextField();
        add(new JLabel("Amount Paid:"));
        add(txtAmountPaid);

        btnSubmitPayment = new JButton("Submit Payment");
        btnSubmitPayment.addActionListener(e -> processPayment());
        add(btnSubmitPayment);
    }

    private void processPayment() {
        double amountPaid = parseAmount(txtAmountPaid.getText());
        double change = amountPaid - totalCost;

        // Update the PaymentCompletionPanel with the calculated change
        PaymentCompletionPanel completionPanel = findPaymentCompletionPanel();
        if (completionPanel != null) {
            completionPanel.setChange(change);
            ((CardLayout) getParent().getLayout()).show(getParent(), "PaymentCompletion");
        } else {
            System.err.println("PaymentCompletionPanel not found.");
        }
    }

    private double parseAmount(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount format.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;  // Return 0 or handle this scenario appropriately
        }
    }

    private PaymentCompletionPanel findPaymentCompletionPanel() {
        // Assuming the PaymentCompletionPanel is added to the parent container which uses CardLayout
        for (Component comp : getParent().getComponents()) {
            if (comp instanceof PaymentCompletionPanel) {
                return (PaymentCompletionPanel) comp;
            }
        }
        return null;
    }
}
