class StrawberryJuice implements Juice {

  public StrawberryJuice() {}

  @Override
  public void peelFruit() {
    System.out.println("Obieram truskawki...");
  }

  @Override
  public void squeezeFruit() {
    System.out.println("Wyciskam truskawki...");
  }

  @Override
  public void addSomeFruitPulp() {
    System.out.println("Dodaję odrobinę miąższu truskawek...");
  }

  @Override
  public void addSugar() {
    System.out.println("Dodaję cukier do soku z truskawek...");
  }

  @Override
  public void stirJuice() {
    System.out.println("Mieszam sok z truskawek...");
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
