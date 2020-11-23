import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends GUI{

    //onderdelen van het dashboard worden gedeclareerd
    //Inlogscherm werkt met een .form en ook met zelf gemaakte code om dingen weet te geven
    private JButton dashboardButton;
    private JButton roomsButton;
    private JButton settingsButton;
    private JButton dataButton;
    private JButton contactButton;
    private JPanel mainview;
    private JLabel entryLabel;

    topButtons buttons = new topButtons();


    public Dashboard() {

        //als we alleen de .form zouden gebruiken zouden we dit doen. maar we doen het niet
        //setContentPane(mainview);

        //nu maken we een panel dashboardPanel aan waar we verschillende elementen (panels) in stoppen
        //de elemelnten zijn de knoppen bovenaan het dashboard, de rooms en de notifications
        //de opmaak van het scherm is nog wel lelijk, daar moet nog aan gewerkt worden

        //niew panel aanmaken en zorgen dat het getoond kan worden
        JPanel dashboardPanel = new JPanel();
        setContentPane(dashboardPanel);

        //deze code heb ik gekopieerd van stackoverflow, moet nog uitvogelen wat het doet
        dashboardPanel.setLayout(new BoxLayout(dashboardPanel, BoxLayout.Y_AXIS));

        //maakt een panel met alle knoppen die aan de bovenkant komen
        /*buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(entryLabel);
        buttonsPanel.add(dashboardButton);
        buttonsPanel.add(roomsButton);
        buttonsPanel.add(settingsButton);
        buttonsPanel.add(dataButton);
        buttonsPanel.add(contactButton);*/

        //alles toevoegen aan dashboardPanel
        //dashboardPanel.add(mainview);
        dashboardPanel.add(buttons.buttonsPanel);
        Rooms rooms = new Rooms();
        dashboardPanel.add(rooms.roomsPanel);
        dashboardPanel.add(notifications.notificationsPanel);

        //zet de grootte van het scherm
        //pack(); //past de grootte automatisch aan aan de elementen die er in staan
        setSize(1200,600);
        //setSize(getToolkit().getScreenSize()); //dit zet het fullscreen

        //maakt het zichtbaar. is hier weggecomment omdat we hem zichtbaar maken in GUI
        //setVisible(true);

        //zorgt dat het scherm verwijderd wordt als je op kruisje drukt
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //hier wordt gepaald dat het Rooms scherm geopend wordt als er op de rooms knop wordt gedrukt
        roomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewRooms();
            }
        });

//        Notificaties.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Output.setText("Notificaties");
//                int i = 1;
//            }
//        });
//        Gebouw.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                Output.setText("Gebouw");
////                int i = 2;
//            }
//        });
//        Verdiepingen.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                Output.setText("Verdiepingen");
////                int i = 3;
//            }
//        });
//        Zoek.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (Output.getText().equals("Rooms")){
//                    viewRooms();
//                }
//                if (Output.getText().equals("Verdiepingen")){
//                    Output2.setText("Er zijn 5 mensen op Verdieping "+ getal.getText());
//                }
//                if (Output.getText().equals("Gebouw")){
//                    Output2.setText("Er zijn 10 mensen in Gebouw "+ getal.getText());
//                }
//                if (Output.getText().equals("Notificaties")){
//                    Output2.setText("Er zijn geen notificaties.");
//                }
//
//            }
//        });

    }


    //@Shaquille wat doet dit?
    public void setData(Dashboard data) {
    }

    public void getData(Dashboard data) {
    }

    public boolean isModified(Dashboard data) {
        return false;
    }
}