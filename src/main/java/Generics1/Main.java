package Generics1;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        WordGenerator wg = new WordGenerator("Java", "Python", "C++", "C", "Go", "C#", "Javascript", "Ruby");

        Callable<String> stringCallable = new Callable<>() {
            @Override
            public String call() throws Exception {
                return wg.generateRandomWord();
            }
        };
        Callable<Integer> integerCallable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                return ThreadLocalRandom.current().nextInt(10);
            }
        };
        Callable<Double> doubleCallable = new Callable<>() {
            @Override
            public Double call() throws Exception {
                return ThreadLocalRandom.current().nextDouble(100);
            }
        };


        Integer number = retry(integerCallable, 5, 10, 2000);
        String str = retryEverySecond(stringCallable, "Java", 5);
        Double d = fastRetryHundredTimes(doubleCallable, 2.5);

        System.out.println(number);
        System.out.println(str);
        System.out.println(d);
    }

    //it is better to do it with a while loop
    public static <T> T retry(Callable<T> action, T expectedResult, int retries, int sleepTime) {
        T result = null;

        try {
            for (int i = 0; i < retries; i++) {
                result = action.call();
                System.out.printf("Retry %d. Random generated result: %s\n", i, result);
            }
            if (result.equals(expectedResult)) {
                System.out.println("Hurray, expected result is found!" + result);
                return result;
            }
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            System.out.println("Error has occured");
            throw new RuntimeException(e);
        }
        System.out.println("All retries finished. returned value is: " + result);
        return (T) result;
    }

    public static <T> T retryEverySecond(Callable<T> action, T expectedResult, int retries) {
        return retry(action, expectedResult, retries, 1000);
    }

    public static <T> T fastRetryHundredTimes(Callable<T> action, T expectedResult) {
        return retry(action, expectedResult, 100, 100);
    }
}
