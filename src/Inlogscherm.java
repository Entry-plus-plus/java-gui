import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inlogscherm extends GUI{

    private JButton loginButton;
    private JPanel InlogschermPanel;
    private JTextArea Username;
    private JLabel WrongUserText;

    public Inlogscherm() {

        setContentPane(InlogschermPanel);
        setSize(300,200);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() { //dit is wat er gebeurt als je op de login knop drukt
            public void actionPerformed(ActionEvent e) {
                Login();
            }
        });
    }
    public void Login() {
        if (Username.getText().equals("user")) {
            dispose(); //Inlogscherm wordt afgesloten
            LoggedIn(); //method uit GUI, start Rooms op
        }
        else {
            WrongUserText.setText("Wrong username");
        }
    }
}
