package day1.Classes;

public class City {

    private final String name;
    private final String country;
    private final long population;

    private static City telAviv;

    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public static City getTelAviv() {
        if (telAviv == null) {
            telAviv = new City("Tel Aviv", "Israel", 9000000);
        }
        return telAviv;
    }
}
