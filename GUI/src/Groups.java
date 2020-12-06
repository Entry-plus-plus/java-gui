import javax.swing.*;
import java.awt.*;

public class Groups extends GUI{

    public final JPanel groupsPanel = new JPanel();
    JLabel groupsLabel = new JLabel("Groups");

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> groupsList = new JList(listModel);

    JButton addGroupButton = new JButton("Add new group");
    JButton deleteGroupButton = new JButton("Delete");
    JButton editGroupButton = new JButton("Edit");

    public Groups() {
        fillList();

        createGroupsLayout();
        giveColors();

        addGroupButton.addActionListener(e -> {
            administration.createNewGroupFrame();
        });

        deleteGroupButton.addActionListener(e -> {
            administration.deleteGroup(groupsList.getSelectedValue());
            fillList();
        });
    }

    public void createGroupsLayout() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        groupsPanel.setLayout(layout);

        groupsLabel.setFont(new Font(Font.DIALOG,  Font.PLAIN, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        groupsPanel.add(groupsLabel, gbc);

        gbc.gridy = 1;
        gbc.ipadx = 150;
        groupsPanel.add(groupsList, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 1;
        groupsPanel.add(addGroupButton, gbc);

        gbc.gridx = 4;
        groupsPanel.add(deleteGroupButton, gbc);

        gbc.gridx = 5;
        groupsPanel.add(editGroupButton, gbc);
    }

    public void fillList() {
        //listModel = new DefaultListModel<>();
        listModel.clear();
        for (Group group : groupsArrayList) {
            if (!listModel.contains(group.groupName)) {
                listModel.addElement(group.groupName);
            }
        }
    }

    public void giveColors() {
        if (customColors) {
            groupsPanel.setBackground(darkColor);
            groupsLabel.setForeground(lightColor);
            groupsList.setBackground(darkColor2);
            groupsList.setForeground(lightColor);
            addGroupButton.setBackground(lightColor2);
            addGroupButton.setForeground(darkColor);
            deleteGroupButton.setBackground(lightColor2);
            deleteGroupButton.setForeground(darkColor);
            editGroupButton.setBackground(lightColor2);
            editGroupButton.setForeground(darkColor);
        }
    }
}

