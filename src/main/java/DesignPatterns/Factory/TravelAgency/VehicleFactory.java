package DesignPatterns.Factory.TravelAgency;

public class VehicleFactory {
    private static VehicleFactory instance;

    public static VehicleFactory getInstance() {
        if (instance == null) {
            instance = new VehicleFactory();
        }

        return instance;
    }

    private VehicleFactory() {
    }

    public Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case BUS:
                return new Bus();
            case TAXI:
                return new Taxi();
            case BOAT:
                return new Boat();
            case PLANE:
                return new Plane();
            default:
                try {
                    throw new IllegalAccessException(String.format("Vehicle type not supported: %s", type));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e.getMessage());
                }
        }
    }
}
