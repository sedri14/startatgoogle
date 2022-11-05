package DesignPatterns.Builder;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        JobPosition jp = new JobPosition.Builder(LocalDate.of(2022, 5, 14), "Java developer", true, 2).description("Descrtiption of java developer job").salaryCap(15000.567).build();
        System.out.println(jp);
    }
}
