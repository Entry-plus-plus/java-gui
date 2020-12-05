import javax.swing.*;

public class Administration extends GUI{

    //maakt de elementen van het administration scherm
    final JPanel administrationPanel = new JPanel();
    final JLabel administrationLabel = new JLabel("This is where the administrator can do administrator things");
    final JPanel mainview = new JPanel();
    final JButton logOutButton = new JButton("log out");
    final JButton addNewUserButton = new JButton("Add new User");

    //maakt de elementen van het create new user scherm
    JFrame frame;
    final JPanel addNewUserPanel = new JPanel();
    final JLabel newUsernameLabel = new JLabel("Username of new user:");
    final JTextField newUsername = new JTextField();
    final JLabel newFirstNameLabel = new JLabel("First name of new user:");
    final JTextField newFirstName = new JTextField();
    final JLabel newLastNameLabel = new JLabel("Last name of new user:");
    final JTextField newLastName = new JTextField();
    final JButton createButton = new JButton("create");


    public Administration() {
        setTitle("Entry++ - Administration");

        //voegt de elementen toe aan het scherm
        administrationPanel.add(administrationLabel);
        mainview.add(administrationPanel);
        mainview.add(logOutButton);
        mainview.add(addNewUserButton);

        //maakt het zichtbaar
        setContentPane(mainview);

        setSizeEtc(this);

        //zorgt dat je uitlogt als de op de logout knop drukt
        logOutButton.addActionListener(e -> {
            dispose();
            viewLoginScreen();
        });

        //zorgt dat het add new user scherm wordt geopend als je op de addNewUser knop drukt
        addNewUserButton.addActionListener(e -> {
            //method waarmee nieuw scherm wordt geopend als popup
            newUserFrame();
        });

        //maakt een nieuwe user aan als je op de create knop drukt
        createButton.addActionListener(e -> {
            createNewUser(newUsername.getText(), newFirstName.getText(), newLastName.getText());
            frame.dispose();
        });
    }

    //maakt een scherm waarmee je een nieuwe user kan toeveogen
    public void newUserFrame() {

        //maakt frame en zet het juiste panel er in
        frame = new JFrame();
        frame.add(addNewUserPanel);

        //zorgt dat je de layout kan aanpassen met GroupLayout
        GroupLayout layout = new GroupLayout(addNewUserPanel);
        addNewUserPanel.setLayout(layout);

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
                        .addComponent(createButton))
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
                    .addComponent(createButton)
        );

        //zorgt dat het er goed uit ziet en maakt het zichtbaar
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(createButton);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //voegt een nieuwe user toe aan de array van users
    public void createNewUser(String username, String firstName, String lastName) {
        users.add(new User(username, firstName, lastName));
    }
    public void removeUser(String username) {

    }
    //voegt een nieuwe user toe aan de array van admins
    public void createNewAdmin(String username, String firstName, String lastName) {
        admins.add(new User(username, firstName, lastName));
    }
    public void removeAdmin(String username) {

    }
}
