import javax.swing.*;

public class Settings extends GUI{

    JPanel settingsPanel = new JPanel();
    JLabel settingsLabel = new JLabel("This is the settings Panel");
    JPanel mainview = new JPanel();
    topButtons buttons = new topButtons();

    public Settings() {
        setTitle("Entry++ - Settings");

        //settingsPanel.add(settingsLabel);

        mainview.add(buttons.buttonsPanel);
        mainview.add(settingsPanel);

        setContentPane(mainview);

        setSize(1200,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
