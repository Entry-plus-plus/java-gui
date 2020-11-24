import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends GUI{

    JPanel settingsPanel = new JPanel();
    JLabel settingsLabel = new JLabel("This is the settings Panel");
    JPanel mainview = new JPanel();
    topButtons buttons = new topButtons();

    //maakt alles aan van de panel waarmee je je wachtwoord kan wijzigen
    JPanel changePassword = new JPanel();
    JLabel currentPasswordLabel = new JLabel("Current Password:");
    JLabel newPasswordLabel = new JLabel("New Password:");
    JLabel confirmPasswordLabel = new JLabel("Confirm new Password");
    JPasswordField currentPassword = new JPasswordField();
    JPasswordField newPassword = new JPasswordField();
    JPasswordField confirmPassword = new JPasswordField();
    JButton changePasswordButton = new JButton("Change Password");
    public static JLabel passwordChangedLabel = new JLabel(" ");

    public Settings() {
        setTitle("Entry++ - Settings");

        passwordChangedLabel.setText(" ");

        //zorgt dat je de layout kan bepalen met GroupLayout
        GroupLayout layout = new GroupLayout(changePassword);
        changePassword.setLayout(layout);

        //geeft de horizontale volgorde van elementen
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(currentPasswordLabel)
                        .addComponent(currentPassword)
                        .addComponent(newPasswordLabel)
                        .addComponent(newPassword)
                        .addComponent(confirmPasswordLabel)
                        .addComponent(confirmPassword)
                        .addComponent(changePasswordButton)
                        .addComponent(passwordChangedLabel)
        );

        //geeft de verticale volgorde van elementen
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(currentPasswordLabel)
                        .addComponent(currentPassword)
                        .addComponent(newPasswordLabel)
                        .addComponent(newPassword)
                        .addComponent(confirmPasswordLabel)
                        .addComponent(confirmPassword)
                        .addComponent(changePasswordButton)
                        .addComponent(passwordChangedLabel)
        );

        //zorgt dat de method changePassword uit de klasse user wordt aangeroepen als je op de change password knop drukt
        changePasswordButton.addActionListener(e -> currentUser.changePassword(currentPassword.getText(), newPassword.getText(), confirmPassword.getText()));

        //settingsPanel.add(settingsLabel);

        //voegt elementen toe aan het scherm
        mainview.add(buttons.buttonsPanel);
        //mainview.add(settingsPanel);
        mainview.add(changePassword);

        //zorgt dat de change passwordknop wordt ingedrukt als je op de enter knop drukt
        getRootPane().setDefaultButton(changePasswordButton);

        //maakt het zichtbaar
        setContentPane(mainview);

        //bepaalt grootte
        setSize(1200,600);

        //zorgt dat het in het midden van het scherm opent
        setLocationRelativeTo(null);

        //zorgt dat het scherm zich afsluit als je op het kruisje drukt
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
