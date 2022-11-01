package DesignPatterns.Factory.TravelAgency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Agency {

    private final String name;
    private Map<VehicleType, List<Vehicle>> availableVehicles;
    private Map<Vehicle, Passenger> assignedVehicles;

    public Agency(String name) {
        this.name = name;
        availableVehicles = populateMotorPool(VehicleType.getVehicleCount());
        assignedVehicles = new HashMap();
    }

    public Map<VehicleType, List<Vehicle>> populateMotorPool(Map<VehicleType, Integer> amountByType) {

        VehicleFactory factory = new VehicleFactory();
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

    boolean assignToVehicle(Passenger passenger) {

        return true;
    }
}
