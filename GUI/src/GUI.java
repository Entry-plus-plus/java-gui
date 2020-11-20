import javax.swing.*;
import java.awt.GridLayout;


public class GUI extends JDialog {

    static int numberOfRooms = 5;
    static Inlogscherm inlogscherm = new Inlogscherm();

    static Room[] rooms;
    static Notifications notifications = new Notifications();

    public static void main(String[] args) {

        rooms = createRooms(5); //maakt een array gevuld met Rooms
        Dashboard dashboard = new Dashboard();

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
