package DesignPatterns.Factory.TravelAgency;

import DesignPatterns.Factory.TravelAgency.Util.WordGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WordGenerator wg = new WordGenerator("David", "Moshe", "Yoni", "Sharon", "Tal", "Tzipi", "Lea", "Shlomi", "Or", "Nessi", "Oded", "Sapir", "Oren", "Ohad", "Shimrit", "Roni", "Billie");
        Agency agency = new Agency("Albar");
        List<Passenger> passengerList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            passengerList.add(new Passenger(wg.generateRandomWord(), VehicleType.getRandType()));
        }

        boolean transportCalled = false;
        for (Passenger passenger : passengerList) {
            agency.assignToVehicle(passenger);

            if(agency.isAvailableVehiclesEmpty() && !transportCalled) {
                agency.invokeTransport();
                transportCalled = true;
            }
        }

        System.out.println(agency.getAssignedVehicles());

    }
}
