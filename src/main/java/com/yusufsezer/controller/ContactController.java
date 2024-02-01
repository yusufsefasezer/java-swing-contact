package com.yusufsezer.controller;

import com.yusufsezer.model.ContactModel;
import com.yusufsezer.view.ContactView;

public class ContactController {

    private final ContactModel contactModel;
    private final ContactView contactView;

    public ContactController(ContactModel contactModel, ContactView contactView) {
        this.contactModel = contactModel;
        this.contactView = contactView;
    }

    public void showGUI() {
        contactView.setVisible(true);
    }

}
