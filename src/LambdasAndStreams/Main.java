package LambdasAndStreams;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Stock stock = new Stock();
        System.out.println("All stock items:");
        System.out.println(stock);

        List<Item> allExpiredItems = stock.getAllExpiredItems();
        System.out.println("All expired items:");
        System.out.println(allExpiredItems);

        System.out.println("The item with the closest expiry date:");
        Optional<Item> itemWithClosestExpiryDate = stock.getItemWithClosestExpiryDate();
        if (itemWithClosestExpiryDate.isPresent()) {
            Item item = stock.getItemWithClosestExpiryDate().get();
            System.out.println(item);
        } else {
            System.out.println("Item not found");
        }

        List<Item> itemsSortedByName = stock.getItemsSortedByName();
        System.out.println("All stock items sorted by name:");
        System.out.println(itemsSortedByName);

        String itemToSearch = "Milk";
        System.out.println("Find an item " + itemToSearch + ":");
        Optional<Item> itemByName = stock.getItemByName(itemToSearch);
        if (itemByName.isPresent()) {
            Item item = stock.getItemByName(itemToSearch).get();
            System.out.println(item);
        } else {
            System.out.println("Item not found");
        }

        long minWeight = 200;
        System.out.println("Names of items that are above " + minWeight + ":");
        List<String> namesOfItemsAboveWeight = stock.getNamesOfItemsAboveWeight(minWeight);
        System.out.println(namesOfItemsAboveWeight);

        Map<Item.Type, Integer> sumByTypeMap = stock.getSumByTypeMap();
        System.out.println("Map of occurency of each item type:");
        System.out.println(sumByTypeMap);
    }
}
