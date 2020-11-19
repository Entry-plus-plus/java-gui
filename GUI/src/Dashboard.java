import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends GUI{
    private JButton dashboardButton;
    private JButton roomsButton;
    private JButton settingsButton;
    private JButton dataButton;
    private JButton contactButton;
    private JPanel mainview;
    private JLabel entryLabel;
    private JTable table1;

    public Dashboard() {
        setContentPane(mainview);
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        roomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewRooms();
            }
        });
//        Notificaties.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Output.setText("Notificaties");
//                int i = 1;
//            }
//        });
//        Gebouw.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                Output.setText("Gebouw");
////                int i = 2;
//            }
//        });
//        Verdiepingen.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                Output.setText("Verdiepingen");
////                int i = 3;
//            }
//        });
//        Zoek.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (Output.getText().equals("Rooms")){
//                    viewRooms();
//                }
//                if (Output.getText().equals("Verdiepingen")){
//                    Output2.setText("Er zijn 5 mensen op Verdieping "+ getal.getText());
//                }
//                if (Output.getText().equals("Gebouw")){
//                    Output2.setText("Er zijn 10 mensen in Gebouw "+ getal.getText());
//                }
//                if (Output.getText().equals("Notificaties")){
//                    Output2.setText("Er zijn geen notificaties.");
//                }
//
//            }
//        });
    }
}