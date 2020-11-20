import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inlogscherm extends GUI {
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JPanel Inlogscherm;
    private JButton loginButton;
    private JLabel response;


    public Inlogscherm() {
        setContentPane(Inlogscherm);
        //setSize(300,200);
        setSize(getToolkit().getScreenSize()); //dit zet het fullscreen
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                if (usernameField.getText().equals("user") && password.equals("password")) {
                    dispose();
                    viewDashboard();
                }
                else {
                    response.setText("Go away");
                }
            }
        });
    }
}

