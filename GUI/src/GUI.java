import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GUI extends JDialog {

    static Boolean usingDatabase = true;

    static DBConnections aaa = new DBConnections();

    public static void admins(){
        try {
            aaa.getAllAdmins();
            //aaa.writeResultSet(aaa.beheerders);
            //String beheerderlijst = aaa.beheerders.getString("Username");
            aaa.getUser("gebr1");
            System.out.println(aaa.getAllAdmins());
            System.out.println(aaa.username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //alle verschillende schermen declareren
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
    static Users users;
    static Groups groups;
    static Authorizations authorizations;

    //lijsten maken waar gebruikers en admins in gezet kunnen worden
    static List<User> usersArrayList = new ArrayList<>();
    static List<User> adminsArrayList = new ArrayList<>();
    static User currentUser = null;
    static List<Group> groupsArrayList = new ArrayList<>();

    //kamers en verdiepingen declareren
    static final int numberOfRooms = 7;
    static final int numberOfFloors = 2;
    static final Room[] roomsArray = new Room[numberOfRooms];
    static final Floor[] floorsArray = new Floor[numberOfFloors];
    static Floor floor1;
    static Floor floor2;
    static Floor selectedFloor;
    static Floors floors;

    //verschillende kleuren aanmaken die gebruikt worden in het uiterlijk van de app
    static Color darkColor;
    static Color darkColor2;
    static Color lightColor;
    static Color lightColor2;
    static final Color HHSGrijs = new Color(34, 51, 67);
    static final Color HHSLichterGrijs = new Color(78,91,115);
    static final Color HHSGroen = new Color(158,167,0);
    static final Color HHSDonkerderGroen = new Color(142, 152, 6 );
    static final ColorPalette HHSColors = new ColorPalette(HHSGrijs, HHSLichterGrijs, HHSGroen, HHSDonkerderGroen);
    static final ColorPalette blackAndWhite = new ColorPalette(Color.black, Color.DARK_GRAY, Color.white, Color.lightGray);
    static final ColorPalette colorful = new ColorPalette(new Color(18,0,120), new Color(157,1,145), new Color(254,205,26), new Color(253,58,105));
    static final ColorPalette christmas = new ColorPalette(new Color(22,91,51), new Color(20,107,58), new Color(234,70,48), new Color(187,37,40));

    static boolean customColors = true;                     //bij false worden de default kleuren laten zien
    static ColorPalette currentColorPalette = HHSColors;    //keuze voor het kleurenschema waar het mee opstart


    static JFrame frame = new JFrame();

    public static void main(String[] args) {


        setColors();                //zorgt dat de kleuren overeenkomen met de gekozen Colorpalette
        if (usingDatabase) {

        }
        else {
            createRoomsAndFloors();
        }
        //rooms = createRooms(numberOfRooms);       //= de manier om kamers aan te maken zonder een floor

        //initialiseert een aantal onderdelen zodat ze op het dashboard getoond kunnen worden
        heatmap = new Heatmap();
        floors = new Floors();
        notifications = new Notifications();
        //settings = new Settings();

        //voegt een aantal users toe waarmee ingelogd kan worden
        if (usingDatabase) {
            admins();
            usersArrayList.add(new User(" ", "user", "password", " ", " "));
        }
        else {
            createUsersandAdmins();
        }

        for (User admin : adminsArrayList) {
            System.out.println("admin is called " + admin.username);
        }

        //users = new Users();

        //Toont het inlogscherm (of een ander scherm, is handig tijdens het programmeren zelf)
        viewLoginScreen();
        //viewDashboard();
        //viewContact();
        //viewSettings();
        //viewAdministration();
        //viewData();

        //Graph graph = new Graph();
        //graph.run();
    }


    // met deze methods kunnen de verschillende schermen geopend worden
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

        //Verbetermogelijkheid, nog verder aan werken
        //frame.add(dashboard.dashboardPanel);
        //frame.setVisible(true);

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

// --Commented out by Inspection START (6-12-2020 17:28):
//    //maakt een aantal kamers en geeft ze terug in de vorm van een array
//    public static Room[] createRooms(int numberOfRooms) {
//        roomsArray = new Room[numberOfRooms];
//        for (int i = 0; i<numberOfRooms; i++) {
//            roomsArray[i] = new Room();
//        }
//        return roomsArray;
//    }
// --Commented out by Inspection STOP (6-12-2020 17:28)

    //bepaalt de grootte van het scherm, dat het in het midden van het scherm opent en dat het zich afsluit als je op kruisje drukt
    public void setSizeEtc(GUI frame) {
        frame.setSize(1200,600);
        //pack();                                       //past de grootte automatisch aan aan de elementen die er in staan
        //setSize(getToolkit().getScreenSize());        //dit zet het fullscreen

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //zorgt dat de kleuren overeenkomen met de gekozen ColorPalette
    public static void setColors() {
        if (customColors) {
            darkColor = currentColorPalette.darkColor;
            darkColor2 = currentColorPalette.darkColor2;
            lightColor = currentColorPalette.lightColor;
            lightColor2 = currentColorPalette.lightColor2;
        }
    }

    //maakt twee floors aan, vult floorsArray met de floors en vult roomsArray met de kamers van die floors
    public static void createRoomsAndFloors() {
        floor1 = new Floor(5);
        selectedFloor = floor1;
        floor2 = new Floor(2);
        for (int i = 0; i < floor1.rooms.length; i++) {
            roomsArray[i] = floor1.rooms[i];
        }
        for (int i = 0; i < floor2.rooms.length; i++) {
            roomsArray[i + floor1.rooms.length] = floor2.rooms[i];
        }
        floorsArray[0] = floor1;
        floorsArray[1] = floor2;
    }

    //Bepaalt de kleur tussen groen en rood die overeenkomt met het percentage
    //0% is groen(0,255,0), 50% is oranje(255,255,0) en 100% is rood(255,0,0)
    //bij de andere percentages zit het er tussenin
    public static Color convertPercentageToColor (int percentage) {
        int red;
        int green;
        int blue = 0;

        if (percentage < 50) {
            red = (int) 5.1 * percentage;
            green = 255;
        }
        else if (percentage < 100) {
            red = 255;
            green = (int) (255 - (percentage - 50) * 5.1);
        }
        else {
            red = 255;
            green = 0;
        }

        return new Color(red, green, blue);
    }

    public static void createUsersandAdmins() {
        usersArrayList.add(new User("user1", "user", "password", null, null));
        usersArrayList.add(new User("user2", "Ebenezer", "password","Ebenezer", "Appau"));
        usersArrayList.add(new User("user3", "Mariska","password", "Mariska", "van Beek"));
        usersArrayList.add(new User("user4", "Tom", "password","Tom", "Daamen"));
        usersArrayList.add(new User("user5", "Davita", "password","Davita", "de Jong"));
        usersArrayList.add(new User("user6", "Bart", "password","Bart", "Leentvaar"));
        usersArrayList.add(new User("user7", "Shaquille", "password","Shaquille", "Soekhlal"));
        usersArrayList.add(new User("user8", "Steenbergen", "password","Erwin", "Steenbergen"));

        adminsArrayList.add(new User("admin", "admin", "password",null, null));


        groupsArrayList.add(new Group("group 1"));
        groupsArrayList.add(new Group("group 2"));
        groupsArrayList.add(new Group("group 3"));
        groupsArrayList.add(new Group("group 4"));

    }

}
