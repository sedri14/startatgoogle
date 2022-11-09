package Methods.Client;

import Methods.Logic.Store;
import Methods.Logic.User;

public class Main {
    public static void main(String[] args) {

        Store store = new Store();
        User alex = new User("Alex");
        User sharon = new User("Sharon");

        store.assignRandomCoupons(alex);
        store.assignRandomCoupons(sharon);

        store.useCouponWithId(alex,10);
        store.useRandomCoupon(alex);
        store.useCouponWithClosestExpiryDate(alex);
        store.useCouponWithHighestValue(alex);

        store.useCouponWithId(sharon,5);
        store.useRandomCoupon(sharon);
        store.useCouponWithClosestExpiryDate(sharon);
        store.useCouponWithHighestValue(sharon);

    }
}
