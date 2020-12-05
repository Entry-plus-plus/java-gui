import javax.swing.*;
import javax.swing.JComponent;
import java.awt.*;

public class Heatmap extends GUI{
    JPanel mainview = new JPanel();
    JPanel heatmapPanel = new JPanel();
    JPanel heatmapPanel1 = new JPanel();
    JPanel heatmapPanel2 = new JPanel();

    JPanel room1 = new JPanel();
    JPanel room2 = new JPanel();
    JPanel room3 = new JPanel();
    JPanel room4 = new JPanel();
    JPanel room5 = new JPanel();
    JPanel room6 = new JPanel();
    JPanel room7 = new JPanel();

    JLabel room1Label = new JLabel("room 1");
    JLabel room2Label = new JLabel("room 2");
    JLabel room3Label = new JLabel("room 3");
    JLabel room4Label = new JLabel("room 4");
    JLabel room5Label = new JLabel("room 5");
    JLabel room6Label = new JLabel("room 6");
    JLabel room7Label = new JLabel("room 7");

    JPanel heatmapFloor1;
    JPanel heatmapFloor2;



    public Heatmap() {
        room1.add(room1Label);
        room2.add(room2Label);
        room3.add(room3Label);
        room4.add(room4Label);
        room5.add(room5Label);

        room1.setOpaque(true);
        room1.setBackground(Color.GREEN);
        room2.setOpaque(true);
        room2.setBackground(Color.GREEN);
        room3.setOpaque(true);
        room3.setBackground(Color.GREEN);
        room4.setOpaque(true);
        room4.setBackground(Color.GREEN);
        room5.setOpaque(true);
        room5.setBackground(Color.GREEN);

        createHeatmapFloor1(heatmapPanel);
        createHeatmapFloor2(heatmapPanel2);


    }

    public Color convertPercentageToColor (int percentage) {
        int red;
        int green;
        int blue = 0;

        if (percentage < 50) {
            red = (int) 5.1 * percentage;
            green = 255;
        }
        else if (percentage < 100) {
            red = 255;
            green = (int) (255 - (percentage - 50) * 5.1);
        }
        else {
            red = 255;
            green = 0;
        }

        return new Color(red, green, blue);
    }

    public void updateColors() {
        room1.setBackground(convertPercentageToColor(roomsArray[0].howFull()));
        room2.setBackground(convertPercentageToColor(roomsArray[1].howFull()));
        room3.setBackground(convertPercentageToColor(roomsArray[2].howFull()));
        room4.setBackground(convertPercentageToColor(roomsArray[3].howFull()));
        room5.setBackground(convertPercentageToColor(roomsArray[4].howFull()));
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
    }

    public void createHeatmapFloor2 (Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

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
    }

    public void giveColors() {
        if (customColors) {
            heatmapPanel.setBackground(GUI.darkColor);
            heatmapPanel1.setBackground(GUI.darkColor);
            heatmapPanel2.setBackground(GUI.darkColor);
        }
    }

}
