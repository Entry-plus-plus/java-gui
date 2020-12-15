import javax.swing.*;
import java.awt.*;

public class Administration extends GUI{

    //maakt de elementen van het administration scherm
    final JPanel administrationPanel = new JPanel();
    final JLabel administrationLabel = new JLabel("This is where the administrator can do administrator things");
    final JPanel mainview = new JPanel();
    final JButton logOutButton = new JButton("log out");
    JPanel userInfoPanel = new JPanel();
    JPanel fillerPanel1 = new JPanel();
    JPanel fillerPanel2 = new JPanel();

    JButton addAdminButton = new JButton("Add new administrator");
    JPanel addNewAdminPanel = new JPanel();
    JLabel newAdminCodeLabel = new JLabel("Admncode of new user");
    JTextField newAdminCode = new JTextField();
    final JLabel newAdminUsernameLabel = new JLabel("Username of new admin:");
    JTextField newAdminUsername = new JTextField();
    final JLabel newAdminFirstNameLabel = new JLabel("First name of new admin:");
    JTextField newAdminFirstName = new JTextField();
    final JLabel newAdminLastNameLabel = new JLabel("Last name of new admin:");
    JTextField newAdminLastName = new JTextField();
    final JButton createNewAdminButton = new JButton("create");

    //maakt de elementen van het create new user scherm
    JFrame frame;
    final JPanel addNewUserPanel = new JPanel();
    JLabel newUserCodeLabel = new JLabel("Usercode of new user");
    JTextField newUserCode = new JTextField();
    final JLabel newUsernameLabel = new JLabel("Username of new user:");
    JTextField newUsername = new JTextField();
    final JLabel newFirstNameLabel = new JLabel("First name of new user:");
    JTextField newFirstName = new JTextField();
    final JLabel newLastNameLabel = new JLabel("Last name of new user:");
    JTextField newLastName = new JTextField();
    final JButton createNewUserButton = new JButton("create");

    //maakt de elementen van het create new group scherm
    final JPanel addNewGroupPanel = new JPanel();
    final JLabel newGroupnameLabel = new JLabel("name of new group:");
    final JTextField newGroupName = new JTextField();
    final JButton createNewGroupButton = new JButton("create");

    Group selectedGroup;

    public Administration() {
        setTitle("Entry++ - Administration");

        users = new Users();
        groups = new Groups();
        authorizations = new Authorizations();

        mainview.setLayout(new BoxLayout(mainview, BoxLayout.Y_AXIS));
        createAdministrationLayout();
        mainview.add(logOutButton);
        mainview.add(administrationPanel);

        //maakt het zichtbaar
        setContentPane(mainview);

        setSizeEtc(this);

        //zorgt dat je uitlogt als de op de logout knop drukt
        logOutButton.addActionListener(e -> {
            dispose();
            viewLoginScreen();
        });

        addAdminButton.addActionListener(e -> {
            createNewAdminFrame();
        });

        //maakt een nieuwe user aan als je op de create knop drukt

        giveColors();
    }

    public void createAdministrationLayout() {

        GridLayout layout = new GridLayout(3,2);
        administrationPanel.setLayout(layout);
        //administrationPanel.add(fillerPanel1);
        //administrationPanel.add(logOutButton);
        administrationPanel.add(users.usersPanel);
        administrationPanel.add(userInfoPanel);
        administrationPanel.add(groups.groupsPanel);
        //administrationPanel.add(authorizations.authorizationsPanel);
        //administrationPanel.add(fillerPanel1);
        settings = new Settings();

        fillerPanel1.add(settings.changePasswordPanel);
        fillerPanel1.add(addAdminButton);
        administrationPanel.add(fillerPanel1);
        userInfoPanel.add(fillerPanel2);

    }

    public void createUserInfoPanel() {
        //users.selectedUserUsername.usernameLabel;
    }

