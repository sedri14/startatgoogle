package Farm;

import javax.naming.OperationNotSupportedException;
import java.util.concurrent.ThreadLocalRandom;

class Dog extends AbstractAnimal{

     private Dog(Gender gender, int id, double weight) {
         super(gender, id, weight);
     }

     static Dog newRandomDog(){
         return new Dog(Gender.randGender(),AbstractAnimal.ID_INC++,ThreadLocalRandom.current().nextDouble(20.0));
     }

     @Override
     public void move() {
         System.out.println("Dog is moving...");
     }

    @Override
    public Animal mate(Animal partner) throws OperationNotSupportedException {
        if (partner instanceof Dog) {
            if (!((Dog) partner).getGender().equals(this.gender)) {
                return new Dog(Gender.randGender(),AbstractAnimal.ID_INC++, ThreadLocalRandom.current().nextDouble());
            }
        }
        throw new OperationNotSupportedException("Can't mate");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "gender=" + gender +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
