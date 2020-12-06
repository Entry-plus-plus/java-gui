import javax.swing.*;
import java.awt.*;

public class Heatmap extends GUI{

    //maakt verschillende panels voor de heatmaps
    final JPanel heatmapPanel = new JPanel();
    final JPanel heatmapPanel1 = new JPanel();
    final JPanel heatmapPanel2 = new JPanel();

    //maakt een panel aan per kamer
    final JPanel room1 = new JPanel();
    final JPanel room2 = new JPanel();
    final JPanel room3 = new JPanel();
    final JPanel room4 = new JPanel();
    final JPanel room5 = new JPanel();
    final JPanel room6 = new JPanel();
    final JPanel room7 = new JPanel();
    final JPanel fillerPanel = new JPanel();

    //maakt een label aan per kamer met het kamernummer
    final JLabel room1Label = new JLabel("room 1");
    final JLabel room2Label = new JLabel("room 2");
    final JLabel room3Label = new JLabel("room 3");
    final JLabel room4Label = new JLabel("room 4");
    final JLabel room5Label = new JLabel("room 5");
    final JLabel room6Label = new JLabel("room 6");
    final JLabel room7Label = new JLabel("room 7");


    public Heatmap() {

        //zet de labels met kamernummers in de panels van de kamers
        room1.add(room1Label);
        room2.add(room2Label);
        room3.add(room3Label);
        room4.add(room4Label);
        room5.add(room5Label);
        room6.add(room6Label);
        room7.add(room7Label);

        //maakt de kamerpanels ondoorzichtig
        room1.setOpaque(true);
        room2.setOpaque(true);
        room3.setOpaque(true);
        room4.setOpaque(true);
        room5.setOpaque(true);
        room6.setOpaque(true);
        room7.setOpaque(true);

        //maakt alle kamerpanels groen
        room1.setBackground(Color.GREEN);
        room2.setBackground(Color.GREEN);
        room3.setBackground(Color.GREEN);
        room4.setBackground(Color.GREEN);
        room5.setBackground(Color.GREEN);
        room6.setBackground(Color.GREEN);
        room7.setBackground(Color.GREEN);

        //maakt de plattegronden van de heatmaps
        createHeatmapFloor1(heatmapPanel1);
        createHeatmapFloor2(heatmapPanel2);

        //zorgt dat de kleuren in de heatmap overeenkomen met het aantal mensen in de kamer
        updateColors();

    }

    //update de kleuren in de heatmap aan de hand van het aantal mensen per kamer
    public void updateColors() {
        room1.setBackground(GUI.convertPercentageToColor(roomsArray[0].howFull()));
        room2.setBackground(GUI.convertPercentageToColor(roomsArray[1].howFull()));
        room3.setBackground(GUI.convertPercentageToColor(roomsArray[2].howFull()));
        room4.setBackground(GUI.convertPercentageToColor(roomsArray[3].howFull()));
        room5.setBackground(GUI.convertPercentageToColor(roomsArray[4].howFull()));
        room6.setBackground(GUI.convertPercentageToColor(roomsArray[5].howFull()));
        room7.setBackground(GUI.convertPercentageToColor(roomsArray[6].howFull()));
    }

    //maakt met GridBagLayout een plattegrond van de panels van de verschillende kamers van floor1 (kamer 1 tm 5)
    public void createHeatmapFloor1(Container pane) {

        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //room1
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(1,1,1,1);
        pane.add(room1, gbc);

        //room2
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        pane.add(room2, gbc);

        //room3
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.gridwidth = 2;
        gbc.ipadx = 40;
        pane.add(room3, gbc);

        //room4
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        pane.add(room4, gbc);

        //room5
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        pane.add(room5, gbc);


        /*gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        for (int i=0; i < 7; i++) {
            JPanel filler = fillerPanel;
            gbc.gridx = i;
            pane.add(filler, gbc);
        }

        JPanel filler = fillerPanel;*/
    }

    //maakt met GridBagLayout een plattegrond van de panels van de kamers van floor2 (kamer 6 en 7)
    public void createHeatmapFloor2 (Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //room6
        gbc.insets = new Insets(1,1,1,1);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.gridwidth = 2;
        pane.add(room6, gbc);

        //room7
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        pane.add(room7, gbc);
    }

    //zorgt dat alles de juiste kleur krijgt
    public void giveColors() {
        if (customColors) {
            heatmapPanel.setBackground(GUI.darkColor);
            heatmapPanel1.setBackground(GUI.darkColor);
            heatmapPanel2.setBackground(GUI.darkColor);
            fillerPanel.setBackground(darkColor);
        }
    }

}
