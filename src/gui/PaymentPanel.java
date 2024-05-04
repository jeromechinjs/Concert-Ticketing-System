import javax.swing.*;
import java.awt.*;
import model.Customer;

class PaymentPanel extends JPanel {
    private JTextField txtAmount, txtCardNumber;
    private JButton btnPay, btnBack;
    private Customer customer;  // Assuming customer details are needed for payment processing

    public PaymentPanel(Customer customer) {
        this.customer = customer;
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Amount:"));
        txtAmount = new JTextField();
        add(txtAmount);

        add(new JLabel("Card Number:"));
        txtCardNumber = new JTextField();
        add(txtCardNumber);

        btnPay = new JButton("Pay Now");
        btnPay.addActionListener(e -> processPayment());
        add(btnPay);

        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> switchToPreviousPanel());
        add(btnBack);
    }

    private void processPayment() {
        // Process payment here
        JOptionPane.showMessageDialog(this, "Payment processed successfully!");
    }

    private void switchToPreviousPanel() {
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.previous(getParent());
    }
}
