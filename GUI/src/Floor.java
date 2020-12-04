import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Floor {

    Room[] rooms;
    int amount;
    int max;

    JLabel floorName = new JLabel();
    JLabel amountLabel = new JLabel(""+amount);
    JLabel maxLabel = new JLabel(""+max);
    JButton floorButton = new JButton();
    JProgressBar progressBar = new JProgressBar();

    public Floor(int numberOfRooms) {
        //er wordt een Floor aangemaakt met een aantal kamers
        //de kamers worden in een array gezet

        rooms = new Room[numberOfRooms];
        for (int i = 0; i<numberOfRooms; i++) {
            rooms[i] = new Room();
        }

        updateLabelValues();

        floorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedFloor();
            }
        });
    }

    //geeft het totaal aan mensen op de hele verdieping terug door de hoeveelheden van alle kamers op te tellen
    public int getAmount() {
        int amount = 0;
        for (Room room : rooms) {
            amount += room.amount;
        }
        return amount;
    }


    public void updateLabelValues() {
        updateAmountAndMax();
        amountLabel.setText(""+amount);
        maxLabel.setText(""+max);
        progressBar.setMaximum(max);
        progressBar.setValue(amount);

        //past kleur van progressBar aan
        progressBar.setForeground(GUI.heatmap.convertPercentageToColor(howFull()));
    }

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
        int percentage = amount * 100 / max;
        return percentage;
    }

    public void changeSelectedFloor() {
        GUI.selectedFloor = this;

        System.out.println(GUI.selectedFloor.floorName.getText());
    }
}
