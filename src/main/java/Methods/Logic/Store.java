package Methods.Logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Store {

    private static Logger logger = LogManager.getLogger(Store.class.getName());

    public static Coupon generateRandomCoupon() {
        logger.trace("Trace logger print");
        return new Coupon(ThreadLocalRandom.current().nextInt(10000), RandomLocalDate.generateNumberRandomDateInBounds(), ThreadLocalRandom.current().nextInt(1, 101));
    }

    private void assignCouponToUser(User user, Coupon coupon) {
        user.assignCoupon(coupon);
        logger.info("Info logger print");

    }

    public void useCouponWithId(User user, int id) {
        if (user.getCouponById(id).isPresent()) {
            Coupon coupon = user.getCouponById(id).get();
            if (!isExpired(coupon)) {
                user.useCoupon(coupon);
            }
            else {
                logger.error(String.format("Coupon with id %d is expired\n", id));
                System.out.printf("Coupon with id %d is expired\n", id);
            }
        } else {
            logger.error(String.format("Coupon with id %d is not found.\n", id));
            System.out.printf("Coupon with id %d is not found.\n", id);
        }
    }

    //TODO- to use with comparable.
    public void useCouponWithHighestValue(User user) {
        if (user.getCouponByHighestValue().isPresent()) {
            Coupon highestCoupon = user.getCouponByHighestValue().get();
            if (!isExpired(highestCoupon)) {
                user.useCoupon(highestCoupon);
            } else {
                logger.fatal("highest value coupon is expired");
                System.out.println("Sorry, highest value coupon is expired");
            }
        } else {
            logger.fatal("coupons list is empty");
            System.out.println("Sorry, coupons list is empty");
        }
    }

    public void useCouponWithClosestExpiryDate(User user) {
        if (user.getCouponClosestExpiryDate().isPresent()) {
            Coupon closest = user.getCouponClosestExpiryDate().get();
            user.useCoupon(closest);
            logger.warn("Warn logger print");
        } else {
            System.out.println("Sorry, List is empty or all coupons are expired");
        }

    }

    public void useRandomCoupon(User user) {
        logger.debug("this is a debug print int Level:500");
        if (user.getRandomCoupon().isPresent()) {
            System.out.println("about to choose a random coupon");
            Coupon random = user.getRandomCoupon().get();
            if (!isExpired(random)) {
                user.useCoupon(random);
            }
            else {
                System.out.println("Sorry, this random coupon is expired");
            }

        } else {
            System.out.printf("Sorry, coupons list is empty");
        }

    }

    public void assignRandomCoupons(User user) {
        for (int i = 0; i < 10; i++) {
            assignCouponToUser(user, generateRandomCoupon());
        }
    }

    private boolean isExpired(Coupon coupon) {
        return !LocalDate.now().isBefore(coupon.getExpiryDate());
    }
}
