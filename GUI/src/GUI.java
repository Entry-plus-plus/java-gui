import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GUI extends JDialog {

    static LoginScreen loginScreen;
    static Notifications notifications;
    static Dashboard dashboard;
    static Rooms rooms;
    static Settings settings;
    static Data data;
    static Contact contact;
    static Administration administration;
    static Heatmap heatmap;
    static GUI openedWindow;

    static List<User> users = new ArrayList<>();
    static List<User> admins = new ArrayList<>();
    static User currentUser = null;

    static int numberOfRooms = 7;
    static int numberOfFloors = 2;
    static Room[] roomsArray = new Room[numberOfRooms];
    static Floor[] floorsArray = new Floor[numberOfFloors];
    static Floor floor1;
    static Floor floor2;
    static Floor selectedFloor = floor1;
    static Floors floors;

    static Color darkColor;
    static Color darkColor2;
    static Color lightColor;
    static Color lightColor2;
    static Color HHSGrijs = new Color(34, 51, 67);
    static Color HHSLichterGrijs = new Color(78,91,115);
    static Color HHSGroen = new Color(158,167,0);
    static Color HHSDonkerderGroen = new Color(142, 152, 6 );
    static ColorPalette HHSColors = new ColorPalette(HHSGrijs, HHSLichterGrijs, HHSGroen, HHSDonkerderGroen);
    static ColorPalette blackAndWhite = new ColorPalette(Color.black, Color.DARK_GRAY, Color.white, Color.lightGray);
    static ColorPalette colorful = new ColorPalette(new Color(18,0,120), new Color(157,1,145), new Color(254,205,26), new Color(253,58,105));

    static boolean customColors = true;
    static ColorPalette currentColorPalette = HHSColors;


    public static void main(String[] args) {

        //creeert een aantal elementen die die op het dashboard zullen komen te staan
        heatmap = new Heatmap();
        notifications = new Notifications();

        //zorgt dat de kleuren overeenkomen met de gekozen kleuren
        setColors();


        //maakt twee floors aan, vult floorsArray met de floors en vult roomsArray met de kamers van die floors
        floor1 = new Floor(5);
        floor2 = new Floor(2);
        for (int i = 0; i < floor1.rooms.length; i++) {
            roomsArray[i] = floor1.rooms[i];
        }
        for (int i = 0; i < floor2.rooms.length; i++) {
            roomsArray[i + floor1.rooms.length] = floor2.rooms[i];
        }
        floorsArray[0] = floor1;
        floorsArray[1] = floor2;

        floors = new Floors();

        //de manier om kamers aan te maken zonder een floor:
        //rooms = createRooms(numberOfRooms);



        //voegt een aantal users toe waarmee ingelogd kan worden
        users.add(new User("user", null, null));
        users.add(new User("Mariska", "Mariska", "van Beek"));
        admins.add(new User("admin", null, null));

        //Toont het inlogscherm (of een ander scherm, is handig tijdens het programmeren zelf)
        viewLoginScreen();
        //viewDashboard();
        //viewContact();
        //viewSettings();
        //viewAdministration();
    }


    public static void viewLoginScreen() {
        loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        if (openedWindow != null) {
            GUI lastOpenedWindow = openedWindow;
            lastOpenedWindow.dispose();
        }
        openedWindow = loginScreen;
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

    //bepaalt de grootte van het scherm, dat het in het midden van het scherm opent en dat het zich afsluit als
    //je op kruisje drukt
    public void setSizeEtc(GUI frame) {
        frame.setSize(1200,600);
        //pack();       //past de grootte automatisch aan aan de elementen die er in staan
        //setSize(getToolkit().getScreenSize());        //dit zet het fullscreen

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void setColors() {
        if (customColors) {
            darkColor = currentColorPalette.darkColor;
            darkColor2 = currentColorPalette.darkColor2;
            lightColor = currentColorPalette.lightColor;
            lightColor2 = currentColorPalette.lightColor2;
        }
    }
}
