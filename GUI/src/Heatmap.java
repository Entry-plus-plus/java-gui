import javax.swing.*;
import java.awt.*;

public class Heatmap extends GUI{

    final JPanel heatmapPanel = new JPanel();
    final JPanel heatmapPanel1 = new JPanel();
    final JPanel heatmapPanel2 = new JPanel();
    final JPanel fillerPanel = new JPanel();

    final JPanel room1 = new JPanel();
    final JPanel room2 = new JPanel();
    final JPanel room3 = new JPanel();
    final JPanel room4 = new JPanel();
    final JPanel room5 = new JPanel();
    final JPanel room6 = new JPanel();
    final JPanel room7 = new JPanel();

    final JLabel room1Label = new JLabel("room 1");
    final JLabel room2Label = new JLabel("room 2");
    final JLabel room3Label = new JLabel("room 3");
    final JLabel room4Label = new JLabel("room 4");
    final JLabel room5Label = new JLabel("room 5");
    final JLabel room6Label = new JLabel("room 6");
    final JLabel room7Label = new JLabel("room 7");


    public Heatmap() {
        if (customColors) {
            fillerPanel.setBackground(darkColor);
        }

        room1.add(room1Label);
        room2.add(room2Label);
        room3.add(room3Label);
        room4.add(room4Label);
        room5.add(room5Label);
        room6.add(room6Label);
        room7.add(room7Label);

        room1.setOpaque(true);
        room2.setOpaque(true);
        room3.setOpaque(true);
        room4.setOpaque(true);
        room5.setOpaque(true);
        room6.setOpaque(true);
        room7.setOpaque(true);



        createHeatmapFloor1(heatmapPanel1);
        createHeatmapFloor2(heatmapPanel2);
        updateColors();


    }



    public void updateColors() {
        room1.setBackground(GUI.convertPercentageToColor(roomsArray[0].howFull()));
        room2.setBackground(GUI.convertPercentageToColor(roomsArray[1].howFull()));
        room3.setBackground(GUI.convertPercentageToColor(roomsArray[2].howFull()));
        room4.setBackground(GUI.convertPercentageToColor(roomsArray[3].howFull()));
        room5.setBackground(GUI.convertPercentageToColor(roomsArray[4].howFull()));
        room6.setBackground(GUI.convertPercentageToColor(roomsArray[5].howFull()));
        room7.setBackground(GUI.convertPercentageToColor(roomsArray[6].howFull()));
    }

    public void createHeatmapFloor1(Container pane) {

        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(1,1,1,1);
        pane.add(room1, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        pane.add(room2, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.gridwidth = 2;
        gbc.ipadx = 40;
        pane.add(room3, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        pane.add(room4, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        pane.add(room5, gbc);

        room1.setBackground(Color.GREEN);
        room2.setBackground(Color.GREEN);
        room3.setBackground(Color.GREEN);
        room4.setBackground(Color.GREEN);
        room5.setBackground(Color.GREEN);


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

    public void createHeatmapFloor2 (Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(1,1,1,1);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.gridwidth = 2;
        pane.add(room6, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        pane.add(room7, gbc);

        room6.setBackground(Color.GREEN);
        room7.setBackground(Color.GREEN);
    }

    public void giveColors() {
        if (customColors) {
            heatmapPanel.setBackground(GUI.darkColor);
            heatmapPanel1.setBackground(GUI.darkColor);
            heatmapPanel2.setBackground(GUI.darkColor);
        }
    }

}
