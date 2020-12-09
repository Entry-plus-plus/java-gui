import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class User {

    String username;
    String firstName;
    String lastName;
    String password = passwordHasher.hashPassword("password");
    Group[] groups;
    String office;
    String telephoneNumber;
    String email;
    Time[] logonHours;
    Boolean mustChangePassword;
    Boolean PWNeverExpires;
    Boolean accountDisabled;

    //maakt de elementen van het user info panel
    JPanel userInfoPanel = new JPanel();
    JButton generalButton = new JButton("General");
    JButton accountButton = new JButton("Account");
    JButton groupsButton = new JButton("Groups");

    JPanel generalPanel = new JPanel();
    public JLabel usernameLabel = new JLabel("Username");
    JTextField usernameField = new JTextField();
    JLabel firstNameLabel = new JLabel("First Name");
    JTextField firstNameField = new JTextField();
    JLabel lastNameLabel = new JLabel("Last Name");
    JTextField lastNameField = new JTextField();
    JLabel officeLabel = new JLabel("Office");
    JTextField officeField = new JTextField();
    JLabel telephoneNumberLabel = new JLabel("Telephone number");
    JTextField telephoneNumberField = new JTextField();
    JLabel emailLabel = new JLabel("Email address");
    JTextField emailField = new JTextField();

    JPanel accountPanel = new JPanel();
    JLabel mustChangePasswordLabel = new JLabel("User must change password at next logon");
    JRadioButton mustChangePasswordButton = new JRadioButton();
    JLabel PWNeverExpiresLAbel = new JLabel("Password never expires");
    JRadioButton PWNeverExpiresButton = new JRadioButton();
    JLabel accountDisabledLabel = new JLabel("Disable account");
    JRadioButton accountDisabledButton = new JRadioButton();

    JPanel groupsPanel = new JPanel();
    JList<String> groupsList = new JList<>();
    JButton addToGroupButton = new JButton("Add to new group");
    JButton removeFromGroupButton = new JButton("Remove from group");


    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;

        createUserInfoPanel();
    }

    public void createUserInfoPanel() {
        createGeneralPanel();
        userInfoPanel.add(generalPanel);
    }

    private void createGeneralPanel() {
        GridLayout layout = new GridLayout(6,2);
        generalPanel.setLayout(layout);

        usernameField.setText(username);
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        officeField.setText(office);
        telephoneNumberField.setText(telephoneNumber);
        emailField.setText(email);

        usernameField.setEditable(false);
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        officeField.setEditable(false);
        telephoneNumberField.setEditable(false);
        emailField.setEditable(false);

        generalPanel.add(usernameLabel);
        generalPanel.add(usernameField);
        generalPanel.add(firstNameLabel);
        generalPanel.add(firstNameField);
        generalPanel.add(lastNameLabel);
        generalPanel.add(lastNameField);
        generalPanel.add(officeLabel);
        generalPanel.add(officeField);
        generalPanel.add(telephoneNumberLabel);
        generalPanel.add(telephoneNumberField);
        generalPanel.add(emailLabel);
        generalPanel.add(emailField);

        giveColors();
    }

    private void createAccountPanel() {
        accountPanel.setLayout(new GridLayout(3,2));

        accountPanel.add(mustChangePasswordLabel);

    }

    private void createGroupsPanel() {

    }

    public void editUser() {
        username = usernameField.getText();
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        office = officeField.getText();
        telephoneNumber = telephoneNumberField.getText();
        email = emailField.getText();

        usernameField.setEditable(false);
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        officeField.setEditable(false);
        telephoneNumberField.setEditable(false);
        emailField.setEditable(false);

        userInfoPanel.remove(GUI.users.confirmEditButton);
        GUI.administration.setVisible(true);
    }

    //method waarmee je het wachtwoord van de user kan veranderen
    public void changePassword(String oldPassword, String newPassword, String confirmPassword) {

        //hasht de wachtwoorden, want veiligheid
        String hashedOld = passwordHasher.hashPassword(oldPassword);
        String hashedNew = passwordHasher.hashPassword(newPassword);
        String hashedConfirm = passwordHasher.hashPassword(confirmPassword);

        //als OldPassword overeenkomt met het bestaande wachtwoord en het nieuwe en de confirmation komen overeen
        //dan wordt het wachtwoord veranderd en wordt er een boodschap getoond dat het gelukt is
        if (hashedOld.equals(password) && hashedNew.equals(hashedConfirm)) {
                password = hashedNew;
                Settings.passwordChangedLabel.setText("Password changed.");
            }
    }

    public void resetPassword() {

    }

    public void addToGroup(Group group) {

    }
    public  void removeFromGroup (Group group) {

    }

    public void giveColors() {
        userInfoPanel.setBackground(GUI.darkColor);
        generalPanel.setBackground(GUI.darkColor);
        usernameLabel.setForeground(GUI.lightColor);
        usernameField.setBackground(GUI.darkColor2);
        usernameField.setForeground(GUI.lightColor);
        firstNameLabel.setForeground(GUI.lightColor);
        firstNameField.setBackground(GUI.darkColor2);
        firstNameField.setForeground(GUI.lightColor);
        lastNameLabel.setForeground(GUI.lightColor);
        lastNameField.setBackground(GUI.darkColor2);
        lastNameField.setForeground(GUI.lightColor);
        officeLabel.setForeground(GUI.lightColor);
        officeField.setBackground(GUI.darkColor2);
        officeField.setForeground(GUI.lightColor);
        telephoneNumberLabel.setForeground(GUI.lightColor);
        telephoneNumberField.setBackground(GUI.darkColor2);
        telephoneNumberField.setForeground(GUI.lightColor);
        emailLabel.setForeground(GUI.lightColor);
        emailField.setBackground(GUI.darkColor2);
        emailField.setForeground(GUI.lightColor);

    }
}
