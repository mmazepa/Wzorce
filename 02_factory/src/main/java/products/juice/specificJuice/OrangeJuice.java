class OrangeJuice implements Juice {
  // protected double capacity;

  public OrangeJuice() {
    peelFruit();
    squeezeFruit();
    addSomeFruitPulp();
    addSugar();
    stirJuice();
  }

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

  // public OrangeJuice(double capacity) {
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
