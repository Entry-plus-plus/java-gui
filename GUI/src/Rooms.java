import javax.swing.*;
import java.awt.*;

public class Rooms extends GUI {

    //Rooms werkt niet met een .form

    //maakt een panel waar de info over de rooms in komt te staan
    public JPanel roomsPanel = new JPanel();

    //deze panel is voor wanneer rooms als apart scherm wordt geopend. Hier kan namelijk een knop aan toegevoegd worden
    JPanel mainview = new JPanel();

    //maakt de knoppen die aan de bovenkant komen
    topButtons buttons = new topButtons();


    public Rooms() {

        buttons.currentButton = buttons.roomsButton;
        buttons.giveColors();

        //geeft het scherm een titel
        setTitle("Entry++ - Rooms");

        //voegt roomsPanel toe aan de frame
        add(roomsPanel);

        //bepaalt de layout van roomsPanel, het is een grid met numberOfRooms aan rijen en 8 kolommen
        //als je nu dingen toevoegt aan roomsPanel, wordt van links naar rechts, boven naar beneden de grid gevuld
        roomsPanel.setLayout(new GridLayout(numberOfRooms, 8));

        //in GUI is er een array van Rooms gemaakt, hier wordt roomsPanel gevuld met info uit die array
        //iedere iteratie van deze for loop is een rij van de grid
        for (int i = 0; i < numberOfRooms; i++) {
            //als de array nog niet gevuld was in GUI zouden we hem hiermee kunnen vullen met nieuwe Rooms:
            //rooms[i] = new Room();

            //hier wordt de grid van links naar rechts gevuld
            roomsArray[i].setRoomName("room " + (i+1));
            roomsPanel.add(new JLabel(" "));
            //roomsPanel.add(new JLabel(roomsArray[i].roomName.getText()));
            roomsPanel.add(roomsArray[i].roomName);
            //roomsArray[i].roomName.setText();
            roomsPanel.add(roomsArray[i].amountLabel);
            roomsPanel.add(roomsArray[i].slashLabel);
            roomsPanel.add(roomsArray[i].maxLabel);
            roomsPanel.add(roomsArray[i].progressBar);
            roomsPanel.add(roomsArray[i].plusButton);
            roomsPanel.add(roomsArray[i].minusButton);
            roomsArray[i].giveColors();
        }

        giveColors();

        //voegt de knoppen bovenaan en de panel met rooms toe aan het scherm
        mainview.add(buttons.buttonsPanel);
        mainview.add(roomsPanel);

        //maakt het zichtbaar
        setContentPane(mainview);

        setSizeEtc(this);
    }

    public void giveColors() {
        if (customColors) {
            roomsPanel.setBackground(darkColor);
            roomsPanel.setForeground(lightColor);
            mainview.setBackground(darkColor);
        }
    }
 }
