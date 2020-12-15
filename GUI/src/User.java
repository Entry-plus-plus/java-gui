import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;

public class User {

    String username;
    String firstName;
    String lastName;
    String password = passwordHasher.hashPassword("password");
    ArrayList<Group> groups = new ArrayList<>();
    String office;
    String telephoneNumber;
    String email;
    Time[] logonHours;
    Boolean mustChangePassword = false;
    Boolean PWNeverExpires;
    Boolean accountDisabled = false;

    //maakt de elementen van het user info panel
    JPanel userInfoPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JButton generalButton = new JButton("General");
    JButton accountButton = new JButton("Account");
    JButton groupsButton = new JButton("Groups");
    JButton selectedButton = generalButton;

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
    JButton resetPasswordButton = new JButton("Reset password");
    JLabel passwordHasBeenResetLabel = new JLabel(" ");

    JPanel accountPanel = new JPanel();
    JLabel mustChangePasswordLabel = new JLabel("User must change password at next logon");
    JRadioButton mustChangePasswordButton = new JRadioButton();
    JLabel PWNeverExpiresLAbel = new JLabel("Password never expires");
    JRadioButton PWNeverExpiresButton = new JRadioButton();
    JLabel accountDisabledLabel = new JLabel("Disable account");
    JRadioButton accountDisabledButton = new JRadioButton();

    JPanel groupsPanel = new JPanel();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> groupsList = new JList<>(listModel);
    JButton addToGroupButton = new JButton("Add to new group");
    JButton removeFromGroupButton = new JButton("Remove from group");


    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;

        createUserInfoPanel();
        makeButtonsWork();
    }

    public void createUserInfoPanel() {
        userInfoPanel.setLayout(new BoxLayout(userInfoPanel, BoxLayout.Y_AXIS));
        createButtonsPanel();
        createGeneralPanel();
        //createAccountPanel();
        createGroupsPanel();
        try {
            userInfoPanel.remove(1);
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        userInfoPanel.add(buttonsPanel);
        userInfoPanel.add(generalPanel);
    }

    public void createButtonsPanel() {
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(generalButton);
        //buttonsPanel.add(accountButton);
        buttonsPanel.add(groupsButton);

    }

    private void createGeneralPanel() {
        GridLayout layout = new GridLayout(7,2);
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
        generalPanel.add(resetPasswordButton);
        generalPanel.add(passwordHasBeenResetLabel);

        giveColors();
    }

    private void createAccountPanel() {
        accountPanel.setLayout(new GridLayout(3,2));

        accountPanel.add(mustChangePasswordLabel);
        accountPanel.add(mustChangePasswordButton);
        accountPanel.add(PWNeverExpiresLAbel);
        accountPanel.add(PWNeverExpiresButton);
        accountPanel.add(accountDisabledLabel);
        accountPanel.add(accountDisabledButton);

        giveColors();
    }

    private void createGroupsPanel() {
        fillList();

        GroupLayout layout = new GroupLayout(groupsPanel);
        groupsPanel.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                    .addComponent(groupsList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addToGroupButton)
                        .addComponent(removeFromGroupButton))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addComponent(groupsList)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(addToGroupButton)
                        .addComponent(removeFromGroupButton))
        );


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
                mustChangePassword = false;
            }
    }

    public void resetPassword() {
        password = passwordHasher.hashPassword("password");
        passwordHasBeenResetLabel.setText("Password has been reset");
    }

    public void makeButtonsWork() {
        generalButton.addActionListener(e -> {
            userInfoPanel.remove(1);
            userInfoPanel.add(generalPanel);
            GUI.administration.setVisible(true);
        });

        accountButton.addActionListener(e -> {
            userInfoPanel.remove(1);
            userInfoPanel.add(accountPanel);
            GUI.administration.setVisible(true);
        });

        groupsButton.addActionListener(e -> {
            userInfoPanel.remove(1);
            userInfoPanel.add(groupsPanel);
            GUI.administration.setVisible(true);
        });

        addToGroupButton.addActionListener(e -> {
            String groupname = GUI.administration.groups.groupsList.getSelectedValue();
            for (Group group : GUI.groupsArrayList) {
                if (group.groupName.equals(groupname)) {
                    addToGroup(group);
                    return;
                }
            }
        });

        removeFromGroupButton.addActionListener(e -> {
            String groupname = groupsList.getSelectedValue();
            for (Group group : GUI.groupsArrayList) {
                if (group.groupName.equals(groupname)) {
                    removeFromGroup(group);
                    return;
                }
            }
        });

        resetPasswordButton.addActionListener(e -> {
            resetPassword();
        });
    }

    public void addToGroup(Group group) {
        if (!groups.contains(group)) {
            groups.add(group);
        }
        if (!group.members.contains(this)) {
            group.members.add(this);
        }
        fillList();
        GUI.administration.setVisible(true);
    }

    public  void removeFromGroup (Group group) {
        groups.remove(group);
        group.members.remove(this);
        fillList();
        GUI.administration.setVisible(true);
    }

    public void fillList()  {
        listModel.clear();
        for (Group group : groups) {
            listModel.addElement(group.groupName);
        }
    }

    public void giveColors() {
        userInfoPanel.setBackground(GUI.darkColor);

        buttonsPanel.setBackground(GUI.darkColor);
        generalButton.setBackground(GUI.lightColor2);
        generalButton.setForeground(GUI.darkColor);
        accountButton.setBackground(GUI.lightColor2);
        accountButton.setForeground(GUI.darkColor);
        groupsButton.setBackground(GUI.lightColor2);
        groupsButton.setForeground(GUI.darkColor);

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
        resetPasswordButton.setBackground(GUI.lightColor2);
        resetPasswordButton.setForeground(GUI.darkColor);
        passwordHasBeenResetLabel.setForeground(GUI.lightColor);

        accountPanel.setBackground(GUI.darkColor);
        mustChangePasswordLabel.setForeground(GUI.lightColor);
        mustChangePasswordButton.setBackground(GUI.darkColor);
        PWNeverExpiresLAbel.setForeground(GUI.lightColor);
        PWNeverExpiresButton.setBackground(GUI.darkColor);
        accountDisabledLabel.setForeground(GUI.lightColor);
        accountDisabledButton.setBackground(GUI.darkColor);

        groupsPanel.setBackground(GUI.darkColor);
        groupsList.setBackground(GUI.darkColor);
        groupsList.setForeground(GUI.lightColor);
        addToGroupButton.setBackground(GUI.lightColor2);
        addToGroupButton.setForeground(GUI.darkColor);
        removeFromGroupButton.setBackground(GUI.lightColor2);
        removeFromGroupButton.setForeground(GUI.darkColor);
    }
}
