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

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(e -> performRegistration());
        add(btnRegister);

        btnGoToLogin = new JButton("Back to Login");
        btnGoToLogin.addActionListener(e -> switchToLogin());
        add(btnGoToLogin);
    }

    private void performRegistration() {
        String username = txtUsername.getText();
        String phone = txtPhone.getText();
        String password = txtPassword.getText();
        Customer newCustomer = new Customer(0, username, phone, password);
        persons.add(newCustomer);
        JOptionPane.showMessageDialog(this, "Registration Successful! Please login.");
        switchToLogin();
    }

    private void switchToLogin() {
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "Login");
    }
}
