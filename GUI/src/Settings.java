import javax.swing.*;
import java.awt.*;

public class Settings extends GUI{

    final JPanel settingsPanel = new JPanel();
    JLabel settingsLabel = new JLabel("This is the settings Panel");
    final JPanel mainview = new JPanel();
    final topButtons buttons = new topButtons();

    //maakt alles aan van de panel waarmee je je wachtwoord kan wijzigen
    final JPanel changePasswordPanel = new JPanel();
    final JLabel currentPasswordLabel = new JLabel("Current Password:");
    final JLabel newPasswordLabel = new JLabel("New Password:");
    final JLabel confirmPasswordLabel = new JLabel("Confirm new Password");
    final JPasswordField currentPassword = new JPasswordField();
    final JPasswordField newPassword = new JPasswordField();
    final JPasswordField confirmPassword = new JPasswordField();
    final JButton changePasswordButton = new JButton("Change Password");
    public static final JLabel passwordChangedLabel = new JLabel(" ");

    final JPanel changeColorsPanel = new JPanel();
    final String[] allColors = {"HHS Colors", "Black and white", "Colorful", "Christmas"};
    final JList<String> listOfColors= new JList(allColors);
    final JButton changeColorsButton = new JButton("Change colors");

    JButton updateFromDatabaseButton = new JButton("Update from Database");

    JPanel userInfoPanel = new JPanel();

    public Settings() {

        buttons.currentButton = buttons.settingsButton;
        giveColors();

        setTitle("Entry++ - Settings");

        createChangePasswordPanel();
        createChangeColorsPanel();

        //settingsPanel.add(settingsLabel);

        try {
            createSettingsLayout();
        }
        catch (Exception e) {

        }

        //voegt elementen toe aan het scherm
        /*mainview.add(buttons.buttonsPanel);
        //mainview.add(settingsPanel);
        mainview.add(changePasswordPanel);
        mainview.add(changeColorsPanel);*/

        //zorgt dat de change passwordknop wordt ingedrukt als je op de enter knop drukt
        getRootPane().setDefaultButton(changePasswordButton);

        //maakt het zichtbaar
        setContentPane(settingsPanel);

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

        GroupLayout layout = new GroupLayout(changeColorsPanel);
        changeColorsPanel.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(listOfColors)
                        .addComponent(changeColorsButton)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(listOfColors)
                        .addComponent(changeColorsButton)
        );

        /*BoxLayout layout = new BoxLayout(changeColorsPanel, BoxLayout.Y_AXIS);
        changeColorsPanel.setLayout(layout);

        listOfColors.setAlignmentX(CENTER_ALIGNMENT);
        changePasswordButton.setAlignmentX(CENTER_ALIGNMENT);
        changeColorsPanel.add(listOfColors);
        changeColorsPanel.add(changeColorsButton);*/

        changeColorsButton.addActionListener(e -> {
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
            else if (choice.equals("Christmas")) {
                customColors = true;
                currentColorPalette = christmas;
            }
            setColors();
            giveColors();
        });
    }

    public void createSettingsLayout() {
        GridBagLayout settingsLayout = new GridBagLayout();
        settingsPanel.setLayout(settingsLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 6;
        gbc.insets = new Insets(10,150,10,10);
        settingsPanel.add(buttons.buttonsPanel, gbc);

        gbc.insets = new Insets(0,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        settingsPanel.add(currentUser.generalPanel, gbc);
        currentUser.giveColors();

        //gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        settingsPanel.add(changePasswordPanel, gbc);

        //gbc.insets = new Insets(0,0,0,50);
        gbc.gridx = 4;
        settingsPanel.add(changeColorsPanel, gbc);

        gbc.gridx = 6;
        settingsPanel.add(updateFromDatabaseButton, gbc);

        updateFromDatabaseButton.addActionListener(e -> {
            admins();
        });
    }

    public void giveColors() {
        if (customColors) {
            mainview.setBackground(darkColor);
            settingsPanel.setBackground(darkColor);

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
            changeColorsButton.setBackground(lightColor2);
            changeColorsButton.setForeground(darkColor);
            listOfColors.setBackground(darkColor2);
            listOfColors.setForeground(lightColor);

            updateFromDatabaseButton.setBackground(lightColor2);
            updateFromDatabaseButton.setForeground(darkColor);

            try {
                currentUser.giveColors();
            }
            catch (Exception e) {

            }

            buttons.giveColors();
        }
    }
}
