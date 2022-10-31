package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("Sharon", 88);
        Dog dog = new Dog("Alfred");

        Optional<Object> test1 =  newInstanceUsingStringConstructor(student); //without a fitting c'tor
        Optional<Object> test2 = newInstanceUsingStringConstructor(dog); //with a fitting c'tor

        System.out.println("Test 1: " + test1 + " is present:" + test1.isPresent());
        System.out.println("Test 2: " + test2 + " is present:" + test2.isPresent());
    }

    public static Optional<Object> newInstanceUsingStringConstructor(Object o) {
        Class<?> clazz = o.getClass();
        try {
            Constructor<?> constructor = clazz.getConstructor(String.class);
            Object newObj = constructor.newInstance(random_name(8));
            return Optional.of(newObj);
        } catch (NoSuchMethodException ex) {
            return Optional.empty();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static String random_name(int len) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
