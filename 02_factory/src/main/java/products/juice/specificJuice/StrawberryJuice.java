class StrawberryJuice implements Juice {
  // protected double capacity;

  public StrawberryJuice() {
    peelFruit();
    squeezeFruit();
    addSomeFruitPulp();
    addSugar();
    stirJuice();
  }

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

  // public StrawberryJuice(double capacity) {
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
