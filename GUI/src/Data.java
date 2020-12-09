import javax.swing.*;
import java.sql.Time;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class Data extends GUI{
    final JPanel dataPanel = new JPanel();
    JLabel dataLabel = new JLabel("This is the Data Panel");
    final JPanel mainview = new JPanel();
    final topButtons buttons = new topButtons();
    ChartPanel chartPanel;

    static Time[] timeStamps = {new Time(0,0,0), new Time(0,15,0), new Time(0,30,0), new Time(0,45,0), new Time(1,0,0)};
    static double[] times = {0.0, 0.25, 0.50, 0.75, 1.0};
    static double[] amountsOfPeople = {0,5,20,17,32};

    public Data() {


        //createGraph();
        //XYDataset ds = createDataset();
        createGraph();


        buttons.currentButton = buttons.dataButton;
        buttons.giveColors();
        giveColors();

        setTitle("Entry++ - Data");

        //settingsPanel.add(settingsLabel);

        mainview.setLayout(new BoxLayout(mainview, BoxLayout.Y_AXIS));
        mainview.add(buttons.buttonsPanel);
        mainview.add(dataPanel);
        mainview.add(chartPanel);

        setContentPane(mainview);

        setSizeEtc(this);
    }

    private static XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { times, amountsOfPeople};

        ds.addSeries("series1", data);

        return ds;
    }

    public void createGraph() {
        XYDataset ds = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                "time", "amount of people", ds, PlotOrientation.VERTICAL, true, true,
                false);

        chartPanel = new ChartPanel(chart);
    }


    public void giveColors() {
        dataPanel.setBackground(darkColor);
        mainview.setBackground(darkColor);
    }
}
