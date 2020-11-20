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

        add(notificationsPanel);
        notificationsPanel.add(list);
        //setContentPane(notificationsPanel);
        setSize(200,200);
        //setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    public void addNotification(String message) {
        listModel.addElement(message);
        /*for (int i = numberOfNotifications-1; i>0; i--) {
            notifications[i] = notifications[i-1];
        }
        notifications[0] = message;*/
    }
}
