package day1.Phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    String name;
    List<Contact> contacts;

    public PhoneBook(String name, Contact...contacts) {
        this.name = name;
        this.contacts = new ArrayList<>();
        for (Contact contact: contacts) {
            this.contacts.add(contact);
        }
    }
}
