package DesignPatterns.Visitor;

class Group implements BusinessType {

    private int id;
    private int size;

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
