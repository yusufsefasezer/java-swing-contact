package com.yusufsezer.model;

import java.io.Serializable;

public class Contact<Long> extends BaseModel<Long> implements Serializable {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected String address;
    protected String webAddress;
    protected String notes;

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static Contact of(String firstName, String lastName,
            String email, String phoneNumber, String address,
            String webAddress, String notes) {
        var newContact = new Contact<>();
        newContact.setFirstName(firstName);
        newContact.setLastName(lastName);
        newContact.setEmail(email);
        newContact.setPhoneNumber(phoneNumber);
        newContact.setAddress(address);
        newContact.setWebAddress(webAddress);
        newContact.setNotes(notes);
        return newContact;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
