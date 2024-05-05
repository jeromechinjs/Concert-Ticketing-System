package gui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import model.Customer;
import model.Person;
import model.Staff;

class LoginPanel extends JPanel {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnGoToRegister;
    private ArrayList<Person> persons;

    public LoginPanel(ArrayList<Person> persons) {
        this.persons = persons;
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> performLogin());
        add(btnLogin);

        btnGoToRegister = new JButton("Go to Register");
        btnGoToRegister.addActionListener(e -> switchToRegister());
        add(btnGoToRegister);
    }

    private void performLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        boolean found = false;
        for (Person person : persons) {
            if (person.checkUsernameAndPassword(username, password)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                found = true;
                // Determine the role of the logged-in user
            if (person instanceof Staff) {
                // If the user is a staff member, switch to the DetailTicketManagementPanel
                ((TicketSystemGUI) SwingUtilities.getWindowAncestor(this)).switchTo("Manage Tickets");
            } else if (person instanceof Customer) {
                // If the user is a customer, switch to the TicketSelectionPanel
                ((TicketSystemGUI) SwingUtilities.getWindowAncestor(this)).switchTo("Ticket Selection");
            }
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(this, "Login Failed. Please check your credentials.");
        }
    }

    private void switchToRegister() {
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "Register");
    }
}
