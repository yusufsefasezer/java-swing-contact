package com.yusufsezer.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ContactView extends JFrame {

    public JList contactList = new JList();

    public JTextField textFieldFirstName = new JTextField(20);
    public JTextField textFieldLastName = new JTextField(20);
    public JTextField textFieldEmail = new JTextField(20);
    public JTextField textFieldPhoneNumber = new JTextField(20);
    public JTextField textFieldWebAddress = new JTextField(20);
    public JTextArea textAreaAddress = new JTextArea(5, 20);
    public JTextArea textAreaNotes = new JTextArea(5, 20);

    public JButton buttonAdd = new JButton("Add");
    public JButton buttonUpdate = new JButton("Update");
    public JButton buttonRemove = new JButton("Remove");

    public ContactView() {
        setTitle("Java Swing Contact");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        JPanel jPanelLeft = new JPanel(new BorderLayout());

        contactList.setMaximumSize(new Dimension(100, 200));
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jScrollPane = new JScrollPane(contactList);
        jPanelLeft.add(jScrollPane, BorderLayout.CENTER);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(jPanelLeft, gridBagConstraints);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        JPanel jPanelRight = new JPanel(new GridBagLayout());

        jPanelRight.add(new JLabel("First name: "));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        jPanelRight.add(textFieldFirstName, gbc);

        jPanelRight.add(new JLabel("Last name: "));
        jPanelRight.add(textFieldLastName, gbc);

        jPanelRight.add(new JLabel("Email: "));
        jPanelRight.add(textFieldEmail, gbc);

        jPanelRight.add(new JLabel("Phone number: "));
        jPanelRight.add(textFieldPhoneNumber, gbc);

        jPanelRight.add(new JLabel("Web address: "));
        jPanelRight.add(textFieldWebAddress, gbc);

        jPanelRight.add(new JLabel("Address: "));
        jPanelRight.add(new JScrollPane(textAreaAddress), gbc);

        jPanelRight.add(new JLabel("Notes: "));
        jPanelRight.add(new JScrollPane(textAreaNotes), gbc);

        JPanel jPanelButton = new JPanel();
        jPanelButton.add(buttonAdd);
        jPanelButton.add(buttonUpdate);
        jPanelButton.add(buttonRemove);
        jPanelRight.add(jPanelButton, gbc);

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        add(jPanelRight, gridBagConstraints);
        pack();
    }

}
