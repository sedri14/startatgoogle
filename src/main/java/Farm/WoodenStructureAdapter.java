package Farm;

import javax.naming.OperationNotSupportedException;

class WoodenStructureAdapter implements Animal {

    WoodenStructures woodenStructure;

    public WoodenStructureAdapter(WoodenStructures woodenStructure) {
        this.woodenStructure = woodenStructure;
    }

    public WoodenStructureAdapter toWoodenStructureAdapter(WoodenStructures woodenStructures) {
        return new WoodenStructureAdapter(woodenStructures);
    }

    @Override
    public void move() {
        woodenStructure.roll();
    }

    @Override
    public Animal mate(Animal partner) throws OperationNotSupportedException {

        if (!(partner instanceof WoodenStructureAdapter)) {
            throw new IllegalArgumentException("Can't mate");
        }

        return toWoodenStructureAdapter(woodenStructure.replicate());
    }
}
