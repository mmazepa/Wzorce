public class SwedishFactory implements AbstractFactory {
  private static SwedishFactory factory;

  private SwedishFactory() { }

  public static SwedishFactory getInstance() {
    if (factory == null) {
      synchronized (SwedishFactory.class) {
        if (factory == null) {
          factory = new SwedishFactory();
        }
      }
    }
    return factory;
  }

  public Water prepareWater() {
    return new CarbonatedWater();
  }

  public Fruit prepareFruit() {
    return new KiwiFruit();
  }

  public Sugar prepareSugar() {
    return new BrownSugar();
  }

  protected Drink createDrink(JuiceType type) {
    AbstractFactory factory = SwedishFactory.getInstance();
    switch (type) {
      case KIWI:
        return new MorningDrink(factory);
      case ORANGE:
        return new AfternoonDrink(factory);
      default:
        return null;
    }
  }
}
