package DesignPatterns.Factory.TravelAgency;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Agency {

    private final String name;
    private Map<VehicleType, List<Vehicle>> availableVehicles;
    private Map<Vehicle, Passenger> assignedVehicles;

    public Agency(String name) {
        this.name = name;
        availableVehicles = populateMotorPool(VehicleType.getVehicleCount());
        assignedVehicles = new HashMap();
    }

    public Map<Vehicle, Passenger> getAssignedVehicles() {
        return assignedVehicles;
    }

    public Map<VehicleType, List<Vehicle>> populateMotorPool(Map<VehicleType, Integer> amountByType) {

        VehicleFactory factory = VehicleFactory.getInstance();
        Map<VehicleType, List<Vehicle>> generatedVehicles = new HashMap<>();

        for (Map.Entry<VehicleType, Integer> entry : amountByType.entrySet()) {
            VehicleType type = entry.getKey();
            List<Vehicle> vehiclesOfType = new ArrayList<>();
            for (int i = 0; i < entry.getValue(); i++) {
                vehiclesOfType.add(factory.createVehicle(type));
            }
            generatedVehicles.put(type, vehiclesOfType);
        }

        return generatedVehicles;
    }

    void assignToVehicle(Passenger passenger) {
        VehicleType favoriteType = passenger.getFavoriteVehicleType();

        if (availableVehicles.containsKey(favoriteType)) {
            int listSize = availableVehicles.get(favoriteType).size();
            if (listSize > 0) {
                Vehicle vehicle = availableVehicles.get(favoriteType).remove(listSize - 1);
                assignedVehicles.put(vehicle, passenger);
            } else {
                assignRandomType(passenger);
            }
        } else {
            throw new IllegalArgumentException(("Illegal choice of type. Please go to another agency."));
        }
    }

    private void assignRandomType(Passenger passenger) {
        if (isEmpty(availableVehicles)) {
            System.out.println("We're sorry. No vehicles left for you");
        }

        List<VehicleType> types = Arrays.asList(VehicleType.values());
        VehicleType randType = types.get(ThreadLocalRandom.current().nextInt(types.size()-1));
        while (availableVehicles.get(randType).isEmpty()) {
            types.remove(randType);
            randType = types.get(ThreadLocalRandom.current().nextInt(types.size()-1));
        }

        int listSize = availableVehicles.get(randType).size();
        Vehicle vehicle = availableVehicles.get(randType).remove(listSize - 1);
        assignedVehicles.put(vehicle, passenger);
    }

    private boolean isEmpty(Map<VehicleType, List<Vehicle>> availableVehicles) {
        for (Map.Entry<VehicleType, List<Vehicle>> entry : availableVehicles.entrySet()) {
            if (!entry.getValue().isEmpty())
                return false;
        }
        return true;
    }
}
