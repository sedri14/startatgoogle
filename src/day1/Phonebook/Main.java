package day1.Phonebook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Contact sharon = new Contact(new Name(Name.Prefix.Ms,"Sharon", "Edri"), new PhoneNumber("03","6131348"));
        Contact bar = new Contact(new Name(Name.Prefix.Mrs,"Bar", "Cohen"), new PhoneNumber("052","6544321"));
        Contact avi = new Contact(new Name(Name.Prefix.Mr,"Avi", "Cohen"), new PhoneNumber("052","8900498"));
        Contact avi1 = new Contact(new Name(Name.Prefix.Mr,"Avi", "Cohen"), new PhoneNumber("052","8900498"));
        Contact moshe = new Contact(new Name(Name.Prefix.Mr,"Moshe", "Ron"), new PhoneNumber("053","7688345"));

        System.out.println(avi.equals(avi1));
        System.out.println(avi.equals(sharon));
        Contact sharonClone = sharon.clone();
        System.out.println(sharonClone);

        List<Contact> contacts = createListOfContacts(sharon,bar,avi,avi1,moshe);
        Collections.sort(contacts);
        System.out.println("Sorted list of contacts: " + contacts);

        PhoneBook phonebook1 = new PhoneBook("Yellow Pages", sharon,avi,moshe);

        Map<Name,PhoneNumber> contactsById = createMapOfContactsByIds(contacts);
        System.out.println("Contacts map: " + contactsById);
    }

    private static Map<Name,PhoneNumber> createMapOfContactsByIds(List<Contact> contactsList) {
        Map<Name,PhoneNumber> map = new HashMap<>();
        for (Contact contact: contactsList) {
            map.put(contact.getName(),contact.getPhoneNumber());
        }

        return map;
    }

    public static List<Contact> createListOfContacts (Contact...contacts) {
        List<Contact> list = new ArrayList<>();
        for (Contact contact: contacts) {
            list.add(contact);
        }

        return list;
    }
}
