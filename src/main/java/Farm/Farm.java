package Farm;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Farm {

    private List<Animal> farmAnimals;

    public Farm() {
        farmAnimals = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            try {
                farmAnimals.add(acquire());
            } catch (OperationNotSupportedException e) {
                System.out.println(e.getMessage() + " Animal not created.");
            }
        }
    }

    private Animal acquire() throws OperationNotSupportedException {
        AnimalType animalType = AnimalType.randType();
        Animal animal;
        switch (animalType) {
            case CAT:
                animal = Cat.newRandomCat();
                break;
            case DOG:
                animal = Dog.newRandomDog();
            break;
            case IMPALA:
                animal = Impala.newRandomImpala();
            break;
            default: throw new IllegalArgumentException("Invalid animal type");
        }
        return animal;
    }

     Animal provideAnimalByIndex(int index) {
        if (index > farmAnimals.size() || index < 0)
            throw new IndexOutOfBoundsException("Animal with index " + index + " does not exist");
        return farmAnimals.remove(index);
    }
}
