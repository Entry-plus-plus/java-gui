import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class Data extends GUI{
    JPanel dataPanel = new JPanel();
    JLabel dataLabel = new JLabel("This is the Data Panel");
    final JPanel mainview = new JPanel();
    final topButtons buttons = new topButtons();
    ChartPanel chartPanel;


    DefaultListModel<String> roomsListModel = new DefaultListModel<>();
    DefaultListModel<String> floorsListModel = new DefaultListModel<>();
    DefaultListModel<String> buildingsListModel = new DefaultListModel<>();
    JList roomsList = new JList(roomsListModel);
    JList floorsList = new JList(floorsListModel);
    JList buildingsList = new JList(buildingsListModel);

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> optionsList = new JList(listModel);


    static Time[] timeStamps = {new Time(0,0,0), new Time(0,15,0), new Time(0,30,0), new Time(0,45,0), new Time(1,0,0)};
    static double[] times = {0.0, 0.25, 0.50, 0.75, 1.0};
    static double[] amountsOfPeople = {0,5,20,17,32};

    XYDataset ds = createDataset();

    public Data() {


        //createGraph();
        //XYDataset ds = createDataset();
        createGraph("Room1", ds);


        buttons.currentButton = buttons.dataButton;
        buttons.giveColors();
        giveColors();

        setTitle("Entry++ - Data");

        //settingsPanel.add(settingsLabel);

        mainview.setLayout(new BoxLayout(mainview, BoxLayout.Y_AXIS));
        mainview.add(buttons.buttonsPanel);
        createDataLayout();
        mainview.add(dataPanel);
        //mainview.add(chartPanel);

        setContentPane(mainview);

        setSizeEtc(this);
    }

    public void createDataLayout() {
        fillList();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.X_AXIS));
        dataPanel.add(optionsList);
        dataPanel.add(chartPanel);

        optionsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String selectedOption = optionsList.getSelectedValue();
                changeGraph(selectedOption);
            }
        });
    }

    public void fillList() {
        for (Room room : roomsArray) {
            if (!listModel.contains(room.roomName.getText())) {
                listModel.addElement(room.roomName.getText());
            }
        }
        for (Floor floor : floorsArray) {
            if (!listModel.contains(floor.floorNameLabel.getText())){
                listModel.addElement(floor.floorNameLabel.getText());
            }
        }
        if (!listModel.contains("Whole building")) {
            listModel.addElement("Whole building");
        }
        listModel.addElement(" ");
        listModel.removeElement(" ");
    }

    public void changeGraph(String selectedOption) {
        dataPanel.remove(chartPanel);
        createGraph(selectedOption, ds); ///VERANDER DS

        dataPanel = new JPanel();
        createDataLayout();
        mainview.setVisible(true);
        dataPanel.setVisible(true);
        chartPanel.setVisible(true);
        mainview.add(dataPanel);
        giveColors();
    }

    private static XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { times, amountsOfPeople};

        ds.addSeries("series1", data);

        return ds;
    }

    public void createGraph(String title, XYDataset ds) {

        JFreeChart chart = ChartFactory.createXYLineChart(title,
                "time", "amount of people", ds, PlotOrientation.VERTICAL, true, true,
                false);

        try {
            dataPanel.remove(chartPanel);
        }
        catch (Exception e) {

        }
        chartPanel = new ChartPanel(chart);
        dataPanel.add(chartPanel);
    }


    public void giveColors() {
        dataPanel.setBackground(darkColor);
        mainview.setBackground(darkColor);

        optionsList.setBackground(darkColor2);
        optionsList.setForeground(lightColor);
    }
}
