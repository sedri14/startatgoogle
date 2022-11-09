package DesignPatterns.Factory.TravelAgency;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Agency {

    private final String name;
    private Map<VehicleType, List<Vehicle>> availableVehicles;
    private Map<Vehicle, Passenger> assignedVehicles;
    List<VehicleType> typesPool;


    public Agency(String name) {
        this.name = name;
        availableVehicles = populateMotorPool(VehicleType.getVehicleCount());
        assignedVehicles = new HashMap();
        typesPool = new ArrayList<>(Arrays.asList(VehicleType.values()));
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
                assignRandomType(passenger,typesPool);
            }
        } else {
            throw new IllegalArgumentException(("Illegal choice of type. Please go to another agency."));
        }
    }

    private void assignRandomType(Passenger passenger, List<VehicleType> types) {
        if (isAvailableVehiclesEmpty()) {
            System.out.println("We're sorry. No vehicles left for you");

            return;
        }

        VehicleType randType = types.get(ThreadLocalRandom.current().nextInt(types.size()));
        List<Vehicle> listOfType = availableVehicles.get(randType);
        while (listOfType.isEmpty()){
            types.remove(randType);
            randType = types.get(ThreadLocalRandom.current().nextInt(types.size()));
            listOfType = availableVehicles.get(randType);
        }
        Vehicle vehicle = listOfType.remove(listOfType.size() - 1);
        assignedVehicles.put(vehicle, passenger);
    }

    public boolean isAvailableVehiclesEmpty() {
        for (Map.Entry<VehicleType, List<Vehicle>> entry : availableVehicles.entrySet()) {
            if (!entry.getValue().isEmpty())
                return false;
        }
        return true;
    }

    public void invokeTransport() {
        System.out.println("Invoke transport");
        for (Map.Entry<Vehicle,Passenger> entry: assignedVehicles.entrySet()){
            entry.getKey().transport(entry.getValue());
        }
    }
}
