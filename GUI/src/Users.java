import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Users extends GUI{

    public final JPanel usersPanel = new JPanel();
    JLabel usersLabel = new JLabel("Users");

    //String[] usernamesArray = new String[usersArrayList.size()];
    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> usersList = new JList(listModel);

    JButton addUserButton = new JButton("Add new user");
    JButton deleteUserButton = new JButton("Delete");
    JButton editUserButton = new JButton("Edit");
    JButton confirmEditButton = new JButton("confirm");

    User selectedUser;
    String selectedUserUsername;

    public Users() {

        fillList();

        createUsersLayout();
        giveColors();

        //zorgt dat het add new user scherm wordt geopend als je op de addNewUser knop drukt
        addUserButton.addActionListener(e -> {
            //method waarmee nieuw scherm wordt geopend als popup
            administration.createNewUserFrame();
        });

        deleteUserButton.addActionListener(e -> {
            administration.deleteUser(usersList.getSelectedValue());
            fillList();
        });

        editUserButton.addActionListener(e -> {
            administration.editUser();
        });

        confirmEditButton.addActionListener(e -> {
            selectedUser.editUser();

        });

        usersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selectedUserUsername = usersList.getSelectedValue();
                for (User user : usersArrayList) {
                    if (selectedUserUsername.equals( user.username)) {
                        selectedUser = user;
                        GUI.administration.changeSelectedUser();
                        return;
                    }
                }
            }
        });
    }



    public void createUsersLayout() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        usersPanel.setLayout(layout);

        usersLabel.setFont(new Font(Font.DIALOG,  Font.PLAIN, 20));

        //gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        usersPanel.add(usersLabel, gbc);

        gbc.gridy = 1;
        gbc.ipadx = 150;
        usersPanel.add(usersList, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 1;
        usersPanel.add(addUserButton, gbc);

        gbc.gridx = 4;
        usersPanel.add(deleteUserButton, gbc);

        gbc.gridx = 5;
        usersPanel.add(editUserButton, gbc);
    }

    public void fillList() {
        //listModel = new DefaultListModel<>();
        listModel.clear();
        for (User user : usersArrayList) {
            if (!listModel.contains(user.username)) {
                listModel.addElement(user.username);
            }
        }
    }

    public void giveColors() {
        if (customColors) {
            usersPanel.setBackground(darkColor);
            usersLabel.setForeground(lightColor);
            usersList.setBackground(darkColor2);
            usersList.setForeground(lightColor);
            addUserButton.setBackground(lightColor2);
            addUserButton.setForeground(darkColor);
            deleteUserButton.setBackground(lightColor2);
            deleteUserButton.setForeground(darkColor);
            editUserButton.setBackground(lightColor2);
            editUserButton.setForeground(darkColor);
            confirmEditButton.setBackground(lightColor2);
            confirmEditButton.setForeground(darkColor);
        }
    }
}
