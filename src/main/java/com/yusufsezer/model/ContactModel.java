package com.yusufsezer.model;

import com.yusufsezer.contact.IRepository;

public class ContactModel {

    private final IRepository<Contact, Long> contactRepository;

    public ContactModel(IRepository<Contact, Long> contactRepository) {
        this.contactRepository = contactRepository;
    }

}
