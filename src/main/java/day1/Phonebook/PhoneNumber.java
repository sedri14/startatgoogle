package day1.Phonebook;

import java.util.Objects;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    private final String areaCode;
    private final String number;

    public PhoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (!Objects.equals(areaCode, that.areaCode)) return false;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        int result = areaCode != null ? areaCode.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode='" + areaCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    protected PhoneNumber clone() {
        try {
            PhoneNumber clone = (PhoneNumber) super.clone();
            return clone;

        } catch (CloneNotSupportedException e) {
            System.out.printf("Clone phone number %s-%s failed", areaCode, number);
            return null;
        }
    }

    //TODO- how to compare phone numbers?
    @Override
    public int compareTo(PhoneNumber o) {
    return 0;
    }
}
