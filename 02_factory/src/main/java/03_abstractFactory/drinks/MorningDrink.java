public class MorningDrink extends Drink {
    AbstractFactory factory;

    public MorningDrink(AbstractFactory factory) {
      this.factory = factory;
      this.type = JuiceType.ORANGE;
      prepareIngredients();
    }

    public void prepareIngredients() {
      this.water = factory.prepareWater();
      this.fruit = factory.prepareFruit();
      this.sugar = factory.prepareSugar();
    }
}
