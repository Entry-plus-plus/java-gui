import javax.swing.*;

//hier word een rij met knoppen gemaakt die bovenaan het scherm komt waarmee je kan navigeren tussen dashboard, rooms, enz
//door de knoppen als een aparte klasse te programmeren is het makkelijker om het boven ieder scherm te zetten

public class topButtons extends GUI {

    //Alle noppen worden gedeclareerd en geinitieerd
    JPanel buttonsPanel = new JPanel();
    JButton dashboardButton = new JButton("Dashboard");
    JButton roomsButton = new JButton("Rooms");
    JButton settingsButton = new JButton("Settings");
    JButton dataButton = new JButton("Data");
    JButton contactButton = new JButton("Contact");
    JButton logOutButton = new JButton("Logout");
    JLabel entryLabel = new JLabel("Entry++");
    JButton currentButton = dashboardButton;

    public topButtons() {

        //voegt alle knoppen toe aan de panel
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        //buttonsPanel.add(entryLabel);
        buttonsPanel.add(dashboardButton);
        buttonsPanel.add(roomsButton);
        buttonsPanel.add(settingsButton);
        buttonsPanel.add(dataButton);
        buttonsPanel.add(contactButton);
        buttonsPanel.add(new JLabel("                    "));
        buttonsPanel.add(logOutButton);

        giveColors();

        //onderstaande methods zorgen dat de knoppen naar de juiste window gaan

        dashboardButton.addActionListener(e -> viewDashboard());

        roomsButton.addActionListener(e -> viewRooms());

        settingsButton.addActionListener(e -> viewSettings());

        dataButton.addActionListener(e -> viewData());

        contactButton.addActionListener(e -> viewContact());

        //met deze knop kan je uitloggen
        logOutButton.addActionListener(e -> {
            currentUser = null;
            viewLoginScreen();
        });
    }

    public void giveColors() {
        if (customColors) {
            buttonsPanel.setBackground(darkColor);

            dashboardButton.setBackground(darkColor);
            roomsButton.setBackground(darkColor);
            settingsButton.setBackground(darkColor);
            dataButton.setBackground(darkColor);
            contactButton.setBackground(darkColor);
            logOutButton.setBackground(darkColor);

            currentButton.setBackground(lightColor);

            dashboardButton.setForeground(lightColor);
            roomsButton.setForeground(lightColor);
            settingsButton.setForeground(lightColor);
            dataButton.setForeground(lightColor);
            contactButton.setForeground(lightColor);
            logOutButton.setForeground(lightColor);

            currentButton.setForeground(darkColor);
        }
    }
}
