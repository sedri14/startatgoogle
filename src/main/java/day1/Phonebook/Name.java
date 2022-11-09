package day1.Phonebook;


import java.util.Objects;

public class Name implements Cloneable, Comparable<Name> {

    public enum Prefix{
        Mr,Mrs,Ms,Miss
    }

    private final Prefix prefix;
    private final String firstName;
    private final String lastName;

    public Name(Prefix prefix, String firstName, String lastName) {
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;

        Name name = (Name) o;

        if (prefix != name.prefix) return false;
        if (!Objects.equals(firstName, name.firstName)) return false;
        return Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        int result = prefix != null ? prefix.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Name{" +
                "prefix=" + prefix +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    protected Name clone() {
        try {
            Name clone = (Name)super.clone();
            return clone;
        }catch (CloneNotSupportedException e){
            System.out.printf("Clone name %s %s %s failed", prefix,firstName,lastName);
            return null;
        }
    }

    @Override
    public int compareTo(Name o) {
        //Compare lexicographically by last name and then first name
        int result = lastName.compareTo(o.lastName);
        if (result == 0) {
            return firstName.compareTo(o.firstName);
        } else {
            return result;
        }
    }
}
