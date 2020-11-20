import javax.swing.*;
import java.awt.GridLayout;


public class GUI extends JDialog {

    static int numberOfRooms = 5;
    static Room[] rooms = new Room[numberOfRooms];

    public static void main(String[] args) {


        for (int i = 0; i<numberOfRooms; i++) {
            rooms[i] = new Room();
        }

        Dashboard dashboard = new Dashboard();

        //Inlogscherm inlogscherm = new Inlogscherm();
        //Rooms rooms = new Rooms(10);
        /*Notifications notifications = new Notifications();
        notifications.addNotification("test");

        notifications.addNotification("hello");
        for (int i=0; i<5; i++) {
            System.out.println(notifications.notifications[i]);
        }*/
    }


    public void viewDashboard(){
        Dashboard dashboard = new Dashboard();
    }
    public void viewRooms(){
        Rooms rooms = new Rooms(5);
        rooms.setVisible(true);
    }

    public static void createNotification(String message) {
        //code waarmee message aan het notification scherm toegevoegd wordt
        System.out.println(message); //tijdelijke oplossing
    }
}
