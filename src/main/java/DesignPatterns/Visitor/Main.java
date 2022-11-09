package DesignPatterns.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BusinessType> types = new ArrayList<>();
        types.add(new User(1, "Moshe", "123456"));
        types.add(new Asset(147, "Sharon", 2.5));
        types.add(new Group(3, 500));

        ExportToJsonVisitor exportToJson = new ExportToJsonVisitor();
        for (BusinessType type : types) {
            System.out.println("Exporting " + type.getClass().getSimpleName() + " to Json format:");
            System.out.println(type.accept(exportToJson));
        }
    }

}