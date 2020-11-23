import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class topButtons extends GUI {
    JPanel buttonsPanel = new JPanel();
    JButton dashboardButton = new JButton("Dashboard");
    JButton roomsButton = new JButton("Rooms");
    JButton settingsButton = new JButton("Settings");
    JButton dataButton = new JButton("Data");
    JButton contactButton = new JButton("Contact");
    JLabel entryLabel = new JLabel("Entry++");

    public topButtons() {
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(entryLabel);
        buttonsPanel.add(dashboardButton);
        buttonsPanel.add(roomsButton);
        buttonsPanel.add(settingsButton);
        buttonsPanel.add(dataButton);
        buttonsPanel.add(contactButton);

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
    }
}
