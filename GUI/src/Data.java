import javax.swing.*;

public class Data extends GUI{
    JPanel dataPanel = new JPanel();
    JLabel dataLabel = new JLabel("This is the Data Panel");
    JPanel mainview = new JPanel();
    topButtons buttons = new topButtons();

    public Data() {
        setTitle("Entry++ - Data");

        //settingsPanel.add(settingsLabel);

        mainview.add(buttons.buttonsPanel);
        mainview.add(dataPanel);

        setContentPane(mainview);

        setSize(1200,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
