package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Customer;
import model.Person;

class RegistrationPanel extends JPanel {
    private JTextField txtUsername, txtPhone, txtPassword;
    private JButton btnRegister, btnGoToLogin;
    private ArrayList<Person> persons;

    public RegistrationPanel(ArrayList<Person> persons) {
        this.persons = persons;
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Phone Number:"));
        txtPhone = new JTextField();
        add(txtPhone);

        add(new JLabel("Password:"));
        txtPassword = new JTextField();
        add(txtPassword);

        btnGoToLogin = new JButton("Back to Login");
        btnGoToLogin.addActionListener(e -> switchToLogin());
        add(btnGoToLogin);

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(e -> performRegistration());
        add(btnRegister);

    }

    private void performRegistration() {
        boolean validationPassed = false;
        String username = txtUsername.getText();
        String phone = txtPhone.getText();
        String password = txtPassword.getText();


        // Validation checks
        // if text field is empty
        if (username.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kindly fill in all account details.", "Error", JOptionPane.ERROR_MESSAGE);
            validationPassed = false;
        } else {
            validationPassed = true;
        }

        if (validationPassed) {
            Customer newCustomer = new Customer(0, username, phone, password);
            persons.add(newCustomer);
            JOptionPane.showMessageDialog(this, "Registration Successful! Please login.");
            switchToLogin();
        }

    }

    private void switchToLogin() {
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "Login");
    }

}
