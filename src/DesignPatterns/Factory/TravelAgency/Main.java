package DesignPatterns.Factory.TravelAgency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        final String names[] = {"ddv", "fvdrv", "4654", "vdfjvjrt", "gdfgbsdr","bsrtbrtsb"};
        Agency agency = new Agency("Albar");
        List<Passenger> passengerList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
        passengerList.add(new Passenger(names[ThreadLocalRandom.current().nextInt(names.length-1)],VehicleType.getRandType()));
        }

        for (Passenger passenger: passengerList) {
            agency.assignToVehicle(passenger);
        }

        System.out.println(agency.getAssignedVehicles());

    }
}
