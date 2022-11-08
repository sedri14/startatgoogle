package Farm;

import javax.naming.OperationNotSupportedException;
import java.util.concurrent.ThreadLocalRandom;

class Impala extends AbstractAnimal{
     public Impala(Gender gender, int id, double weight) {
         super(gender, id, weight);
     }

     static Impala newRandomImpala(){
         return new Impala(Gender.randGender(),AbstractAnimal.ID_INC++,ThreadLocalRandom.current().nextDouble(20.0));
     }

     @Override
     public void move() {
         System.out.println("Impala is moving...");
     }

    @Override
    public Animal mate(Animal partner) throws OperationNotSupportedException {
        if (partner instanceof Impala) {
            if (((Impala) partner).getGender().equals(this.gender)) {
                return new Impala(Gender.randGender(),AbstractAnimal.ID_INC++, ThreadLocalRandom.current().nextDouble());

            }
        }
        throw new OperationNotSupportedException("Can't mate");
    }

    @Override
    public String toString() {
        return "Impala{" +
                "gender=" + gender +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
