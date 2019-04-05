class OrangeJuice implements Juice {

  public OrangeJuice() {}

  @Override
  public void peelFruit() {
    System.out.println("Obieram pomarańcze...");
  }

  @Override
  public void squeezeFruit() {
    System.out.println("Wyciskam pomarańcze...");
  }

  @Override
  public void addSomeFruitPulp() {
    System.out.println("Dodaję odrobinę miąższu pomarańczy...");
  }

  @Override
  public void addSugar() {
    System.out.println("Dodaję cukier do soku z pomarańczy...");
  }

  @Override
  public void stirJuice() {
    System.out.println("Mieszam sok z pomarańczy...");
  }

  @Override
  public void prepare() {
    peelFruit();
    squeezeFruit();
    addSomeFruitPulp();
    addSugar();
    stirJuice();
  }
}
