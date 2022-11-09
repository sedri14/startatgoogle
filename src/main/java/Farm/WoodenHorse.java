package Farm;


class WoodenHorse implements WoodenStructures {
    @Override
    public void roll() {
        System.out.println("Wooden horse is rolling");
    }

    @Override
    public WoodenStructures replicate() {
        System.out.println("Wooden horse is replicating...");
        return null;
    }
}
