import javax.swing.*;

public class Contact extends GUI{
    JPanel contactPanel = new JPanel();
    JLabel contactLabel = new JLabel("This is the contact Panel");
    JPanel mainview = new JPanel();
    topButtons buttons = new topButtons();

    public Contact() {
        setTitle("Entry++ - Contact");

        //settingsPanel.add(settingsLabel);

        mainview.add(buttons.buttonsPanel);
        mainview.add(contactPanel);

        setContentPane(mainview);

        setSize(1200,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
