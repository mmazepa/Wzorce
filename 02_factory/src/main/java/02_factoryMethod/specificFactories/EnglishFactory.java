class EnglishFactory extends FactoryMethod {
  protected Juice makeJuice(String type) {
    if (type.equals("orange")) return new OrangeJuice();
    else if (type.equals("strawberry")) return new StrawberryJuice();
    else if (type.equals("kiwi")) return new KiwiJuice();
    else if (type.equals("mango")) return new MangoJuice();
    else if (type.equals("pomegranate")) return new PomegranateJuice();
    else return null;
	}

  protected Beer makeBeer(String type) {
    if (type.equals("lager")) return new LagerBeer();
    else if (type.equals("wheat")) return new WheatBeer();
    else if (type.equals("pilzner")) return new PilznerBeer();
    else if (type.equals("porter")) return new PorterBeer();
    else if (type.equals("stout")) return new StoutBeer();
    else return null;
  }

  protected Tea makeTea(String type) {
    if (type.equals("black")) return new BlackTea();
    else if (type.equals("green")) return new GreenTea();
    else if (type.equals("red")) return new RedTea();
    else if (type.equals("white")) return new WhiteTea();
    else if (type.equals("yellow")) return new YellowTea();
    else return null;
	}
}
