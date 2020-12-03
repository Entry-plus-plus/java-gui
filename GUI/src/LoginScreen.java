import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends GUI {

    //onderdelen van het inlogscherm worden gedeclareerd
    //Inlogscherm werkt met een .form
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JPanel Inlogscherm;
    private JButton loginButton;
    private JLabel response;


    public LoginScreen() {
        //geeft het scherm een titel
        setTitle("Entry++ - Login");

        //standaardcode als je zo'n form maakt, weet eigenlijk niet precies wat het doet
        setContentPane(Inlogscherm);

        //grootte van inlogscherm bepalen
        setSize(300,200);
        //setSize(getToolkit().getScreenSize()); //dit zet het fullscreen

        //laat het in het midden van het scherm openen
        setLocationRelativeTo(null);

        //maakt het zichtbaar. is hier weggecomment omdat we hem zichtbaar maken in GUI
        //setVisible(true);

        //zorgt dat het scherm verwijderd wordt als je op kruisje drukt
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //zorgt dat je met de enter knop de login knop kan bedienen
        getRootPane().setDefaultButton(loginButton);

        //hiermee wordt bepaald wat er gebeurt als je op login knop drukt
        //eerste deel is standaardcode, ik weet niet precies wat het doet
        loginButton.addActionListener(e -> {

            //er wordt uitgelezen wat er in de username en password velden is ingevuld
            String username = usernameField.getText();
            String password = passwordField.getText();

            //de login method wordt aangeroepen
            login(username, password);

            //OUDE CODE, eerst ging het zo, nu met de login method
            //als de inloggegevens kloppen wordt het inlogscherm afgesloten en wordt het dashboard getoond
            /*if (usernameField.getText().equals("user") && password.equals("password")) {
                dispose();
                viewDashboard();
            }
            //als er een beheerder inlogt gaat hij naar de beheerderspagina
            else if (usernameField.getText().equals("admin") && password.equals("password")) {
                dispose();
                viewAdministration();
            }
            //als de inloggegevens niet kloppen wordt er een melding gegeven
            else {
                response.setText("Incorrect username or password");
            }*/
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
}

