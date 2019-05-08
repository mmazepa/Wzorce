public class AfternoonDrink extends Drink {
    AbstractFactory factory;

    public AfternoonDrink(AbstractFactory factory) {
      this.factory = factory;
      this.type = JuiceType.KIWI;
      prepareIngredients();
    }

    public void prepareIngredients() {
      this.water = factory.prepareWater();
      this.fruit = factory.prepareFruit();
      this.sugar = factory.prepareSugar();
    }
}
