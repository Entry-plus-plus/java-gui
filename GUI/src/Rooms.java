import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rooms extends GUI {

    private JPanel roomsPanel = new JPanel();

    public Rooms() {
        add(roomsPanel);

        int numberOfRooms = 5;
        Room[] rooms = new Room[numberOfRooms]; //maakt een array waar de Rooms in komen te staan
        roomsPanel.setLayout(new GridLayout(numberOfRooms, 7));
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room();      //vult de array met nieuwe Rooms
            rooms[i].setRoomName("room" + i);
            roomsPanel.add(new JLabel(rooms[i].roomName.getText()));
            roomsPanel.add(rooms[i].amountLabel);
            roomsPanel.add(new JLabel("/"));
            roomsPanel.add(rooms[i].maxLabel);
            roomsPanel.add(rooms[i].progressBar);
            roomsPanel.add(rooms[i].plusButton);
            roomsPanel.add(rooms[i].minusButton);
            rooms[i].makeButtonsWork();
        }

        setContentPane(roomsPanel);
        //setSize(600,500);
        setSize(getToolkit().getScreenSize()); //dit zet het fullscreen
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

        //////OUDE CODE (werkt niet helemaal meer)////

    private JPanel panel1;
    private JProgressBar room1ProgressBar;
    private JButton room1PlusButton;
    private JButton room1MinusButton;
    private JLabel room1Amount;
    private JLabel room1Max;
    private JProgressBar room2ProgressBar;
    private JButton room2PlusButton;
    private JButton room2MinusButton;
    private JProgressBar room3ProgressBar;
    private JProgressBar room4ProgressBar;
    private JButton room3PlusButton;
    private JButton room3MinusButton;
    private JButton room4PlusButton;
    private JButton room4MinusButton;
    private JLabel room2Amount;
    private JLabel room2Max;
    private JLabel room3Amount;
    private JLabel room3Max;
    private JLabel room4Amount;
    private JLabel room4Max;
    private JLabel alert;

    /*public Rooms(){

    setContentPane(panel1);
        //setSize(600,500);
        setSize(getToolkit().getScreenSize()); //dit zet het fullscreen
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        room1PlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //amount1++;
                int amount = Integer.parseInt(room1Amount.getText());
                int max = Integer.parseInt(room1Max.getText());
                amount++;
                if (amount > max1) {
                    alert.setText("Too many people! >:(");
                }
                else if (amount > 0) {
                    alert.setText(" ");
                }
                room1Amount.setText(""+amount);
                room1ProgressBar.setValue(amount);
            }
        });
        room1MinusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(room1Amount.getText());
                int max = Integer.parseInt(room1Max.getText());
                amount--;
                if (amount < 0) {
                    amount = 0;
                    alert.setText("can't have negative amount");
                }
                else if (amount <= max) {
                    alert.setText(" ");
                }
                room1Amount.setText(""+amount);
                room1ProgressBar.setValue(amount);
            }
        });*/


 }
