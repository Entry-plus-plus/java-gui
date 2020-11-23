import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room {
    int amount = 0;
    int max = 10;

    JLabel roomName = new JLabel();
    JLabel amountLabel = new JLabel(""+amount);
    JLabel maxLabel = new JLabel(""+max);
    JButton plusButton = new JButton("++");
    JButton minusButton = new JButton("--");
    JProgressBar progressBar = new JProgressBar();

    public Room() {
        makeButtonsWork();
    }

    public int getAmount() { return amount; }
    public int getMax() { return max; }
    public void emptyRoom() { amount = 0; }
    public void setRoomName(String name) {roomName.setText(name);}

    public void plus(){
        amount++;
        updateLabelValues();
        if (amount > max && !GUI.notifications.listModel.contains("WARNING: Too many people in " + roomName.getText())) {
            GUI.createNotification("WARNING: Too many people in " + roomName.getText());
        }
    }
    public void minus() {
        amount--;
        if (amount < 0) {
            amount = 0;
        }
        else if (amount == 10) {
            GUI.notifications.listModel.removeElement("WARNING: Too many people in " + roomName.getText());
        }
        updateLabelValues();
    }

    public void updateLabelValues() {
        amountLabel.setText(""+amount);
        maxLabel.setText(""+max);
        progressBar.setMaximum(max);
        progressBar.setValue(amount);
    }

    public void makeButtonsWork() {
        plusButton.addActionListener(e -> plus());
        minusButton.addActionListener(e -> minus());
    }
}
