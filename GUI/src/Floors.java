import javax.swing.*;
import java.awt.*;

public class Floors extends GUI{

    public JPanel floorsPanel = new JPanel();
    JPanel mainview = new JPanel();
    topButtons buttons = new topButtons();

    public Floors() {
        setTitle("Entry++ - Floors");
        add(floorsPanel);
        floorsPanel.setLayout(new GridLayout(numberOfFloors, 6));

        for (int i = 0; i < numberOfFloors; i++) {
            floorsArray[i].setFloorName("Floor " + (i+1));
            floorsArray[i].floorButton.setText("Floor " + (i+1));

            floorsPanel.add(new JLabel(" "));
            floorsPanel.add(floorsArray[i].floorButton);
            //floorsPanel.add(new JLabel(floorsArray[i].floorName.getText()));
            floorsPanel.add(floorsArray[i].amountLabel);
            floorsPanel.add(new JLabel("/"));
            floorsPanel.add(floorsArray[i].maxLabel);
            floorsPanel.add(floorsArray[i].progressBar);
        }

        mainview.add(buttons.buttonsPanel);
        mainview.add(floorsPanel);

        //maakt het zichtbaar
        setContentPane(mainview);

        //grootte bepalen
        setSize(1200,600);
        //setSize(getToolkit().getScreenSize()); //dit zet het fullscreen

        //laat het in het midden van het scherm openen
        setLocationRelativeTo(null);

        //zorgt dat het scherm verwijderd wordt als je op kruisje drukt
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
