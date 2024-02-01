package com.yusufsezer;

import com.yusufsezer.controller.ContactController;
import com.yusufsezer.model.Contact;
import com.yusufsezer.repository.ObjectRepository;
import com.yusufsezer.service.ContactService;
import com.yusufsezer.view.ContactView;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            String contactFile = "contacts.dat";

            var contactRepository = new ObjectRepository<Contact, Long>(contactFile);
            ContactService contactModel = new ContactService(contactRepository);
            ContactView contactView = new ContactView();
            ContactController calculatorController = new ContactController(contactModel, contactView);
            calculatorController.showGUI();

        });
    }
}
