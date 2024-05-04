import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Person;

class UserManagementPanel extends JPanel {
    private JList<Person> listUsers;
    private DefaultListModel<Person> modelUsers;
    private JButton btnAddUser, btnEditUser, btnDeleteUser;
    private ArrayList<Person> persons;

    public UserManagementPanel(ArrayList<Person> persons) {
        this.persons = persons;
        setLayout(new BorderLayout());

        modelUsers = new DefaultListModel<>();
        for (Person person : persons) {
            modelUsers.addElement(person);
        }

        listUsers = new JList<>(modelUsers);
        listUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listUsers), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        btnAddUser = new JButton("Add User");
        btnAddUser.addActionListener(e -> addUser());
        buttonPanel.add(btnAddUser);

        btnEditUser = new JButton("Edit User");
        btnEditUser.addActionListener(e -> editUser());
        buttonPanel.add(btnEditUser);

        btnDeleteUser = new JButton("Delete User");
        btnDeleteUser.addActionListener(e -> deleteUser());
        buttonPanel.add(btnDeleteUser);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addUser() {
        // This method should display a dialog to input new user details
        String name = JOptionPane.showInputDialog(this, "Enter user name:");
        String phone = JOptionPane.showInputDialog(this, "Enter phone number:");
        String password = JOptionPane.showInputDialog(this, "Enter password:");
        if (name != null && phone != null && password != null) {
            Person newUser = new Person(name, phone, password);  // Assuming Person can be directly instantiated
            persons.add(newUser);
            modelUsers.addElement(newUser);
        }
    }

    private void editUser() {
        Person selectedUser = listUsers.getSelectedValue();
        if (selectedUser != null) {
            String newName = JOptionPane.showInputDialog(this, "Edit name:", selectedUser.getName());
            String newPhone = JOptionPane.showInputDialog(this, "Edit phone number:", selectedUser.getPhoneNo());
            String newPassword = JOptionPane.showInputDialog(this, "Edit password:", selectedUser.getPassword());
            if (newName != null && newPhone != null && newPassword != null) {
                selectedUser.setName(newName);
                selectedUser.setPhoneNo(newPhone);
                selectedUser.setPassword(newPassword);
                listUsers.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No user selected!");
        }
    }

    private void deleteUser() {
        int selectedIndex = listUsers.getSelectedIndex();
        if (selectedIndex != -1) {
            Person selectedUser = modelUsers.remove(selectedIndex);
            persons.remove(selectedUser);
            JOptionPane.showMessageDialog(this, "User deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "No user selected!");
        }
    }
}
