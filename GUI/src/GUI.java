import javax.swing.*;
import java.awt.GridLayout;


public class GUI extends JDialog {

    //hier worden variabelen gedeclareerd zodat er naar verwezen kan worden vanuit methods en andere klassen
    //(als je dat in de main pas valt het niet in de scope)
    static int numberOfRooms = 7; //deze waarde is willekeurig gekozen, mag aangepast worden
    static Inlogscherm inlogscherm;
    static Room[] roomsArray;
    static Notifications notifications;
    static Dashboard dashboard;
    static Floor floor1;
    static Rooms rooms;

    //static topButtons buttonsPanel = new topButtons();

    public static void main(String[] args) {

        //maakt een verdieping aan en stopt alle kamers van die verdieping in de array roomsArray
        floor1 = new Floor(numberOfRooms);
        roomsArray = floor1.rooms;
        //de manier om kamers aan te maken zonder een floor:
        //rooms = createRooms(numberOfRooms);

        //notifications wordt geinitialiseerd zodat het gebruikt kan worden in dashboard
        notifications = new Notifications();

        //Toont het inlogscherm
        //viewInlogscherm();
        viewDashboard();
    }

    //met de volgende methods kan je de verschillende schermen tonen
    public static void viewInlogscherm() {
        inlogscherm = new Inlogscherm();
        inlogscherm.setVisible(true);
    }

    public static void viewDashboard(){
        dashboard = new Dashboard();
        dashboard.setVisible(true);
        rooms.dispose();
    }
    public static void viewRooms(){
        rooms = new Rooms();
        rooms.setVisible(true);
        dashboard.dispose();
    }

    //met deze functie kan een notificatie aangemaakt worden om in het notifications panel gezet te worden
    //het echte aanmaken gebeurt in de class notifications
    //deze tussenstap hier was nodig omdat je niet zomaar vanuit bijv. rooms naar notifications kan verwijzen
    //(nouja misschien kan het wel maar mij lukt het niet :P)
    public static void createNotification(String message) {
        notifications.addNotification(message);
    }

    //maakt een aantal kamers en geeft ze terug in de vorm van een array
    public static Room[] createRooms(int numberOfRooms) {
        roomsArray = new Room[numberOfRooms];
        for (int i = 0; i<numberOfRooms; i++) {
            roomsArray[i] = new Room();
        }
        return roomsArray;
    }

    public static JPanel createButtonsPanel(){
        JPanel buttonsPanel = new JPanel();
        JButton dashboardButton = new JButton("Dashboard");
        JButton roomsButton = new JButton("Rooms");
        JButton settingsButton = new JButton("Settings");
        JButton dataButton = new JButton("Data");
        JButton contactButton = new JButton("Contact");
        JLabel entryLabel = new JLabel("Entry++");

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(entryLabel);
        buttonsPanel.add(dashboardButton);
        buttonsPanel.add(roomsButton);
        buttonsPanel.add(settingsButton);
        buttonsPanel.add(dataButton);
        buttonsPanel.add(contactButton);

        return buttonsPanel;
    }
}
