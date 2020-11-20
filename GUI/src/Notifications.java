import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Notifications extends GUI{
    private JPanel notificationsPanel;
    int numberOfNotifications = 5;
    public String[] notifications = new String[numberOfNotifications];
    JList<String>  list= new JList<String>(notifications);

    public Notifications() {

        add(notificationsPanel);
        notificationsPanel.add(list);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    public void addNotification(String message) {
        for (int i = numberOfNotifications-1; i>0; i--) {
            notifications[i] = notifications[i-1];
        }
        notifications[0] = message;
    }
}
