class PolishFactory extends FactoryMethod {
  public FactoryMethod getInstance() {
    if (factory == null) {
      synchronized(FactoryMethod.class) {
        if (factory == null) {
          factory = new PolishFactory();
        }
      }
    }
    return factory;
  }

  protected Juice makeJuice(JuiceType type) {
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

  protected Beer makeBeer(BeerType type) {
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

  protected Tea makeTea(TeaType type) {
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
}
