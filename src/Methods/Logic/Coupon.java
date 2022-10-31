package Methods.Logic;

import java.time.LocalDate;
import java.util.Date;

class Coupon {

    private final int id;
    private final LocalDate expiryDate;
    private final int value;

    public Coupon(int id, LocalDate expiryDate, int value) {
        //
        this.id = id;
        this.expiryDate = expiryDate;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", expiryDate=" + expiryDate +
                ", value=" + value +
                '}';
    }
}
