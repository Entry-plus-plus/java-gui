import javax.swing.*;
import javax.swing.JComponent;
import java.awt.*;

public class Contact extends GUI{
    final JPanel contactPanel = new JPanel();
    JLabel contactLabel = new JLabel("This is the contact Panel");
    final JPanel mainview = new JPanel();
    final topButtons buttons = new topButtons();
    JLabel FAQ = new JLabel("FAQ");
    JLabel contact = new JLabel("contact");

    public Contact() {
        setTitle("Entry++ - Contact");

        //Dit is een test om een gekleurde knop te maken
        JComponent test = new JButton("test");
        test.setOpaque(true);
        test.setBackground(Color.GREEN);
        test.setForeground(Color.RED);
        mainview.add(test);


        //settingsPanel.add(settingsLabel);



        /*//Dit is een uitprobeersel met grouplayout

        GroupLayout layout = new GroupLayout(mainview);
        mainview.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(buttons.buttonsPanel)
                        .addComponent(FAQ))
                .addComponent(contact)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(buttons.buttonsPanel)
                .addGroup(layout.createParallelGroup()
                .addComponent(FAQ)
                .addComponent(contact))
        );*/



        mainview.add(buttons.buttonsPanel);
        mainview.add(contactPanel);

        setContentPane(mainview);

        setSize(1200,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
