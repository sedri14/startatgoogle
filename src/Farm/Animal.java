package Farm;

import javax.naming.OperationNotSupportedException;

interface Animal {
    void move();

    Animal mate(Animal partner) throws OperationNotSupportedException;
}
