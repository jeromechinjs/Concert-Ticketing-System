package gui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Person;
import model.Staff;
import model.VIPCustomer;

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
    boolean loginSuccessful = false;

    for (Person person : persons) {
        if (person.checkUsernameAndPassword(username, password)) {
            loginSuccessful = true;
            JOptionPane.showMessageDialog(this, "Login Successful!");

            // Example of handling different user roles:
            if (person instanceof Staff) {
                ((CardLayout) getParent().getLayout()).show(getParent(), "Manage Tickets");
            } else if (person instanceof VIPCustomer) {
                ((CardLayout) getParent().getLayout()).show(getParent(), "VIP Ticket Selection");
            } else {
                ((CardLayout) getParent().getLayout()).show(getParent(), "Ticket Selection");
            }
            break;  // Exit the loop as login is successful
        }
    }

    if (!loginSuccessful) {
        JOptionPane.showMessageDialog(this, "Login Failed. Please check your credentials.");
    } else {
        // Default fallback panel if no specific role-based redirection occurs
        ((CardLayout) getParent().getLayout()).show(getParent(), "DefaultPanel");
    }
}


    private void switchToRegister() {
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "Register");
    }
}
