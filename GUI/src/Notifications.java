import javax.swing.*;

public class Notifications extends GUI{

    //maakt een panel waar de notificaties in te zien zijn
    public JPanel notificationsPanel = new JPanel();

    //maakt een listModel waar de notificaties in komen
    //listModel maakt het makkelijk om notificaties toe te voegen, aan te passen, te verplaatsen en te verwijderen
    DefaultListModel<String> listModel = new DefaultListModel<>();

    //maakt een list die de waarden van listModel aanneemt (ook als listModel veranderd wordt)
    JList list = new JList(listModel);

    public Notifications() {

        //zet bovenaan de lijst NOTIFICATIONS om te laten zien dat het notificaties zijn
        listModel.addElement("NOTIFICATIONS:");

        //voegt alles toe
        add(notificationsPanel);
        notificationsPanel.add(list);

        //bepaat grootte
        //setSize(200,200);

        //zorgt dat het scherm zich afsluit als je op kruisje drukt
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    //voegt message toe aan de lijst met notificaties
    public void addNotification(String message) {
        listModel.addElement(message);
    }
}
