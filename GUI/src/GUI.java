import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class GUI extends JDialog {

    static int numberOfRooms = 7; //deze waarde is willekeurig gekozen, mag aangepast worden
    static LoginScreen inlogscherm;
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
    static GUI openedWindow;
    static Heatmap heatmap = new Heatmap();

    //static topButtons buttonsPanel = new topButtons();

    public static void main(String[] args) {



        //maakt een verdieping aan en stopt alle kamers van die verdieping in de array roomsArray
        floor1 = new Floor(numberOfRooms);
        roomsArray = floor1.rooms;
        //de manier om kamers aan te maken zonder een floor:
        //rooms = createRooms(numberOfRooms);

        notifications = new Notifications();
        heatmap = new Heatmap();

        //Toont het inlogscherm (of een ander scherm, is handig tijdens het programmeren zelf)
        viewInlogscherm();
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
    public static void viewInlogscherm() {
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
