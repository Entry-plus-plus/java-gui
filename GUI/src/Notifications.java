import javax.swing.*;

public class Notifications extends GUI{

    public JPanel notificationsPanel = new JPanel();

    //maakt een listModel waar de notificaties in komen
    //listModel maakt het makkelijk om notificaties toe te voegen, aan te passen, te verplaatsen en te verwijderen
    DefaultListModel<String> listModel = new DefaultListModel<>();

    //maakt een list die de waarden van listModel aanneemt (ook als listModel veranderd wordt)
    JList list = new JList(listModel);

    public Notifications() {


        //zet bovenaan de lijst NOTIFICATIONS om te laten zien dat het notificaties zijn
        listModel.addElement("NOTIFICATIONS:");
        listModel.addElement("------------------------------------------------------");

        //notificationsPanel.setLayout(new BoxLayout(notificationsPanel, BoxLayout.Y_AXIS));
        //voegt de lijst toe
        notificationsPanel.add(list);
        giveColors();
    }

    //voegt message toe aan de lijst met notificaties
    public void addNotification(String message) {
        listModel.addElement(message);
    }

    //geeft alles de juste kleuren volgens de gekozen kleurencombinatie
    public void giveColors () {
        if (customColors) {
            notificationsPanel.setBackground(darkColor);
            notificationsPanel.setForeground(darkColor);
            notificationsPanel.setOpaque(true);
            list.setBackground(darkColor);
            list.setForeground(lightColor);
        }
    }
}

