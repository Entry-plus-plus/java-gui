import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inlogscherm extends GUI {

    //onderdelen van het inlogscherm worden gedeclareerd
    //Inlogscherm werkt met een .form
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JPanel Inlogscherm;
    private JButton loginButton;
    private JLabel response;


    public Inlogscherm() {

        //standaardcode als je zo'n form maakt, weet eigenlijk niet precies wat het doet
        setContentPane(Inlogscherm);

        //grootte van inlogscherm bepalen
        setSize(300,200);
        //setSize(getToolkit().getScreenSize()); //dit zet het fullscreen

        //setLocationRelativeTo(null);

        //maakt het zichtbaar. is hier weggecomment omdat we hem zichtbaar maken in GUI
        //setVisible(true);

        //zorgt dat het scherm verwijderd wordt als je op kruisje drukt
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //zorgt dat je met de enter knop de login knop kan bedienen
        getRootPane().setDefaultButton(loginButton);

        //hiermee wordt bepaald wat er gebeurt als je op login knop drukt
        //eerste deel is standaardcode, ik weet niet precies wat het doet
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //er wordt uitgelezen wat er in de username en password velden is ingevuld
                String username = usernameField.getText();
                String password = passwordField.getText();

                //als de inloggegevens kloppen wordt het inlogscherm afgesloten en wordt het dashboard getoond
                if (usernameField.getText().equals("user") && password.equals("password")) {
                    dispose();
                    viewDashboard();
                }
                //als ze niet kloppen wordt er een melding gegeven
                else {
                    response.setText("Go away");
                }
            }
        });
    }
}

