class MangoJuice implements Juice {
  // protected double capacity;

  public MangoJuice() {
    peelFruit();
    squeezeFruit();
    addSomeFruitPulp();
    addSugar();
    stirJuice();
  }

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

  // public MangoJuice(double capacity) {
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
