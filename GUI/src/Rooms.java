import javax.swing.*;
import java.awt.*;

public class Rooms extends GUI {

    //deze panel is voor wanneer rooms als apart scherm wordt geopend. Hier kunnen namelijk knoppen aan toegevoegd worden
    final JPanel mainview = new JPanel();

    public final JPanel roomsPanel = new JPanel();      //maakt de panel waar de rooms info in komt
    final topButtons buttons = new topButtons();        //maakt de knoppen die aan de bovenkant komen

    boolean usePlusMinusButtons = false;

    public Rooms() {

        buttons.currentButton = buttons.roomsButton;    //Dit is zodat de knop van rooms een andere kleur wordt
        buttons.giveColors();

        setTitle("Entry++ - Rooms");                    //geeft het scherm een titel
        add(roomsPanel);                                //voegt roomsPanel toe aan de frame

        //bepaalt de layout van roomsPanel, het is een grid met numberOfRooms aan rijen en 8 kolommen
        //als je nu dingen toevoegt aan roomsPanel, wordt van links naar rechts, boven naar beneden de grid gevuld
        if (usePlusMinusButtons) {
            roomsPanel.setLayout(new GridLayout(numberOfRooms, 8));
        }
        else {
            roomsPanel.setLayout(new GridLayout(numberOfRooms, 6));
        }

        //in GUI is er een array van Rooms gemaakt, hier wordt roomsPanel gevuld met info uit die array
        //iedere iteratie van deze for loop is een rij van de grid
        for (int i = 0; i < numberOfRooms; i++) {
            //als de array nog niet gevuld was in GUI zouden we hem hiermee kunnen vullen met nieuwe Rooms:
            //rooms[i] = new Room();

            //hier wordt de grid van links naar rechts gevuld
            roomsArray[i].setRoomName("room " + (i+1));
            roomsPanel.add(new JLabel(" "));
            roomsPanel.add(roomsArray[i].roomName);
            roomsPanel.add(roomsArray[i].amountLabel);
            roomsPanel.add(roomsArray[i].slashLabel);
            roomsPanel.add(roomsArray[i].maxLabel);
            roomsPanel.add(roomsArray[i].progressBar);
            if (usePlusMinusButtons) {
                roomsPanel.add(roomsArray[i].plusButton);
                roomsPanel.add(roomsArray[i].minusButton);
            }
            roomsArray[i].giveColors();
            roomsArray[i].updateLabelValues();
        }

        giveColors();       //alles krijgt de juiste kleuren

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
