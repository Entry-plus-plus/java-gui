import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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

    JFrame mustChangePasswordFrame = new JFrame();
    JLabel mustChangePasswordLabel = new JLabel("Please change your password");


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
            try {
                login(username, password);
            } catch (NoSuchPaddingException noSuchPaddingException) {
                noSuchPaddingException.printStackTrace();
            } catch (InvalidKeyException invalidKeyException) {
                invalidKeyException.printStackTrace();
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            } catch (IllegalBlockSizeException illegalBlockSizeException) {
                illegalBlockSizeException.printStackTrace();
            } catch (BadPaddingException badPaddingException) {
                badPaddingException.printStackTrace();
            } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                invalidAlgorithmParameterException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
    }
    public void login(String username, String password) throws Exception {
        //hasht het wachtwoord, is veiliger
        String hashedPassword = passwordHasher.hashPassword(password);
//        String encryptedPassword = aaa.getEncryptedPassword(username);
        System.out.println(aaa.ivParameterSpec);
//        System.out.println(encryptedPassword + " aaaaaaaaaaaaaaaaaa");
//        String decryptedPassword = Encryption.decrypt("AES/CBC/PKCS5Padding", encryptedPassword, aaa.key,aaa.ivParameterSpec);
//        System.out.println(decryptedPassword);
        //itereert door lijst met users
        for (User user : usersArrayList) {

            //kijkt of de meegegeven username voorkomt in de lijst met users
            if (user.username.equals(username)) {

                //kijkt of het meegegeven wachtwoord overeenkomt met het wachtwoord van de gebruiker
                if (user.password.equals(password)) {

                    //kijkt of het account niet disabled is
                    if (!user.accountDisabled) {

                        //sluit het inlogscherm af, opent dashboard en zet currentuser op de user die net heeft ingelogd
                        dispose();
                        viewDashboard();
                        GUI.update();
                        currentUser = user;

                        //als de admin heeft ingesteld dat het wachtwoord veranderd moet worden, komt er een popup
                        /*if (user.mustChangePassword) {
                            mustChangePasswordFrame.add(mustChangePasswordLabel);
                            mustChangePasswordFrame.pack();
                            mustChangePasswordFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            mustChangePasswordFrame.setLocationRelativeTo(null);
                            mustChangePasswordFrame.setVisible(true);
                        }

                        return;*/
                    }
                    else {
                        response.setText("The administrator has disabled your account");
                        return;
                    }
                }
            }
        }
        //werkt vergelijkbaar met vorige stuk code, maar dan in de lijst met admins.
        //Hierbij wordt niet het dashboard geopend maar de administration pagina
        for (int i = 0; i< adminsArrayList.size(); i++) {
            if (adminsArrayList.get(i).username.equals(username)) {
                if (adminsArrayList.get(i).password.equals(password)) {
                    dispose();
                    viewAdministration();
                    currentUser = adminsArrayList.get(i);
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
            mustChangePasswordFrame.setBackground(darkColor);
            mustChangePasswordLabel.setForeground(lightColor);
        }
    }
}

