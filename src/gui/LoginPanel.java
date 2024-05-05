package gui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import model.Customer;
import model.Person;

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
                break;
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
