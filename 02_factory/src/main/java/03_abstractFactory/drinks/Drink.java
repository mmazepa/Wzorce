public abstract class Drink {
    JuiceType type;
    Water water;
    Fruit fruit;
    Sugar sugar;

    public JuiceType getType() {
        return type;
    }
    public void setType(JuiceType type) {
        this.type = type;
    }

    public Water getWater() {
        return water;
    }
    public void setWater(Water water) {
        this.water = water;
    }

    public Fruit getFruit() {
        return fruit;
    }
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Sugar getSugar() {
        return sugar;
    }
    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Drink: [" + water.getType() + ", " + fruit.getType() + ", " + sugar.getType() + "]";
    }
}
