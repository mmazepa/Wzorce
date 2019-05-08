public class NorwegianFactory implements AbstractFactory {
  private static NorwegianFactory factory;

  private NorwegianFactory() { }

  public static NorwegianFactory getInstance() {
    if (factory == null) {
      synchronized (NorwegianFactory.class) {
        if (factory == null) {
          factory = new NorwegianFactory();
        }
      }
    }
    return factory;
  }

  public Water prepareWater() {
    return new RegularWater();
  }

  public Fruit prepareFruit() {
    return new OrangeFruit();
  }

  public Sugar prepareSugar() {
    return new WhiteSugar();
  }

  protected Drink createDrink(JuiceType type) {
    AbstractFactory factory = NorwegianFactory.getInstance();
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
