import java.io.Serializable;

class SimpleFactory implements Serializable {
  private static SimpleFactory factory;

	private SimpleFactory() {}

	public static SimpleFactory getInstance() {
		if (factory == null) {
			synchronized(SimpleFactory.class) {
				if (factory == null) {
					factory = new SimpleFactory();
				}
			}
		}
		return factory;
	}

  public static Juice makeJuice(JuiceType type) {
    switch (type) {
      case KIWI:
        return new KiwiJuice();
      case MANGO:
        return new MangoJuice();
      case ORANGE:
        return new OrangeJuice();
      case POMEGRANATE:
        return new PomegranateJuice();
      case STRAWBERRY:
        return new StrawberryJuice();
      default:
        return null;
    }
  }

  public static Beer makeBeer(BeerType type) {
    switch (type) {
      case LAGER:
        return new LagerBeer();
      case PILZNER:
        return new PilznerBeer();
      case PORTER:
        return new PorterBeer();
      case STOUT:
        return new StoutBeer();
      case WHEAT:
        return new WheatBeer();
      default:
        return null;
    }
  }

  public static Tea makeTea(TeaType type) {
    switch (type) {
      case BLACK:
        return new BlackTea();
      case GREEN:
        return new GreenTea();
      case RED:
        return new RedTea();
      case WHITE:
        return new WhiteTea();
      case YELLOW:
        return new YellowTea();
      default:
        return null;
    }
  }

  protected Object readResolve() {
    factory = this;
    return factory;
  }
}
