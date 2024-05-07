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
        // Update the PaymentCompletionPanel with the calculated change
        PaymentCompletionPanel completionPanel = findPaymentCompletionPanel();
        double amountPaid = parseAmount(txtAmountPaid.getText());
        double change = amountPaid - totalCost;
        boolean validationPassed = false;


        if (completionPanel != null) {
            // validation

             // if text field is empty
            if (txtAmountPaid.getText() == null) {
                JOptionPane.showMessageDialog(this, "Kindly enter the amount to pay.", "Error", JOptionPane.ERROR_MESSAGE);
                validationPassed = false;
            } else if (amountPaid < totalCost) {  // check payment is correct amount
                JOptionPane.showMessageDialog(this, "Insufficient amount. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                validationPassed = false;
            } else {
                validationPassed = true;
            }

        } else {
            System.err.println("PaymentCompletionPanel not found.");
        }

        if (validationPassed) {
            // go to payment page
            completionPanel.setChange(change);
            ((CardLayout) getParent().getLayout()).show(getParent(), "PaymentCompletion");
        }
    }

    // Validation: Make sure correct data type (double) is entered only
    private double parseAmount(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Kindly enter the correct data type.", "Error", JOptionPane.ERROR_MESSAGE);
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
