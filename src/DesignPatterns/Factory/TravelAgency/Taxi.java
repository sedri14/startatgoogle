package DesignPatterns.Factory.TravelAgency;

public class Taxi implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " is using a taxi");
    }

    @Override
    public String toString() {
        return "Taxi";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
