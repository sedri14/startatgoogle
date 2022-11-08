package Farm;

import javax.naming.OperationNotSupportedException;
import java.util.concurrent.ThreadLocalRandom;

class Cat extends AbstractAnimal{
     private Cat(Gender gender, int id, double weight) {
         super(gender, id, weight);
     }

     static Cat newRandomCat() {
         return new Cat(Gender.randGender(),AbstractAnimal.ID_INC++,ThreadLocalRandom.current().nextDouble(20.0));
     }

     @Override
     public void move() {
         System.out.println("Cat is moving...");
     }

     @Override
     public Animal mate(Animal partner) throws OperationNotSupportedException {
         if (partner instanceof Cat) {
             if (!((Cat)partner).getGender().equals(this.gender)) {
                 return new Cat(Gender.randGender(),AbstractAnimal.ID_INC++, ThreadLocalRandom.current().nextDouble());

             }
         }
         throw new OperationNotSupportedException("Can't mate");
     }

    @Override
    public String toString() {
        return "Cat{" +
                "gender=" + gender +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
