import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends GUI{

    JPanel settingsPanel = new JPanel();
    JLabel settingsLabel = new JLabel("This is the settings Panel");
    JPanel mainview = new JPanel();
    topButtons buttons = new topButtons();

    //maakt alles aan van de panel waarmee je je wachtwoord kan wijzigen
    JPanel changePasswordPanel = new JPanel();
    JLabel currentPasswordLabel = new JLabel("Current Password:");
    JLabel newPasswordLabel = new JLabel("New Password:");
    JLabel confirmPasswordLabel = new JLabel("Confirm new Password");
    JPasswordField currentPassword = new JPasswordField();
    JPasswordField newPassword = new JPasswordField();
    JPasswordField confirmPassword = new JPasswordField();
    JButton changePasswordButton = new JButton("Change Password");
    public static JLabel passwordChangedLabel = new JLabel(" ");

    JPanel changeColorsPanel = new JPanel();
    String[] allColors = {"HHS Colors", "Black and white", "Colorful", "Plain"};
    JList<String> listOfColors= new JList(allColors);
    JButton changeColorsButton = new JButton("Change colors");

    public Settings() {

        buttons.currentButton = buttons.settingsButton;
        giveColors();

        setTitle("Entry++ - Settings");

        createChangePasswordPanel();
        createChangeColorsPanel();

        //settingsPanel.add(settingsLabel);

        //voegt elementen toe aan het scherm
        mainview.add(buttons.buttonsPanel);
        //mainview.add(settingsPanel);
        mainview.add(changePasswordPanel);
        mainview.add(changeColorsPanel);

        //zorgt dat de change passwordknop wordt ingedrukt als je op de enter knop drukt
        getRootPane().setDefaultButton(changePasswordButton);

        //maakt het zichtbaar
        setContentPane(mainview);

        setSizeEtc(this);
    }

    public void createChangePasswordPanel() {
        passwordChangedLabel.setText(" ");

        //zorgt dat je de layout kan bepalen met GroupLayout
        GroupLayout layout = new GroupLayout(changePasswordPanel);
        changePasswordPanel.setLayout(layout);

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
        //zorgt dat de method
        // changePassword uit de klasse user wordt aangeroepen als je op de change password knop drukt
        changePasswordButton.addActionListener(e -> currentUser.changePassword(currentPassword.getText(), newPassword.getText(), confirmPassword.getText()));
    }

    public void createChangeColorsPanel() {
        BoxLayout layout = new BoxLayout(changeColorsPanel, BoxLayout.Y_AXIS);
        changeColorsPanel.setLayout(layout);

        changeColorsPanel.add(listOfColors);
        changeColorsPanel.add(changeColorsButton);

        changeColorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = listOfColors.getSelectedValue();
                if (choice.equals("HHS Colors")) {
                    customColors = true;
                    currentColorPalette = HHSColors;
                }
                else if (choice.equals("Black and white")) {
                    customColors = true;
                    currentColorPalette = blackAndWhite;
                }
                else if (choice.equals("Colorful")) {
                    customColors = true;
                    currentColorPalette = colorful;
                }
                else if (choice.equals("Plain")) {
                    customColors = false;
                }
                setColors();
                giveColors();
            }

        });
    }

    public void giveColors() {
        if (customColors) {
            mainview.setBackground(darkColor);
            changePasswordPanel.setBackground(darkColor);
            currentPasswordLabel.setForeground(lightColor);
            newPasswordLabel.setForeground(lightColor);
            confirmPasswordLabel.setForeground(lightColor);
            currentPassword.setBackground(darkColor2);
            currentPassword.setForeground(lightColor);
            newPassword.setBackground(darkColor2);
            newPassword.setForeground(lightColor);
            confirmPassword.setBackground(darkColor2);
            confirmPassword.setForeground(lightColor);
            changePasswordButton.setBackground(lightColor2);
            changePasswordButton.setForeground(darkColor);
            passwordChangedLabel.setForeground(lightColor);
            changeColorsPanel.setBackground(darkColor);
            changeColorsButton.setBackground(darkColor2);
            changeColorsButton.setForeground(lightColor);
            listOfColors.setBackground(lightColor2);
            listOfColors.setForeground(darkColor);

            buttons.giveColors();
        }
    }
}
