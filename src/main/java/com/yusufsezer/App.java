package com.yusufsezer;

import com.yusufsezer.controller.ContactController;
import com.yusufsezer.model.ContactModel;
import com.yusufsezer.view.ContactView;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactModel contactModel = new ContactModel();
            ContactView contactView = new ContactView();
            ContactController calculatorController = new ContactController(contactModel, contactView);
            calculatorController.showGUI();
        });
    }
}
