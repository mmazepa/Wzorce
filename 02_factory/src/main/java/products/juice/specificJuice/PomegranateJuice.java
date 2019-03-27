class PomegranateJuice implements Juice {
  // protected double capacity;

  public PomegranateJuice() {
    peelFruit();
    squeezeFruit();
    addSomeFruitPulp();
    addSugar();
    stirJuice();
  }

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

  // public PomegranateJuice(double capacity) {
  //   this.capacity = capacity;
  // }
  //
  // public void setCapacity() {
  //   this.capacity = capacity;
  // }
  // public double getCapacity() {
  //   return capacity;
  // }
}
