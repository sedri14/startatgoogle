package LambdasAndStreams.Utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DateGenerator {

    private DateGenerator() {

    }

    public static LocalDate randomDateInRange(LocalDate start, LocalDate end) {
        long randDay = ThreadLocalRandom.current().nextLong(start.toEpochDay(), end.toEpochDay());
        return LocalDate.ofEpochDay(randDay);
    }

}
