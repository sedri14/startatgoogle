package Methods.Logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class User {

    private final String name;
    private final List<Coupon> couponList;

    public User(String name) {
        this.name = name;
        this.couponList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public Optional<Coupon> getCouponById(int id) {
        for (Coupon coupon : couponList) {
            if (coupon.getId() == id)
                return Optional.of(coupon);
        }
        return Optional.empty();
    }

    public Optional<Coupon> getCouponByHighestValue() {
        //TODO - check if list empty and return empty
        Coupon highestCoupon = couponList.get(0);
        for (int i = 0; i < couponList.size(); i++) {
            Coupon currentCoupon = couponList.get(i);
            if (currentCoupon.getValue() > highestCoupon.getValue()) {
                highestCoupon = currentCoupon;
            }
        }
        return Optional.of(highestCoupon);
    }

    void assignCoupon(Coupon coupon) {
        this.couponList.add(coupon);
    }

    public void useCoupon(Coupon coupon) {
        System.out.printf("User %s is using coupon id %d. Coupon deleted", this, coupon.getId());
        couponList.remove(coupon);
    }

    public Optional<Coupon> getRandomCoupon() {
        int randIndex = ThreadLocalRandom.current().nextInt(0, couponList.size());
        return Optional.of(couponList.get(randIndex));
    }

    public Optional<Coupon> getCouponClosestExpiryDate() {
        Coupon closest = couponList.get(0);
        for (int i = 0; i < couponList.size(); i++) {
            Coupon currentCoupon = couponList.get(i);
            if (currentCoupon.getExpiryDate().isAfter(closest.getExpiryDate()) && currentCoupon.getExpiryDate().isBefore(LocalDate.now())) {
                closest = currentCoupon;
            }

        }
        return Optional.of(closest);
    }

    @Override
    public String toString() {
        return name + " (has " + couponList.size() + " coupons) ";
    }
}

