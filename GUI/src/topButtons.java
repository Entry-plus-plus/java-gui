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
}
