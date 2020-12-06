import javax.swing.*;

public class LoginScreen extends GUI {

    //onderdelen van het inlogscherm worden gedeclareerd
    //Inlogscherm werkt met een .form
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JPanel Inlogscherm;
    private JButton loginButton;
    private JLabel response;
    private JLabel usernameLabel;
    private JLabel passwordLabel;


    public LoginScreen() {
        setTitle("Entry++ - Login");
        setContentPane(Inlogscherm);

        setSize(300,200); //bepaalt de grootte
        setLocationRelativeTo(null); //laat het in het midden van het scherm openen
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //zorgt dat het scherm verwijderd wordt als je op kruisje drukt
        getRootPane().setDefaultButton(loginButton);//zorgt dat je met de enter knop de login knop kan bedienen

        giveColors();


        //hiermee wordt bepaald wat er gebeurt als je op login knop drukt
        //eerste deel is standaardcode, ik weet niet precies wat het doet
        loginButton.addActionListener(e -> {

            //er wordt uitgelezen wat er in de username en password velden is ingevuld
            String username = usernameField.getText();
            String password = passwordField.getText();

            //de login method wordt aangeroepen
            login(username, password);

        });
    }
    public void login(String username, String password) {
        //hasht het wachtwoord, is veiliger
        String hashedPassword = passwordHasher.hashPassword(password);

        //itereert door lijst met users
        for (User user : users) {

            //kijkt of de meegegeven username voorkomt in de lijst met users
            if (user.username.equals(username)) {

                //kijkt of het meegegeven wachtwoord overeenkomt met het wachtwoord van de gebruiker
                if (user.password.equals(hashedPassword)) {

                    //sluit het inlogscherm af, opent dashboard en zet currentuser op de user die net heeft ingelogd
                    dispose();
                    viewDashboard();
                    currentUser = user;
                    return;
                }
            }
        }
        //werkt vergelijkbaar met vorige stuk code, maar dan in de lijst met admins.
        //Hierbij wordt niet het dashboard geopend maar de administration pagina
        for (int i=0; i<admins.size(); i++) {
            if (admins.get(i).username.equals(username)) {
                if (admins.get(i).password.equals(hashedPassword)) {
                    dispose();
                    viewAdministration();
                    currentUser = users.get(i);
                    return;
                }
            }
        }
        //als de inloggegevens niet kloppen wordt er een bericht getoond
        response.setText("Login failed");
    }

    public void giveColors() {
        if (customColors) {
            Inlogscherm.setBackground(darkColor);
            usernameLabel.setForeground(lightColor);
            passwordLabel.setForeground(lightColor);
            loginButton.setBackground(lightColor);
            loginButton.setForeground(darkColor);
            response.setForeground(lightColor);
            usernameField.setBackground(darkColor2);
            usernameField.setForeground(lightColor);
            passwordField.setBackground(darkColor2);
            passwordField.setForeground(lightColor);
        }
    }
}

