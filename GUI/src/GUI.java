import javax.swing.*;

public class GUI extends JDialog {

    public static void main(String[] args) {
        Inlogscherm inlogscherm = new Inlogscherm();
    }


    public void LoggedIn(){
        Dashboard dashboard = new Dashboard();
    }
    public void viewRooms(){
        Rooms rooms = new Rooms();
    }
}
