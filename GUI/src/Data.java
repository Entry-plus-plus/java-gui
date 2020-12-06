import javax.swing.*;

public class Data extends GUI{
    final JPanel dataPanel = new JPanel();
    JLabel dataLabel = new JLabel("This is the Data Panel");
    final JPanel mainview = new JPanel();
    final topButtons buttons = new topButtons();

    public Data() {

        buttons.currentButton = buttons.dataButton;
        buttons.giveColors();

        setTitle("Entry++ - Data");

        //settingsPanel.add(settingsLabel);

        mainview.add(buttons.buttonsPanel);
        mainview.add(dataPanel);

        setContentPane(mainview);

        setSizeEtc(this);
    }
}
