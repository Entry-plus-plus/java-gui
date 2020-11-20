import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.ListModel;

public class Notifications extends GUI{
    public JPanel notificationsPanel = new JPanel();
    private JList list1 = new JList();
    //int numberOfNotifications = 5;
    DefaultListModel<String> listModel = new DefaultListModel<String>();
    JList list = new JList(listModel);

    public Notifications() {

        listModel.addElement("NOTIFICATIONS:");
        add(notificationsPanel);
        notificationsPanel.add(list);
        //setContentPane(notificationsPanel);
        setSize(200,200);
        //setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    public void addNotification(String message) {
        listModel.addElement(message);
    }
}