    //maakt een scherm waarmee je een nieuwe user kan toeveogen
    public void createNewUserFrame() {

        //maakt frame en zet het juiste panel er in
        frame = new JFrame();
        frame.add(addNewUserPanel);

        //zorgt dat je de layout kan aanpassen met GroupLayout
        GroupLayout layout = new GroupLayout(addNewUserPanel);
        addNewUserPanel.setLayout(layout);

        newUserCode.setText("");
        newUsername.setText("");
        newFirstName.setText("");
        newLastName.setText("");

        //bepaalt de horizontale volgorde van elementen
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                            .addComponent(newUserCodeLabel)
                        .addComponent(newUsernameLabel)
                        .addComponent(newFirstNameLabel)
                        .addComponent(newLastNameLabel))
                    .addGroup(layout.createParallelGroup()
                            .addComponent(newUserCode)
                        .addComponent(newUsername)
                        .addComponent(newFirstName)
                        .addComponent(newLastName)
                        .addComponent(createNewUserButton))
        );

        //bepaalt de verticale volgorde van elementen
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newUserCodeLabel)
                                .addComponent(newUserCode))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(newUsernameLabel)
                        .addComponent(newUsername))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(newFirstNameLabel)
                        .addComponent(newFirstName))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(newLastNameLabel)
                        .addComponent(newLastName))
                    .addComponent(createNewUserButton)
        );

        createNewUserButton.addActionListener(e -> {
            createNewUser(newUserCode.getText() ,newUsername.getText(), newFirstName.getText(), newLastName.getText());
            users.fillList();
            frame.dispose();
        });

        //zorgt dat het er goed uit ziet en maakt het zichtbaar
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(createNewUserButton);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //maakt een scherm waarmee je een nieuwe user kan toeveogen
    public void createNewGroupFrame() {

        //maakt frame en zet het juiste panel er in
        frame = new JFrame();
        frame.add(addNewGroupPanel);

        newGroupName.setText("");

        //zorgt dat je de layout kan aanpassen met GroupLayout
        GroupLayout layout = new GroupLayout(addNewGroupPanel);
        addNewGroupPanel.setLayout(layout);

        //bepaalt de horizontale volgorde van elementen
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newGroupnameLabel))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newGroupName)
                                .addComponent(createNewGroupButton))
        );

        //bepaalt de verticale volgorde van elementen
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newGroupnameLabel)
                                .addComponent(newGroupName))
                        .addComponent(createNewGroupButton)
        );

        createNewGroupButton.addActionListener(e -> {
            createNewGroup(newGroupName.getText());
            groups.fillList();
            frame.dispose();
        });

        //zorgt dat het er goed uit ziet en maakt het zichtbaar
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(createNewGroupButton);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void createNewAdminFrame() {

        //maakt frame en zet het juiste panel er in
        frame = new JFrame();
        frame.add(addNewAdminPanel);

        //zorgt dat je de layout kan aanpassen met GroupLayout
        GroupLayout layout = new GroupLayout(addNewAdminPanel);
        addNewAdminPanel.setLayout(layout);

        newAdminCode.setText("");
        newAdminUsername.setText("");
        newAdminFirstName.setText("");
        newAdminLastName.setText("");

        //bepaalt de horizontale volgorde van elementen
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newAdminCodeLabel)
                                .addComponent(newAdminUsernameLabel)
                                .addComponent(newAdminFirstNameLabel)
                                .addComponent(newAdminLastNameLabel))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newAdminCode)
                                .addComponent(newAdminUsername)
                                .addComponent(newAdminFirstName)
                                .addComponent(newAdminLastName)
                                .addComponent(createNewAdminButton))
        );

        //bepaalt de verticale volgorde van elementen
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newAdminCodeLabel)
                                .addComponent(newAdminCode))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newAdminUsernameLabel)
                                .addComponent(newAdminUsername))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newAdminFirstNameLabel)
                                .addComponent(newAdminFirstName))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(newAdminLastNameLabel)
                                .addComponent(newAdminLastName))
                        .addComponent(createNewAdminButton)
        );

        createNewAdminButton.addActionListener(e -> {
            createNewAdmin(newAdminCode.getText() ,newAdminUsername.getText(), newAdminFirstName.getText(), newAdminLastName.getText());
            //admins.fillList();
            frame.dispose();
        });

        //zorgt dat het er goed uit ziet en maakt het zichtbaar
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(createNewUserButton);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //voegt een nieuwe user toe aan de array van users
    public void createNewUser(String userCode, String username, String firstName, String lastName) {

        if (usingDatabase) {
            try {
                aaa.addUser(userCode, username, "password", null, firstName, lastName);
                usersArrayList.clear();
                aaa.getAllUsers();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            usersArrayList.add(new User(userCode, username, "password", firstName, lastName, false));
        }
    }
    public void deleteUser(String username) {
        for (User user : usersArrayList) {
            if (user.username.equals(username)) {
                if (usingDatabase) {
                    try {
                        aaa.removeUser(user.username);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                usersArrayList.remove(user);
                userInfoPanel.remove(0);
                userInfoPanel.add(fillerPanel2);
                return;
            }
        }
    }

    public void editUser() {
        users.selectedUser.usernameField.setEditable(true);
        users.selectedUser.firstNameField.setEditable(true);
        users.selectedUser.lastNameField.setEditable(true);
        users.selectedUser.officeField.setEditable(true);
        users.selectedUser.telephoneNumberField.setEditable(true);
        users.selectedUser.emailField.setEditable(true);

        users.selectedUser.userInfoPanel.add(GUI.users.confirmEditButton);
        administration.setVisible(true);
    }

    public void createNewGroup(String groupName) {
        groupsArrayList.add(new Group(groupName));
    }
    public void deleteGroup(String groupName) {
        for (Group group : groupsArrayList) {
            if (group.groupName.equals(groupName)) {
                groupsArrayList.remove(group);
                return;
            }
        }
    }
    //voegt een nieuwe user toe aan de array van admins
    public void createNewAdmin(String userCode, String username, String firstName, String lastName) {
        if (usingDatabase) {
            try {
                aaa.addAdmin(userCode, username, "password", null, firstName, lastName);
                admins();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            adminsArrayList.add(new User(userCode, username, "password", firstName, lastName, true));
        }
    }

    public void changeSelectedUser() {
        userInfoPanel.remove(0);
        users.selectedUser.createUserInfoPanel();
        try {
            userInfoPanel.remove(0);
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        userInfoPanel.add(users.selectedUser.userInfoPanel);
        administration.setVisible(true);
    }

    public void giveColors() {

        administrationPanel.setBackground(darkColor);
        administrationLabel.setForeground(lightColor);
        mainview.setBackground(darkColor);
        logOutButton.setBackground(darkColor);
        logOutButton.setForeground(lightColor);
        fillerPanel1.setBackground(darkColor);
        fillerPanel2.setBackground(darkColor);

        addNewUserPanel.setBackground(darkColor);
        newUserCodeLabel.setForeground(lightColor);
        newUserCode.setBackground(darkColor2);
        newUserCode.setForeground(lightColor);
        newUsernameLabel.setForeground(lightColor);
        newUsername.setBackground(darkColor2);
        newUsername.setForeground(lightColor);
        newFirstNameLabel.setForeground(lightColor);
        newFirstName.setBackground(darkColor2);
        newFirstName.setForeground(lightColor);
        newLastNameLabel.setForeground(lightColor);
        newLastName.setBackground(darkColor2);
        newLastName.setForeground(lightColor);
        createNewUserButton.setBackground(lightColor2);
        createNewUserButton.setForeground(darkColor);

        addNewGroupPanel.setBackground(darkColor);
        newGroupnameLabel.setForeground(lightColor);
        newGroupName.setBackground(darkColor2);
        newGroupName.setForeground(lightColor);
        createNewGroupButton.setBackground(lightColor2);
        createNewGroupButton.setForeground(darkColor);

        userInfoPanel.setBackground(darkColor);
        addAdminButton.setBackground(lightColor2);
        addAdminButton.setForeground(darkColor);
        addNewAdminPanel.setBackground(darkColor);
        newAdminCodeLabel.setForeground(lightColor);
        newAdminCode.setBackground(darkColor2);
        newAdminCode.setForeground(lightColor);
        newAdminUsernameLabel.setForeground(lightColor);
        newAdminUsername.setBackground(darkColor2);
        newAdminUsername.setForeground(lightColor);
        newAdminFirstNameLabel.setForeground(lightColor);
        newAdminFirstName.setBackground(darkColor2);
        newAdminFirstName.setForeground(lightColor);
        newAdminLastNameLabel.setForeground(lightColor);
        newAdminLastName.setBackground(darkColor2);
        newAdminLastName.setForeground(lightColor);
        createNewAdminButton.setBackground(lightColor2);
        createNewAdminButton.setForeground(darkColor);
    }
}
