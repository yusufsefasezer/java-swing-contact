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

    public JTextField firstNameTextField = new JTextField(20);
    public JTextField lastNameTextField = new JTextField(20);
    public JTextField emailTextField = new JTextField(20);
    public JTextField phoneNumberTextField = new JTextField(20);
    public JTextField webAddressTextField = new JTextField(20);
    public JTextArea addressTextArea = new JTextArea(5, 20);
    public JTextArea notesTextArea = new JTextArea(5, 20);

    public JButton addButton = new JButton("Add");
    public JButton updateButton = new JButton("Update");
    public JButton removeButton = new JButton("Remove");

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
        jPanelRight.add(firstNameTextField, gbc);

        jPanelRight.add(new JLabel("Last name: "));
        jPanelRight.add(lastNameTextField, gbc);

        jPanelRight.add(new JLabel("Email: "));
        jPanelRight.add(emailTextField, gbc);

        jPanelRight.add(new JLabel("Phone number: "));
        jPanelRight.add(phoneNumberTextField, gbc);

        jPanelRight.add(new JLabel("Web address: "));
        jPanelRight.add(webAddressTextField, gbc);

        jPanelRight.add(new JLabel("Address: "));
        jPanelRight.add(new JScrollPane(addressTextArea), gbc);

        jPanelRight.add(new JLabel("Notes: "));
        jPanelRight.add(new JScrollPane(notesTextArea), gbc);

        JPanel jPanelButton = new JPanel();
        jPanelButton.add(addButton);
        jPanelButton.add(updateButton);
        jPanelButton.add(removeButton);
        jPanelRight.add(jPanelButton, gbc);

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        add(jPanelRight, gridBagConstraints);
        pack();
    }

}
