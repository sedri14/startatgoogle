package day1.Phonebook;

import java.util.Objects;

public class Contact implements Cloneable, Comparable<Contact> {

    private final Name name;
    private final PhoneNumber phoneNumber;

    public Contact(Name name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (!Objects.equals(name, contact.name)) return false;
        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name=" + name +
                ", phoneNumber=" + phoneNumber +
                '}' + "\n";
    }

    @Override
    protected Contact clone() {
        try {
            Contact clone = (Contact) super.clone();
            return clone;

        } catch (CloneNotSupportedException e) {
            System.out.printf("Clone contact %s %s failed", name, phoneNumber);
            return null;
        }

    }

    @Override
    public int compareTo(Contact o) {
        int result = name.compareTo(o.name);
        if (result == 0) {
            return phoneNumber.compareTo(o.phoneNumber);
        } else {
            return result;
        }
    }
}
