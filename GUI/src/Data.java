import javax.swing.*;
import java.sql.Time;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.*;
import javafx.stage.Stage;
import javafx.application.Application;
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

    NumberAxis xAxis;
    NumberAxis yAxis;

    Stage stage;

    XYChart.Series series = new XYChart.Series();
    public Data() {
        /*xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        stage = new Stage();

        xAxis.setLabel("time");
        yAxis.setLabel("Amount of people");

        ObservableList timeList = series.getData();
        for (int i = 0; i < timeStamps.length; i++) {
            timeList.add(new XYChart.Data(timeStamps[i], amountsOfPeople[i]));
        }

        LineChart lineChart = new LineChart(xAxis, yAxis);

        Scene scene = new Scene (lineChart, 800, 600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();*/


        //createGraph();
        //XYDataset ds = createDataset();
        createGraph();


        buttons.currentButton = buttons.dataButton;
        buttons.giveColors();
        giveColors();

        setTitle("Entry++ - Data");

        //settingsPanel.add(settingsLabel);

        mainview.add(buttons.buttonsPanel);
        mainview.add(dataPanel);
        mainview.add(chartPanel);
        //mainview.add(lineChart);

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
