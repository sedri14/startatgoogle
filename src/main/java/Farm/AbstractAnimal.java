package Farm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

abstract class AbstractAnimal implements Animal{

    protected static int ID_INC = 0;
    protected Gender gender;
    protected int id;
    protected double weight;

    public AbstractAnimal() {

    }
    public AbstractAnimal(Gender gender, int id, double weight) {
        this.gender = gender;
        this.id = id = ID_INC++;
        this.weight = weight;
    }
    public Gender getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractAnimal)) return false;

        AbstractAnimal that = (AbstractAnimal) o;

        if (id != that.id) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        return gender == that.gender;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = gender != null ? gender.hashCode() : 0;
        result = 31 * result + id;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
