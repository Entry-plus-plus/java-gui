import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class GUI extends JDialog {

    //hier worden variabelen gedeclareerd zodat er naar verwezen kan worden vanuit methods en andere klassen
    //(als je dat in de main pas doet valt het niet in de scope)
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
    static Administration administration;
    static List<User> users = new ArrayList<>();
    static List<User> admins = new ArrayList<>();
    static User currentUser = null;


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

        //Toont het inlogscherm (of een ander scherm, is handig tijdens het programmeren zelf)
        viewInlogscherm();
        //viewDashboard();
        //viewContact();
        //viewSettings();
        //viewAdministration();

        //voegt een aantal users toe waamee ingelogd kan worden
        users.add(new User("user", null, null));
        users.add(new User("Mariska", "Mariska", "van Beek"));
        admins.add(new User("admin", null, null));
    }

    //met de volgende methods kan je de verschillende schermen tonen
    public static void viewInlogscherm() {
        //maakt inlogscherm en maakt het zichtbaar
        inlogscherm = new Inlogscherm();
        inlogscherm.setVisible(true);

        //past aan welke window nu open is, en sluit de vorige af
        if (openedWindow != null) {
            GUI lastOpenedWindow = openedWindow;
            lastOpenedWindow.dispose();
        }
        openedWindow = inlogscherm;
    }

    public static void viewDashboard(){
        dashboard = new Dashboard();
        dashboard.setVisible(true);
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

    public static void viewAdministration(){
        administration = new Administration();
        administration.setVisible(true);
        GUI lastOpenedWindow = openedWindow;
        openedWindow = administration;
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
