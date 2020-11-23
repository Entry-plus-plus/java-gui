import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.ListModel;

public class Notifications extends GUI{

    //maakt een panel waar de notificaties in te zien zijn
    public JPanel notificationsPanel = new JPanel();

    //maakt een listModel waar de notificaties in komen
    //listModel maakt het makkelijk om notificaties toe te voegen, aan te passen, te verplaatsen en te verwijderen
    DefaultListModel<String> listModel = new DefaultListModel<String>();

    //een list die de waarden van listModel aanneemt (ook als listModel veranderd wordt)
    private JList list1 = new JList();
    JList list = new JList(listModel);

    public Notifications() {

        listModel.addElement("NOTIFICATIONS:");
        add(notificationsPanel);
        notificationsPanel.add(list);
        //setSize(200,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    //voegt message toe aan de lijst met notificaties
    public void addNotification(String message) {
        listModel.addElement(message);
    }
}
