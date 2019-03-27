import java.io.Serializable;

class SimpleFactory implements Serializable {
  private static SimpleFactory factory;

	private SimpleFactory() {
    	System.out.println("SimpleFactory(): Inicjalizowanie instacji.");
	}

	public static SimpleFactory getInstance() {
		if (factory == null) {
			synchronized(SimpleFactory.class) {
				if (factory == null) {
					System.out.println("getInstance(): Pierwsze wywołanie.");
					factory = new SimpleFactory();
				}
			}
		}
		return factory;
	}

  public static Juice makeJuice (String type) {
    if (type.equals("orange")) return new OrangeJuice();
    else if (type.equals("strawberry")) return new StrawberryJuice();
    else if (type.equals("kiwi")) return new KiwiJuice();
    else if (type.equals("mango")) return new MangoJuice();
    else if (type.equals("pomegranate")) return new PomegranateJuice();
    else return null;
  }

  public static Beer makeBeer (String type) {
    if (type.equals("lager")) return new LagerBeer();
    else if (type.equals("wheat")) return new WheatBeer();
    else if (type.equals("pilzner")) return new PilznerBeer();
    else if (type.equals("porter")) return new PorterBeer();
    else if (type.equals("stout")) return new StoutBeer();
    else return null;
  }

  public static Tea makeTea (String type) {
    if (type.equals("black")) return new BlackTea();
    else if (type.equals("green")) return new GreenTea();
    else if (type.equals("red")) return new RedTea();
    else if (type.equals("white")) return new WhiteTea();
    else if (type.equals("yellow")) return new YellowTea();
    return null;
  }

  protected Object readResolve() {
    factory = this;
    return factory;
  }
}
