import javax.swing.*;
import java.awt.*;

public class Contact extends GUI{
    final JPanel contactPanel = new JPanel();
    final JPanel mainview = new JPanel();
    final topButtons buttons = new topButtons();
    JPanel FAQPanel = new JPanel();
    JLabel FAQLabel = new JLabel("FAQ");
    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> FAQList = new JList<>(listModel);

    JPanel contactInfoPanel = new JPanel();
    JLabel contactLabel = new JLabel("Contact info Entry++");
    JLabel phoneLabel = new JLabel("Phone Number: 015-1234567");
    JLabel emailLabel = new JLabel("Email address: info@Entry++.com");

    JLabel fillerLabel1 = new JLabel(" ");
    JLabel fillerLabel2 = new JLabel(" ");

    public Contact() {

        buttons.currentButton = buttons.contactButton;
        buttons.giveColors();

        setTitle("Entry++ - Contact");

        createLayout();

        giveColors();

    }

    public void createLayout() {
        createFAQPanel();
        createContactInfoPanel();

        contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.Y_AXIS));
        contactPanel.add(fillerLabel1);
        contactPanel.add(FAQPanel);
        contactPanel.add(fillerLabel2);
        contactPanel.add(contactInfoPanel);
        FAQPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        contactInfoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        FAQPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contactInfoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainview.setLayout(new BoxLayout(mainview, BoxLayout.Y_AXIS));
        mainview.add(buttons.buttonsPanel);
        mainview.add(contactPanel);
        setContentPane(mainview);

        setSizeEtc(this);
    }

    public void createFAQPanel() {
        createFAQs();

        GroupLayout layout = new GroupLayout(FAQPanel);
        FAQPanel.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(FAQLabel)
                        .addComponent(FAQList)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(FAQLabel)
                        .addComponent(FAQList)
        );

        FAQLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        FAQList.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 15));
    }

    public void createFAQs() {
        listModel.addElement("Q: how do I change my password?");
        listModel.addElement("A: Go to settings, there you will find a window to change your password");
        listModel.addElement(" ");
        listModel.addElement("Q: How do I reset my password if I have forgotten it");
        listModel.addElement("A: In settings, press the reset password button. Alternatively you can ask your administrator to reset it for you");
        listModel.addElement(" ");
    }

    public void createContactInfoPanel() {
        contactInfoPanel.setLayout(new BoxLayout(contactInfoPanel, BoxLayout.Y_AXIS));

        contactInfoPanel.add(contactLabel);
        contactInfoPanel.add(phoneLabel);
        contactInfoPanel.add(emailLabel);

        contactLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        phoneLabel.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 15));
        emailLabel.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 15));
    }

    public void giveColors() {
        contactPanel.setBackground(darkColor);
        mainview.setBackground(darkColor);

        FAQPanel.setBackground(darkColor);
        FAQLabel.setForeground(lightColor);
        FAQList.setBackground(darkColor);
        FAQList.setForeground(lightColor);

        contactInfoPanel.setBackground(darkColor);
        contactLabel.setForeground(lightColor);
        phoneLabel.setForeground(lightColor);
        emailLabel.setForeground(lightColor);
    }
}
