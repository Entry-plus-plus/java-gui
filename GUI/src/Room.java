import javax.swing.*;
import java.awt.*;

public class Room {
    //zet aantal mensen in de kamer en max aantal mensen vast. De waarde van max is willekeurig gekozen en mag veranderd worden
    int amount = 0;
    int max = 15;
    int roomNumber;
    String roomCode;
    int floorNumber;

    //maakt elementen van het scherm aan
    final JLabel roomName = new JLabel();
    final JLabel amountLabel = new JLabel(""+amount);
    final JLabel maxLabel = new JLabel(""+max);
    final JLabel slashLabel = new JLabel("/");
    final JButton plusButton = new JButton("++");
    final JButton minusButton = new JButton("--");
    final JProgressBar progressBar = new JProgressBar();

    public Room(int amount, int max, int roomNumber, String roomCode, int floorNumber) {

        this.amount = amount;
        this.max = max;
        this.roomNumber = roomNumber;
        this.roomCode = roomCode;
        this.floorNumber = floorNumber;

        giveColors();

        //maakt de labels de juiste grootte
        amountLabel.setFont(new Font(Font.DIALOG,  Font.PLAIN, 20));
        maxLabel.setFont(new Font(Font.DIALOG,  Font.PLAIN, 20));

        makeButtonsWork();
    }

    public void emptyRoom() { amount = 0; }                         //maakt kamer leeg. wordt momenteel niet gebruikt
    public void setRoomName(String name) {roomName.setText(name);}  //verandert de naam van de kamer

    //dit is wat er gebeurt als je op de plus knop drukt
    public void plus(){

        amount++;               //aantal mensen in kamer gaat omhoog
        updateLabelValues();

        //als er te veel mensen zijn komt er een melding (als er nog geen melding was)
        if (isFull() && !GUI.notifications.listModel.contains("WARNING: Too many people in " + roomName.getText())) {
            GUI.createNotification("WARNING: Too many people in " + roomName.getText());
        }
        if (GUI.usingDatabase) {
            try {
                GUI.aaa.addEntry(roomCode);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //dit is wat er gebeurt als je op de min knop drukt
    public void minus() {

        amount--;               //aantal mensen in kamer gaat omlaag
        if (amount < 0) {       //zorgt dat het niet negatief kan worden
            amount = 0;
        }
        //als het weer bij max is, zijn er niet meer te veel mensen. dus de notificatie wordt verwijderd
        else if (amount == max) {
            GUI.notifications.listModel.removeElement("WARNING: Too many people in " + roomName.getText());
        }
        updateLabelValues();    //de labels op het scherm worden geupdate

        if (GUI.usingDatabase) {
            try {
                GUI.aaa.removeEntry(roomCode);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //zorgt dat de waarden op het scherm geupdate worden met nieuwe waarden
    public void updateLabelValues() {
        amountLabel.setText(""+amount);
        maxLabel.setText(""+max);
        progressBar.setMaximum(max);
        progressBar.setValue(amount);

        for (Floor floor : GUI.floorsArray) {
            floor.updateLabelValues();
        }

        progressBar.setForeground(GUI.convertPercentageToColor(howFull()));     //past kleur van progressBar aan
        GUI.heatmap.updateColors();                                             //past kleuren van heatmap aan
        Dashboard.updateTotalAmountPanel();                                     //past het totaal aan
    }

    //zorgt dat de plus en min knop werken
    public void makeButtonsWork() {
        plusButton.addActionListener(e -> plus());
        minusButton.addActionListener(e -> minus());
    }

    //geeft true terug als amount meer is dan max, dus als er te veel mensen zijn
    public boolean isFull() {
        return amount > max;
    }

    //geeft true terug als er geen mensen in de ruimte zijn
    public boolean isEmpty() {
        return amount == 0;
    }

    //geeft terug hoe vol de ruimte is in procenten
    public int howFull() {
        return amount * 100 / max;
    }

    //geeft alle onderdelen de juiste kleur
    public void giveColors() {
        if (GUI.customColors) {
            roomName.setForeground(GUI.lightColor);
            amountLabel.setForeground(GUI.lightColor);
            maxLabel.setForeground(GUI.lightColor);
            slashLabel.setForeground(GUI.lightColor);
            plusButton.setForeground(GUI.lightColor);
            plusButton.setBackground(GUI.darkColor);
            minusButton.setForeground(GUI.lightColor);
            minusButton.setBackground(GUI.darkColor);
            progressBar.setBackground(GUI.darkColor);
        }
    }
}
