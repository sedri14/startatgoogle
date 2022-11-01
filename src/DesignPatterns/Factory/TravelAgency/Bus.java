package DesignPatterns.Factory.TravelAgency;

public class Bus implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " is using a bus");
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
