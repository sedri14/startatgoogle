package DesignPatterns.Factory.TravelAgency;

public class Plane implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " is using the plane");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
