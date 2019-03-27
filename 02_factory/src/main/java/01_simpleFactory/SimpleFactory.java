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
    if (type == "orange") return new OrangeJuice();
    else if (type == "strawberry") return new StrawberryJuice();
    else if (type == "kiwi") return new KiwiJuice();
    else if (type == "mango") return new MangoJuice();
    else if (type == "pomegranate") return new PomegranateJuice();
    else return null;
  }

  public static Beer makeBeer (String type) {
    if (type == "lager") return new LagerBeer();
    else if (type == "wheat") return new WheatBeer();
    else if (type == "pilzner") return new PilznerBeer();
    else if (type == "porter") return new PorterBeer();
    else if (type == "stout") return new StoutBeer();
    else return null;
  }

  public static Tea makeTea (String type) {
    if (type == "black") return new BlackTea();
    else if (type == "green") return new GreenTea();
    else if (type == "red") return new RedTea();
    else if (type == "white") return new WhiteTea();
    else if (type == "yellow") return new YellowTea();
    return null;
  }

  protected Object readResolve() {
    factory = this;
    return factory;
  }
}
