import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administration extends GUI{
    JPanel administrationPanel = new JPanel();
    JLabel administrationLabel = new JLabel("This is where the administrator can do administrator things");
    JPanel mainview = new JPanel();
    JButton logOutButton = new JButton("log out");

    public Administration() {
        setTitle("Entry++ - Administration");

        administrationPanel.add(administrationLabel);

        mainview.add(administrationPanel);
        mainview.add(logOutButton);

        setContentPane(mainview);

        setSize(1200,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewInlogscherm();
            }
        });
    }
}
