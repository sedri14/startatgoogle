package DesignPatterns.Factory.TravelAgency.Util;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordGenerator {
    private List<String> words;

    public WordGenerator(List<String> words) {
        this.words = words;
    }

    public WordGenerator(String... words) {

        this.words = new ArrayList<>();
        for (String word : words) {
            this.words.add(word);
        }
    }

    public String generateRandomWord() {
        return words.get(ThreadLocalRandom.current().nextInt(0, words.size()));
    }
}
