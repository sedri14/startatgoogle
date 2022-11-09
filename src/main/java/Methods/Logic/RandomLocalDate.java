package Methods.Logic;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

class RandomLocalDate {

    private RandomLocalDate() {

    }

     public static LocalDate generateNumberRandomDateInBounds() {
        int year = ThreadLocalRandom.current().nextInt(2019,2031);
        int month = ThreadLocalRandom.current().nextInt(1,13);
        int day = ThreadLocalRandom.current().nextInt(1,28);

        return LocalDate.of(year,month,day);
    }
}
