package DesignPatterns.Factory.TravelAgency;

import java.util.HashMap;
import java.util.Map;

public enum VehicleType {
    BUS(4), TAXI(8), BOAT(3), PLANE(1);

    public int count;

    VehicleType(int count) {
        this.count = count;
    }

    public static Map<VehicleType,Integer> getVehicleCount(){
        Map<VehicleType,Integer> amountByType = new HashMap<>();
        amountByType.put(VehicleType.BUS,VehicleType.BUS.count);
        amountByType.put(VehicleType.TAXI,VehicleType.TAXI.count);
        amountByType.put(VehicleType.BOAT,VehicleType.BOAT.count);
        amountByType.put(VehicleType.PLANE,VehicleType.PLANE.count);

        return amountByType;
    }
    //public static VehicleType getRandType();
    }
