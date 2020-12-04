import javax.swing.*;
import javax.swing.JComponent;
import java.awt.*;

public class Heatmap extends GUI{
    JPanel mainview = new JPanel();
    JPanel heatmapPanel = new JPanel();

    JPanel room1 = new JPanel();
    JPanel room2 = new JPanel();
    JPanel room3 = new JPanel();
    JPanel room4 = new JPanel();
    JPanel room5 = new JPanel();
    JPanel room6 = new JPanel();
    JPanel room7 = new JPanel();

    JPanel heatmapFloor1;
    JPanel heatmapFloor2;



    public Heatmap() {
        room1.add(new JLabel("room1"));
        room2.add(new JLabel("room2"));
        room3.add(new JLabel("room3"));
        room4.add(new JLabel("room4"));
        room5.add(new JLabel("room5"));

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
        //uitprobeersel met gridbaglayout

        /*JFrame frame = new JFrame();

        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pane.add(room1, gbc);

        frame.pack();
        //frame.setSize(1200,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setVisible(true);*/




        /*JPanel gridBagPanel = new JPanel();

        GridBagLayout theLayout = new GridBagLayout();
        gridBagPanel.setLayout(theLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        setContentPane(gridBagPanel);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        theLayout.setConstraints(room1, gbc);
        add(room1, gbc);

        /*gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        theLayout.setConstraints(room1, gbc);
        gridBagPanel.add(room1);*/

        //JFrame frame = new JFrame();


        /*setSize(1200,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //heatmapPanel.setSize(200,200);
        mainview.add(gridBagPanel);
        setContentPane(mainview);
        setSize(1200,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);*/


        //dit gebruikt grouplayout
        /*GroupLayout layout = new GroupLayout(heatmapPanel);
        heatmapPanel.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(room1)
                    .addComponent(room2))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(room3)
                    .addComponent(room4)
                    .addComponent(room5))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addComponent(room1)
                    .addComponent(room2))
                .addGroup(layout.createParallelGroup()
                    .addComponent(room3)
                    .addComponent(room4)
                    .addComponent(room5))
        );*/

        //heatmapPanel.setSize(200,200);
        //mainview.add(heatmapPanel);
        //setContentPane(heatmapPanel);
        //setSize(1200,600);
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        /*
        //gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pane.add(room1, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        pane.add(room2, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        pane.add(room3, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.ipady = 40;
        gbc.weightx = 0.0;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        pane.add(room4, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;       //reset to default
        gbc.weighty = 1.0;   //request any extra vertical space
        gbc.anchor = GridBagConstraints.PAGE_END; //bottom of space
        //gbc.insets = new Insets(10,0,0,0);  //top padding
        gbc.gridx = 1;       //aligned with button 2
        gbc.gridwidth = 2;   //2 columns wide
        gbc.gridy = 2;       //third row
        pane.add(room5, gbc);*/

    }

}
