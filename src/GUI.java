import javax.swing.*;

public class GUI extends JDialog {

    public static void main(String[] args) {
        Inlogscherm inlogscherm = new Inlogscherm();
    }


    public void LoggedIn(){ //deze wordt aangeroepen van uit Inlogscherm
        Rooms room = new Rooms();
    }
}
