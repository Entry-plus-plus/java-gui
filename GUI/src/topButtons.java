import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//hier word een rij met knoppen gemaakt die bovenaan het scherm komt waarmee je kan navigeren tussen dashboard, rooms, enz
//door de knoppen als een aparte klasse te programmeren is het makkelijker om het boven ieder scherm te zetten

public class topButtons extends GUI {
    JPanel buttonsPanel = new JPanel();
    JButton dashboardButton = new JButton("Dashboard");
    JButton roomsButton = new JButton("Rooms");
    JButton settingsButton = new JButton("Settings");
    JButton dataButton = new JButton("Data");
    JButton contactButton = new JButton("Contact");
    JButton logOutButton = new JButton("Logout");
    JLabel entryLabel = new JLabel("Entry++");

    public topButtons() {
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

        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDashboard();
            }
        });

        roomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewRooms();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSettings();
            }
        });

        dataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewData();
            }
        });

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewContact();
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewInlogscherm();
            }
        });
    }
}
