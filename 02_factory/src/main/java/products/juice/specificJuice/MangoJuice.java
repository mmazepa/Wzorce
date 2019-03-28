class MangoJuice implements Juice {

  public MangoJuice() {}

  @Override
  public void peelFruit() {
    System.out.println("Obieram mango...");
  }

  @Override
  public void squeezeFruit() {
    System.out.println("Wyciskam mango...");
  }

  @Override
  public void addSomeFruitPulp() {
    System.out.println("Dodaję odrobinę miąższu mango...");
  }

  @Override
  public void addSugar() {
    System.out.println("Dodaję cukier do soku z mango...");
  }

  @Override
  public void stirJuice() {
    System.out.println("Mieszam sok z mango...");
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
