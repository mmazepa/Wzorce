class KiwiJuice implements Juice {
  // protected double capacity;

  public KiwiJuice() {
    peelFruit();
    squeezeFruit();
    addSomeFruitPulp();
    addSugar();
    stirJuice();
  }

  @Override
  public void peelFruit() {
    System.out.println("Obieram kiwi...");
  }

  @Override
  public void squeezeFruit() {
    System.out.println("Wyciskam kiwi...");
  }

  @Override
  public void addSomeFruitPulp() {
    System.out.println("Dodaję odrobinę miąższu kiwi...");
  }

  @Override
  public void addSugar() {
    System.out.println("Dodaję cukier do soku z kiwi...");
  }

  @Override
  public void stirJuice() {
    System.out.println("Mieszam sok z kiwi...");
  }

  // public KiwiJuice(double capacity) {
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
