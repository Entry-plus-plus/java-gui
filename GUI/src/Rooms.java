import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rooms extends GUI {
    private JPanel panel1;
    private JProgressBar progressBar1;
    private JButton plusbutton;
    private JButton minusbutton;
    private JLabel room1amount;
    private JLabel room1max;
    private JLabel alert;


    public Rooms() {
        /*int amount = 0;
        int max = 10;
        room1amount.setText(""+amount);
        room1max.setText(""+max);
        amount++;*/
        setContentPane(panel1);
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        progressBar1.setMaximum(10);
        progressBar1.setValue(0);

        plusbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(room1amount.getText());
                int max = Integer.parseInt(room1max.getText());
                amount++;
                if (amount > max) {
                    alert.setText("Too many people! >:(");
                }
                else if (amount > 0) {
                    alert.setText(" ");
                }
                room1amount.setText(""+amount);
                progressBar1.setValue(amount);
            }
        });
        minusbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(room1amount.getText());
                int max = Integer.parseInt(room1max.getText());
                amount--;
                if (amount < 0) {
                    amount = 0;
                    alert.setText("can't have negative amount");
                }
                else if (amount <= max) {
                    alert.setText(" ");
                }
                room1amount.setText(""+amount);
                progressBar1.setValue(amount);
            }
        });
    }
 }
