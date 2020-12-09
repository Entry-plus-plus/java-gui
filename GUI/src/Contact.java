import javax.swing.*;

public class Contact extends GUI{
    final JPanel contactPanel = new JPanel();
    JLabel contactLabel = new JLabel("This is the contact Panel");
    final JPanel mainview = new JPanel();
    final topButtons buttons = new topButtons();
    JLabel FAQ = new JLabel("FAQ");
    JLabel contact = new JLabel("contact");

    public Contact() {

        buttons.currentButton = buttons.contactButton;
        buttons.giveColors();

        setTitle("Entry++ - Contact");


        //settingsPanel.add(settingsLabel);



        /*//Dit is een uitprobeersel met grouplayout

        GroupLayout layout = new GroupLayout(mainview);
        mainview.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(buttons.buttonsPanel)
                        .addComponent(FAQ))
                .addComponent(contact)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(buttons.buttonsPanel)
                .addGroup(layout.createParallelGroup()
                .addComponent(FAQ)
                .addComponent(contact))
        );*/

        giveColors();

        mainview.add(buttons.buttonsPanel);
        mainview.add(contactPanel);

        setContentPane(mainview);

        setSizeEtc(this);
    }

    public void giveColors() {
        contactPanel.setBackground(darkColor);
        mainview.setBackground(darkColor);
    }
}
