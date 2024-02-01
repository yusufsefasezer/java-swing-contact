package com.yusufsezer.controller;

import com.yusufsezer.model.Contact;
import com.yusufsezer.service.ContactService;
import com.yusufsezer.util.ValidationUtils;
import com.yusufsezer.view.ContactView;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

public class ContactController {

    private final ContactService contactService;
    private final ContactView contactView;
    private final DefaultListModel<Contact> contacts = new DefaultListModel<>();

    public ContactController(ContactService contactService, ContactView contactView) {
        this.contactService = contactService;
        this.contactView = contactView;

        this.contactView.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                boolean result = contactService.save();
                if (result) {
                    System.out.println("Saved");
                } else {
                    System.err.println("Error");
                }
            }

        });

        contactView.contactList.setModel(contacts);
        contactView.contactList.addListSelectionListener(this::listChanged);

        contactView.buttonAdd.addActionListener(this::addContact);
        contactView.buttonUpdate.addActionListener(this::updateContact);
        contactView.buttonRemove.addActionListener(this::removeContact);

        fillContacts();
    }

    public void showGUI() {
        contactView.setVisible(true);
    }

    private void listChanged(ListSelectionEvent e) {

        if (e.getValueIsAdjusting()) {
            return;
        }

        Object selectedValue = this.contactView.contactList.getSelectedValue();

        if (selectedValue instanceof Contact selectedContact) {
            this.contactView.textFieldFirstName.setText(selectedContact.getFirstName());
            this.contactView.textFieldLastName.setText(selectedContact.getLastName());
            this.contactView.textFieldEmail.setText(selectedContact.getEmail());
            this.contactView.textFieldPhoneNumber.setText(selectedContact.getPhoneNumber());
            this.contactView.textAreaAddress.setText(selectedContact.getAddress());
            this.contactView.textFieldWebAddress.setText(selectedContact.getWebAddress());
            this.contactView.textAreaNotes.setText(selectedContact.getNotes());
        }

    }

    private void addContact(ActionEvent e) {

        List<String> messages = new ArrayList<>();

        String firstName = this.contactView.textFieldFirstName.getText();
        String lastName = this.contactView.textFieldLastName.getText();
        String email = this.contactView.textFieldEmail.getText();
        String phoneNumber = this.contactView.textFieldPhoneNumber.getText();
        String address = this.contactView.textAreaAddress.getText();
        String webAddress = this.contactView.textFieldWebAddress.getText();
        String notes = this.contactView.textAreaNotes.getText();
        int newId = contacts.size() + 1;

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()
                || phoneNumber.isEmpty() || address.isEmpty()
                || webAddress.isEmpty() || notes.isEmpty()) {
            messages.add("Please fill in all fields.");
        }

        if (!ValidationUtils.isValidEmail(email)) {
            messages.add("Invalid e-mail address");
        }

        if (!ValidationUtils.isValidPhoneNumber(phoneNumber)) {
            messages.add("Invalid phone number");
        }

        if (!ValidationUtils.isValidURL(webAddress)) {
            messages.add("Invalid web address");
        }

        if (messages.size() > 0) {
            String newLine = System.getProperty("line.separator");
            String message = String.join(newLine, messages);
            JOptionPane.showMessageDialog(contactView, message);
            messages.clear();
            return;
        }
        Contact newContact = Contact.of(firstName, lastName, email, phoneNumber, address, webAddress, notes);
        newContact.setId(newId);

        boolean result = contactService.create(newContact);
        if (result) {
            contacts.addElement(newContact);
        }
        clearInputs();

    }

    private void updateContact(ActionEvent e) {

        Object selectedValue = this.contactView.contactList.getSelectedValue();
        int selectedIndex = this.contactView.contactList.getSelectedIndex();

        if (selectedValue instanceof Contact selectedContact) {
            selectedContact.setFirstName(this.contactView.textFieldFirstName.getText());
            selectedContact.setLastName(this.contactView.textFieldLastName.getText());
            selectedContact.setEmail(this.contactView.textFieldEmail.getText());
            selectedContact.setPhoneNumber(this.contactView.textFieldPhoneNumber.getText());
            selectedContact.setAddress(this.contactView.textAreaAddress.getText());
            selectedContact.setWebAddress(this.contactView.textFieldWebAddress.getText());
            selectedContact.setNotes(this.contactView.textAreaNotes.getText());
            selectedContact.setModifiedDate(LocalDateTime.now());
            this.contactService.update((long) selectedIndex, selectedContact);
            contacts.set(selectedIndex, selectedContact);
            fillContacts();
            clearInputs();
        }

    }

    private void removeContact(ActionEvent e) {

        Object selectedValue = contactView.contactList.getSelectedValue();
        int selectedIndex = contactView.contactList.getSelectedIndex();

        if (selectedValue instanceof Contact selectedContact) {
            contactService.delete((Long) selectedContact.getId());
            contacts.remove(selectedIndex);
        }

        fillContacts();
        clearInputs();
    }

    private void fillContacts() {
        contacts.clear();
        contacts.addAll(contactService.getAll());
    }

    private void clearInputs() {
        this.contactView.textFieldFirstName.setText("");
        this.contactView.textFieldLastName.setText("");
        this.contactView.textFieldEmail.setText("");
        this.contactView.textFieldPhoneNumber.setText("");
        this.contactView.textAreaAddress.setText("");
        this.contactView.textFieldWebAddress.setText("");
        this.contactView.textAreaNotes.setText("");
    }

}
