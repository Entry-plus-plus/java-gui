import javax.swing.*;

public class Administration extends GUI{

    //maakt de elementen van het administration scherm
    final JPanel administrationPanel = new JPanel();
    final JLabel administrationLabel = new JLabel("This is where the administrator can do administrator things");
    final JPanel mainview = new JPanel();
    final JButton logOutButton = new JButton("log out");

    //maakt de elementen van het create new user scherm
    JFrame frame;
    final JPanel addNewUserPanel = new JPanel();
    final JLabel newUsernameLabel = new JLabel("Username of new user:");
    JTextField newUsername = new JTextField();
    final JLabel newFirstNameLabel = new JLabel("First name of new user:");
    JTextField newFirstName = new JTextField();
    final JLabel newLastNameLabel = new JLabel("Last name of new user:");
    JTextField newLastName = new JTextField();
    final JButton createNewUserButton = new JButton("create");

    //maakt de elementen van het create new group scherm
    final JPanel addNewGroupPanel = new JPanel();
    final JLabel newGroupnameLabel = new JLabel("Username of new user:");
    final JTextField newGroupName = new JTextField();
    final JButton createNewGroupButton = new JButton("create");

    Group selectedGroup;

    public Administration() {
        setTitle("Entry++ - Administration");

        //voegt de elementen toe aan het scherm
        administrationPanel.add(administrationLabel);
        mainview.add(administrationPanel);
        mainview.add(logOutButton);

        users = new Users();
        mainview.add(users.usersPanel);

        groups = new Groups();
        mainview.add(groups.groupsPanel);

        authorizations = new Authorizations();
        mainview.add(authorizations.authorizationsPanel);

        //maakt het zichtbaar
        setContentPane(mainview);

        setSizeEtc(this);

        //zorgt dat je uitlogt als de op de logout knop drukt
        logOutButton.addActionListener(e -> {
            dispose();
            viewLoginScreen();
        });

        //maakt een nieuwe user aan als je op de create knop drukt

        giveColors();
    }

    //maakt een scherm waarmee je een nieuwe user kan toeveogen
    public void createNewUserFrame() {

        //maakt frame en zet het juiste panel er in
        frame = new JFrame();
        frame.add(addNewUserPanel);

        //zorgt dat je de layout kan aanpassen met GroupLayout
        GroupLayout layout = new GroupLayout(addNewUserPanel);
        addNewUserPanel.setLayout(layout);

        newUsername.setText("");
        newFirstName.setText("");
        newLastName.setText("");

        //bepaalt de horizontale volgorde van elementen
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(newUsernameLabel)
                        .addComponent(newFirstNameLabel)
                        .addComponent(newLastNameLabel))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(newUsername)
                        .addComponent(newFirstName)
                        .addComponent(newLastName)
                        .addComponent(createNewUserButton))
        );

        //bepaalt de verticale volgorde van elementen
        layout.setVerticalGroup(
                layout.createSequentialGroup()
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
            createNewUser(newUsername.getText(), newFirstName.getText(), newLastName.getText());
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

    //voegt een nieuwe user toe aan de array van users
    public void createNewUser(String username, String firstName, String lastName) {
        usersArrayList.add(new User(username, firstName, lastName));
    }
    public void deleteUser(String username) {
        for (User user : usersArrayList) {
            if (user.username.equals(username)) {
                usersArrayList.remove(user);
                return;
            }
        }
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
    public void createNewAdmin(String username, String firstName, String lastName) {
        adminsArrayList.add(new User(username, firstName, lastName));
    }

    public void giveColors() {

        administrationPanel.setBackground(darkColor);
        administrationLabel.setForeground(lightColor);
        mainview.setBackground(darkColor);
        logOutButton.setBackground(darkColor);
        logOutButton.setForeground(lightColor);

        addNewUserPanel.setBackground(darkColor);
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
    }
}
