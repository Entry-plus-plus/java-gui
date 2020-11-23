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
    static Settings settings;
    static Data data;
    static Contact contact;

    //dit is een variabele die aangeeft welke window er op dit moment geopend is
    static GUI openedWindow;

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
        viewInlogscherm();
        //viewDashboard();
    }

    //met de volgende methods kan je de verschillende schermen tonen
    public static void viewInlogscherm() {
        inlogscherm = new Inlogscherm();
        inlogscherm.setVisible(true);
        openedWindow = inlogscherm;
    }

    public static void viewDashboard(){
        //maakt dashboard en maakt het zichtbaar
        dashboard = new Dashboard();
        dashboard.setVisible(true);

        //past aan welke window nu open is, en sluit de vorige af
        GUI lastOpenedWindow = openedWindow;
        openedWindow = dashboard;
        lastOpenedWindow.dispose();
    }
    public static void viewRooms(){
        rooms = new Rooms();
        rooms.setVisible(true);
        GUI lastOpenedWindow = openedWindow;
        openedWindow = rooms;
        lastOpenedWindow.dispose();
    }

    public static void viewSettings(){
        settings = new Settings();
        settings.setVisible(true);
        GUI lastOpenedWindow = openedWindow;
        openedWindow = settings;
        lastOpenedWindow.dispose();
    }

    public static void viewData(){
        data = new Data();
        data.setVisible(true);
        GUI lastOpenedWindow = openedWindow;
        openedWindow = data;
        lastOpenedWindow.dispose();
    }

    public static void viewContact(){
        contact = new Contact();
        contact.setVisible(true);
        GUI lastOpenedWindow = openedWindow;
        openedWindow = contact;
        lastOpenedWindow.dispose();
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
}
