class PomegranateJuice implements Juice {

  public PomegranateJuice() {}

  @Override
  public void peelFruit() {
    System.out.println("Obieram granaty...");
  }

  @Override
  public void squeezeFruit() {
    System.out.println("Wyciskam granaty...");
  }

  @Override
  public void addSomeFruitPulp() {
    System.out.println("Dodaję odrobinę miąższu granatów...");
  }

  @Override
  public void addSugar() {
    System.out.println("Dodaję cukier do soku z granatów...");
  }

  @Override
  public void stirJuice() {
    System.out.println("Mieszam sok z granatów...");
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
