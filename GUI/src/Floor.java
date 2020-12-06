import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Floor {

    final Room[] rooms;
    int amount;
    int max;

    final JLabel floorName = new JLabel();
    final JLabel amountLabel = new JLabel(""+amount);
    final JLabel maxLabel = new JLabel(""+max);
    final JLabel slashLabel = new JLabel("/");
    final JButton floorButton = new JButton();
    final JProgressBar progressBar = new JProgressBar();

    public Floor(int numberOfRooms) {

        //maakt de labels de juiste grootte
        amountLabel.setFont(new Font(Font.DIALOG,  Font.PLAIN, 20));
        maxLabel.setFont(new Font(Font.DIALOG,  Font.PLAIN, 20));

        //maakt een aantal kamers
        rooms = new Room[numberOfRooms];
        for (int i = 0; i<numberOfRooms; i++) {
            rooms[i] = new Room();
        }

        giveColors();
        updateLabelValues();

        floorButton.addActionListener(e -> changeSelectedFloor());      //zorgt dat de knop van de floor werkt
    }

    public void updateLabelValues() {
        updateAmountAndMax();
        amountLabel.setText("   "+amount);
        maxLabel.setText(""+max);
        progressBar.setMaximum(max);
        progressBar.setValue(amount);

        //past kleur van progressBar aan
        progressBar.setForeground(GUI.convertPercentageToColor(howFull()));
    }

    //berekent amount en max door de waarden van alle kamers in de floor op te tellen
    public void updateAmountAndMax() {
        amount = 0;
        max = 0;
        for (Room room : rooms) {
            amount += room.amount;
            max += room.max;
        }
    }

    public void setFloorName(String name) {floorName.setText(name);}

    public int howFull() {
        return amount * 100 / max;
    }

    public void changeSelectedFloor() {
        GUI.selectedFloor = this;
        GUI.dashboard.changeHeatmap();
    }

    public void giveColors() {
        if (GUI.customColors) {
            floorName.setForeground(GUI.lightColor);
            amountLabel.setForeground(GUI.lightColor);
            maxLabel.setForeground(GUI.lightColor);
            slashLabel.setForeground(GUI.lightColor);
            floorButton.setBackground(GUI.darkColor2);
            floorButton.setForeground(GUI.lightColor);
            progressBar.setBackground(GUI.darkColor);
        }
    }
}
