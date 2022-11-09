package LambdasAndStreams;

import java.time.LocalDate;


public class Item implements Comparable<Item>{

    public enum Type{
    BAKERY,BEVERAGE,DELI,MEAT
    }

    private final String name;
    private final Type type;
    private final LocalDate expirationDate;
    private final double weight;

    public Item(String name, Type type, LocalDate expirationDate, double weight) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public int compareTo(Item o) {
        return this.expirationDate.compareTo(o.expirationDate);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", expirationDate=" + expirationDate +
                ", weight=" + weight +
                '}'+'\n';
    }
}
