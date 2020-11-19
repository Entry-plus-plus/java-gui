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

    public int getAmount() { return amount; }
    public int getMax() { return max; }
    public void emptyRoom() { amount = 0; }
    public void setRoomName(String name) {roomName.setText(name);}

    public void plus(){
        amount++;
        updateLabelValues();
    }
    public void minus() {
        amount--;
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
