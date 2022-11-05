package DesignPatterns.Factory.TravelAgency;

class Passenger {

    private final String name;
    private VehicleType favoriteVehicleType;

    public Passenger(String name, VehicleType favoriteVehicleType) {
        this.name = name;
        this.favoriteVehicleType = favoriteVehicleType;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", favoriteVehicleType=" + favoriteVehicleType +
                '}';
    }

    public String getName() {
        return name;
    }

    public VehicleType getFavoriteVehicleType() {
        return favoriteVehicleType;
    }
}
