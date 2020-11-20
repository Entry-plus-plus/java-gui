import javax.swing.*;
import java.awt.GridLayout;


public class GUI extends JDialog {

    static int numberOfRooms = 5;
    static Inlogscherm inlogscherm;
    static Room[] rooms;
    static Notifications notifications;
    static Dashboard dashboard;

    public static void main(String[] args) {

        inlogscherm = new Inlogscherm();
        rooms = createRooms(numberOfRooms); //maakt een array gevuld met Rooms
        notifications = new Notifications();
        dashboard = new Dashboard();

    }

    public void viewInlogscherm() {
        inlogscherm.setVisible(true);
    }

    public void viewDashboard(){
        Dashboard dashboard = new Dashboard();
    }
    public void viewRooms(){
        Rooms rooms = new Rooms();
        rooms.setVisible(true);
    }

    public static void createNotification(String message) {
        notifications.addNotification(message);
    }

    public static Room[] createRooms(int numberOfRooms) {
        Room[] rooms = new Room[numberOfRooms];
        for (int i = 0; i<numberOfRooms; i++) {
            rooms[i] = new Room();
        }
        return rooms;
    }
}
