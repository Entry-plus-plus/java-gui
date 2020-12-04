import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends GUI{

    //onderdelen van het dashboard worden gedeclareerd
    //Inlogscherm werkt met een .form en ook met zelf gemaakte code om dingen weer te geven
    private JButton dashboardButton;
    private JButton roomsButton;
    private JButton settingsButton;
    private JButton dataButton;
    private JButton contactButton;
    private JLabel entryLabel;
    Rooms rooms;
    JPanel dashboardPanel = new JPanel();
    static JPanel totalAmountPanel = new JPanel();
    static JLabel totalAmountTextLabel = new JLabel("Total amount of people in building:");
    static JLabel totalAmountLabel = new JLabel("0");


    //mainview hoort bij de .form, gebruik ik op dit moment niet
    private JPanel mainview;

    //maakt de knoppen die aan de bovenkant komen
    final topButtons buttons = new topButtons();


    public Dashboard() {
        setTitle("Entry++ - Dashboard");

        //niew panel aanmaken en zorgen dat het getoond kan worden

        setContentPane(dashboardPanel);

        //deze code heb ik gekopieerd van stackoverflow, moet nog uitvogelen wat het precies doet
        //dashboardPanel.setLayout(new BoxLayout(dashboardPanel, BoxLayout.Y_AXIS));


        //alles toevoegen aan dashboardPanel
        //dashboardPanel.add(mainview);

        rooms = new Rooms();
        createTotalAmountPanel();
        //updateTotalAmountPanel();


        /**dit is hoe de layout normaal is, niet verwijderen!!**/
        /*
        dashboardPanel.add(buttons.buttonsPanel);
        dashboardPanel.add(rooms.roomsPanel);
        dashboardPanel.add(notifications.notificationsPanel);
        dashboardPanel.add(heatmap.heatmapPanel);*/

        createDashboardLayout();

        //zet de grootte van het scherm
        //pack(); //past de grootte automatisch aan aan de elementen die er in staan
        setSize(1200,600);
        //setSize(getToolkit().getScreenSize()); //dit zet het fullscreen

        //laat het in het midden van het scherm openen
        setLocationRelativeTo(null);

        //zorgt dat het scherm verwijderd wordt als je op kruisje drukt
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //hier wordt gepaald dat het Rooms scherm geopend wordt als er op de rooms knop wordt gedrukt
        //(wordt niet gebruikt nu omdat ik niet met de .form werk)
        roomsButton.addActionListener(e -> {
            dispose();
            viewRooms();
        });



        //Alles hieronder wordt nu niet gebruikt


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

    public static void createTotalAmountPanel() {
        totalAmountPanel.setLayout(new BoxLayout(totalAmountPanel, BoxLayout.Y_AXIS));
        totalAmountLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 50));
        totalAmountTextLabel.setAlignmentX(CENTER_ALIGNMENT);
        totalAmountLabel.setAlignmentX(CENTER_ALIGNMENT);
        totalAmountPanel.add(totalAmountTextLabel);
        totalAmountPanel.add(totalAmountLabel);
    }

    public static void updateTotalAmountPanel() {
        int sum = 0;
        for (int i = 0; i < roomsArray.length; i++) {
            sum += roomsArray[i].amount;
        }
        totalAmountLabel.setText("" + sum);
    }

    public void createDashboardLayout() {
        GridBagLayout dashboardLayout = new GridBagLayout();
        dashboardPanel.setLayout(dashboardLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        //gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 6;
        gbc.insets = new Insets(10,300,10,10);
        dashboardPanel.add(buttons.buttonsPanel, gbc);

        gbc.insets = new Insets(10,10,10,10);
        //gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.weighty = 0;
        //gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        gbc.ipady = 5;
        //gbc.insets = new Insets(5,5,5,5);
        dashboardPanel.add(rooms.roomsPanel, gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        dashboardPanel.add(notifications.notificationsPanel,gbc);

        gbc.gridx = 8;
        gbc.gridy = 1;
        dashboardPanel.add(totalAmountPanel,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        dashboardPanel.add(floors.floorsPanel, gbc);

        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        dashboardPanel.add(heatmap.heatmapPanel, gbc);
    }

    /*
    public void setData(Dashboard data) {
    }

    public void getData(Dashboard data) {
    }

    public boolean isModified(Dashboard data) {
    }*/
}