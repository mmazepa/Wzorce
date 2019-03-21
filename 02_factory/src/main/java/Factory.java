import java.io.Serializable;

class Factory implements Serializable {
  private static Factory factory;

	private Factory() {
    	System.out.println("Factory(): Inicjalizowanie instacji.");
	}

	public static Factory getInstance() {
		if (factory == null) {
			synchronized(Factory.class) {
				if (factory == null) {
					System.out.println("getInstance(): Pierwsze wywołanie.");
					factory = new Factory();
				}
			}
		}
		return factory;
	}

  // makeJuice(...) nie jest open-close (!!!)
  public static Juice makeJuice (String fruit, double capacity) {
    if (fruit == "orange") return new OrangeJuice(fruit, capacity);
    else if (fruit == "strawberry") return new StrawberryJuice(fruit, capacity);
    else if (fruit == "kiwi") return new KiwiJuice(fruit, capacity);
    else if (fruit == "mango") return new MangoJuice(fruit, capacity);
    else if (fruit == "pomegranate") return new PomegranateJuice(fruit, capacity);
    return null;
  }

  // makeBeer(...) nie jest open-close (!!!)
  public static Beer makeBeer (String type, double capacity, double alcohol) {
    if (type == "lager") return new LagerBeer(type, capacity, alcohol);
    else if (type == "wheat") return new WheatBeer(type, capacity, alcohol);
    else if (type == "pilzner") return new PilznerBeer(type, capacity, alcohol);
    else if (type == "porter") return new PorterBeer(type, capacity, alcohol);
    else if (type == "stout") return new StoutBeer(type, capacity, alcohol);
    return null;
  }

  // makeTea(...) nie jest open-close (!!!)
  public static Tea makeTea (String taste, double capacity) {
    if (taste == "black") return new BlackTea(taste, capacity);
    else if (taste == "green") return new GreenTea(taste, capacity);
    else if (taste == "red") return new RedTea(taste, capacity);
    else if (taste == "white") return new WhiteTea(taste, capacity);
    else if (taste == "yellow") return new YellowTea(taste, capacity);
    return null;
  }

  protected Object readResolve() {
    if (factory == null) factory = this;
    return factory;
  }
}
