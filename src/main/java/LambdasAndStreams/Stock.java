package LambdasAndStreams;

import Generics1.WordGenerator;
import LambdasAndStreams.Utils.DateGenerator;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

public class Stock {

    private List<String> itemNamesBank = Arrays.asList("Milk", "Eggs", "Tomato", "Olive oil", "Flower", "Soy sauce", "Pasta", "Bamba", "Ice cream", "Jam", "Cerecal", "Bread", "Cake", "Pizza", "Butter", "Kethcup", "Salsa", "Carrots", "Peas", "Juice", "HotDog");
    private final List<Item> items;

    public Stock() {
        items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add(generateRandomItem());
        }
        sortItems();
    }

    //TODO- change to static factory method
    public Item generateRandomItem() {
        WordGenerator wg = new WordGenerator(itemNamesBank);
        Item.Type randType = Item.Type.values()[ThreadLocalRandom.current().nextInt(Item.Type.values().length)];
        LocalDate randDate = DateGenerator.randomDateInRange(LocalDate.of(2012, 1, 1), LocalDate.of(2028, 1, 1));
        double weight = ThreadLocalRandom.current().nextDouble(1, 500);
        return new Item(wg.generateRandomWord(), randType, randDate, weight);
    }

    private void sortItems() {
        Collections.sort(items);
    }

    public List<Item> getAllExpiredItems() {
        List<Item> expired = items.stream().filter(item -> item.getExpirationDate().isBefore(LocalDate.now())).collect(Collectors.toList());
        return expired;
    }

    public Optional<Item> getItemWithClosestExpiryDate() {
        Optional<Item> closentExpiry = items.stream().filter(item -> item.getExpirationDate().isAfter(LocalDate.now())).min(Item::compareTo);
        return Optional.of(closentExpiry).orElse(Optional.empty());
    }

    public List<Item> getItemsSortedByName() {
        List<Item> collect = items.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());
        return collect;
    }

    public Optional<Item> getItemByName(String name) {
        Optional<Item> result = items.stream().filter((item) -> item.getName().equals(name)).findFirst();
        return result;
    }

    public List<String> getNamesOfItemsAboveWeight(double weight) {
        if (weight < 0 ){
            throw new IllegalArgumentException();
        }
        List<String> namesAboveWeight = items.stream().filter(item -> item.getWeight() > weight).map(item -> item.getName()).collect(Collectors.toList());
        return namesAboveWeight;
    }

    public Map<Item.Type, Integer> getSumByTypeMap() {
        Map<Item.Type, Integer> map = items.stream().collect(Collectors.groupingBy(Item::getType, summingInt(x -> 1)));
        return map;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "items=\n" + items +
                '}';
    }
}
