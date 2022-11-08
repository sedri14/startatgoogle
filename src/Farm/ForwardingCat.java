package Farm;

import javax.naming.OperationNotSupportedException;

 class ForwardingCat extends AbstractAnimal {
    protected AbstractAnimal cat;

    public ForwardingCat() {
        super();
        this.cat = Cat.newRandomCat();
    }

    @Override
    public void move() {
        cat.move();
    }

    @Override
    public Animal mate(Animal partner) throws OperationNotSupportedException {
        return cat.mate(partner);
    }
}
