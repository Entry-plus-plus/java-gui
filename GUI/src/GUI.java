import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class GUI extends JDialog {

    static int numberOfRooms = 7; //deze waarde is willekeurig gekozen, mag aangepast worden
    static int numberOfFloors = 2;
    static LoginScreen inlogscherm;
    static Room[] roomsArray = new Room[numberOfRooms];
    static Floor[] floorsArray;
    static Notifications notifications;
    static Dashboard dashboard;
    static Floor floor1;
    static Floor floor2;
    static Rooms rooms;
    static Settings settings;
    static Data data;
    static Contact contact;
    static Administration administration;
    static List<User> users = new ArrayList<>();
    static List<User> admins = new ArrayList<>();
    static User currentUser = null;
    static GUI openedWindow;
    static Heatmap heatmap = new Heatmap();
    static Floors floors;
    static Floor selectedFloor = floor1;

    //static topButtons buttonsPanel = new topButtons();

    public static void main(String[] args) {

        floor1 = new Floor(5);
        floor2 = new Floor(2);
        for (int i = 0; i < floor1.rooms.length; i++) {
            roomsArray[i] = floor1.rooms[i];
        }
        for (int i = 0; i < floor2.rooms.length; i++) {
            roomsArray[i + floor1.rooms.length] = floor2.rooms[i];
        }
        floorsArray = new Floor[numberOfFloors];
        floorsArray[0] = floor1;
        floorsArray[1] = floor2;
        floors = new Floors();
        //de manier om kamers aan te maken zonder een floor:
        //rooms = createRooms(numberOfRooms);

        notifications = new Notifications();
        heatmap = new Heatmap();

        //Toont het inlogscherm (of een ander scherm, is handig tijdens het programmeren zelf)
        viewLoginScreen();
        //viewDashboard();
        //viewContact();
        //viewSettings();
        //viewAdministration();

        /*JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        heatmap.doTheThing(panel);
        frame.add(panel);
        frame.pack();
        //frame.setSize(1200,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setVisible(true);*/




        //voegt een aantal users toe waamee ingelogd kan worden
        users.add(new User("user", null, null));
        users.add(new User("Mariska", "Mariska", "van Beek"));
        admins.add(new User("admin", null, null));
    }

    //met de volgende methods kunnen de verschillende schermen geopend worden
    public static void viewLoginScreen() {
        inlogscherm = new LoginScreen();
        inlogscherm.setVisible(true);
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
