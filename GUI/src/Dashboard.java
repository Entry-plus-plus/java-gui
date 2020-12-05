import javax.swing.*;
import java.awt.*;

public class Dashboard extends GUI{

    JPanel dashboardPanel = new JPanel();
    static JPanel totalAmountPanel = new JPanel();
    static JLabel totalAmountTextLabel = new JLabel("Total amount of people in building:");
    static JLabel totalAmountLabel = new JLabel("0");
    final topButtons buttons = new topButtons();

    public Dashboard() {
        setTitle("Entry++ - Dashboard");
        giveColors();
        buttons.currentButton = buttons.dashboardButton; //Dit is zodat de knop van dashboard een andere kleur wordt
        setContentPane(dashboardPanel);
        rooms = new Rooms();
        rooms.giveColors();
        floors = new Floors();
        floors.giveColors();
        heatmap = new Heatmap();
        heatmap.giveColors();
        createTotalAmountPanel();
        createDashboardLayout();
        setSizeEtc(this);
    }

    public static void createTotalAmountPanel() {
        totalAmountPanel.setLayout(new BoxLayout(totalAmountPanel, BoxLayout.Y_AXIS)); //zorgt dat de elementen onder elkaar komen
        totalAmountLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 50));
        totalAmountTextLabel.setAlignmentX(CENTER_ALIGNMENT);
        totalAmountLabel.setAlignmentX(CENTER_ALIGNMENT);
        totalAmountPanel.add(totalAmountTextLabel);
        totalAmountPanel.add(totalAmountLabel);
    }

    //zorgt dat de total amount geupdate wordt met de nieuwste waarde
    public static void updateTotalAmountPanel() {
        int sum = 0;
        for (int i = 0; i < roomsArray.length; i++) {
            sum += roomsArray[i].amount;
        }
        totalAmountLabel.setText("" + sum);
    }

    //maat de layout van het dashboard en voegt alle elementen toe volgens GrdBagLayout
    public void createDashboardLayout() {
        GridBagLayout dashboardLayout = new GridBagLayout();
        dashboardPanel.setLayout(dashboardLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 6;
        gbc.insets = new Insets(10,300,10,10);
        dashboardPanel.add(buttons.buttonsPanel, gbc);

        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        gbc.ipady = 5;
        dashboardPanel.add(rooms.roomsPanel, gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        //dashboardPanel.add(notifications.notificationsPanel,gbc);
        dashboardPanel.add(notifications.list, gbc);
        if (customColors) {
            notifications.list.setForeground(lightColor);
        }

        gbc.gridx = 8;
        gbc.gridy = 1;
        dashboardPanel.add(totalAmountPanel,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        dashboardPanel.add(floors.floorsPanel, gbc);

        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        dashboardPanel.add(heatmap.heatmapPanel, gbc);
    }

    public void giveColors() {
        if (customColors) {
            dashboardPanel.setBackground(darkColor);
            dashboardPanel.setForeground(darkColor);
            totalAmountPanel.setBackground(darkColor);
            totalAmountTextLabel.setForeground(lightColor);
            totalAmountLabel.setForeground(lightColor);

            buttons.giveColors();
            notifications.giveColors();
            //rooms.giveColors();
            //floors.giveColors();
            //heatmap.giveColors();
        }
    }

}