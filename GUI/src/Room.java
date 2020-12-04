import javax.swing.*;
import java.awt.Color;


public class Room {
    //zet aantal mensen in de kamer en max aantal mensen vast. De waarde van max is willekeurig gekozen en mag veranderd worden
    int amount = 0;
    int max = 15;

    //maakt elementen van het scherm aan
    JLabel roomName = new JLabel();
    JLabel amountLabel = new JLabel(""+amount);
    JLabel maxLabel = new JLabel(""+max);
    JButton plusButton = new JButton("++");
    JButton minusButton = new JButton("--");
    JProgressBar progressBar = new JProgressBar();

    int startingXCoordinate;
    int startingYCoordinate;
    int height;
    int width;

    public Room() {
        makeButtonsWork();
    }


    //een aantal methods die volgens mij redelijk voor zich spreken
    public int getAmount() { return amount; }
    public int getMax() { return max; }
    public void emptyRoom() { amount = 0; }
    public void setRoomName(String name) {roomName.setText(name);}

    //dit is wat er gebeurt als je op de plus knop drukt
    //in het uiteindelijke product gebeurt dit als de sensor registreert dat er iemand naar binnen loopt
    public void plus(){
        //aantal mensen in kamer gaat omhoog
        amount++;

        //de labels op het scherm worden geupdate
        updateLabelValues();

        //als er te veel mensen zijn komt er een melding (als er nog geen melding was)
        if (isFull() && !GUI.notifications.listModel.contains("WARNING: Too many people in " + roomName.getText())) {
            GUI.createNotification("WARNING: Too many people in " + roomName.getText());
        }
    }

    //dit is wat er gebeurt als je op de min knop drukt
    //in het uiteindelijke product gebeurt dit als de sensor registreert dat er iemand naar buiten loopt
    public void minus() {
        //aantal mensen in kamer gaat omlaag
        amount--;

        //kan niet negatief worden
        if (amount < 0) {
            amount = 0;
        }
        //als het weer bij 10 is, zijn er niet meer te veel mensen. dus de notificatie wordt verwijderd
        else if (amount == max) {
            GUI.notifications.listModel.removeElement("WARNING: Too many people in " + roomName.getText());
        }
        updateLabelValues();
    }

    //zorgt dat de waarden op het scherm geupdate worden met nieuwe waarden
    public void updateLabelValues() {
        amountLabel.setText(""+amount);
        maxLabel.setText(""+max);
        progressBar.setMaximum(max);
        progressBar.setValue(amount);

        //past kleur van progressBar aan
        progressBar.setForeground(GUI.heatmap.convertPercentageToColor(howFull()));
        //past kleuren van heatmap aan
        GUI.heatmap.updateColors();

        Dashboard.updateTotalAmountPanel();
    }

    //zorgt dat de plus en min knop werken
    public void makeButtonsWork() {
        plusButton.addActionListener(e -> plus());
        minusButton.addActionListener(e -> minus());
    }

    public boolean isFull() {
        if (amount > max) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (amount == 0) {
            return true;
        }
        return false;
    }

    //geeft terug hoe vol de ruimte is in procenten
    public int howFull() {
        int percentage = amount * 100 / max;
        return percentage;
    }
}
