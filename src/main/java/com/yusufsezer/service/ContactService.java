package com.yusufsezer.service;

import com.yusufsezer.model.Contact;
import com.yusufsezer.repository.ObjectRepository;
import java.util.List;

public class ContactService {

    private final ObjectRepository<Contact, Long> contactRepository;

    public ContactService(ObjectRepository<Contact, Long> contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean create(Contact contact) {
        return contactRepository.add(contact);
    }

    public List<Contact> getAll() {
        return contactRepository.getAll();
    }

    public void update(Long id, Contact contact) {
        contactRepository.update(id, contact);
    }

    public Contact delete(Long id) {
        return contactRepository.remove(id);
    }

    public boolean save() {
        return contactRepository.save();
    }

}
