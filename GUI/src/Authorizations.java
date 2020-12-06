import javax.swing.*;
import java.awt.*;

public class Authorizations extends GUI{

    JPanel authorizationsPanel = new JPanel();
    JLabel authorizationsLabel = new JLabel("Authorizations");

    JLabel dashboard = new JLabel("Dashboard");
    //JToggleButton dashboardButton = new JToggleButton("Authorized");
    JRadioButton dashboardButton = new JRadioButton();
    //JCheckBox dashboardButton = new JCheckBox();


    public Authorizations() {

        createAuthorizationsLayout();
        giveColors();

    }


    public void createAuthorizationsLayout() {

        authorizationsPanel.setLayout(new GridLayout(2, 2));

        authorizationsLabel.setFont(new Font(Font.DIALOG,  Font.PLAIN, 20));

        authorizationsPanel.add(authorizationsLabel);
        authorizationsPanel.add(new JLabel(""));
        authorizationsPanel.add(dashboard);
        authorizationsPanel.add(dashboardButton);
    }

    public void giveColors() {
        authorizationsPanel.setBackground(darkColor);
        authorizationsLabel.setForeground(lightColor);
        dashboard.setForeground(lightColor);
        dashboardButton.setBackground(darkColor);
        dashboardButton.setForeground(lightColor);
    }


}
