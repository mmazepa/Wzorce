class PomegranateJuice implements Juice {
  protected String fruit;
  protected double capacity;

  public PomegranateJuice(String fruit, double capacity) {
    this.fruit = fruit;
    this.capacity = capacity;
  }

  public void getDetails() {
    System.out.println(fruit + " juice (capacity: " + capacity + " ml)");
  }

  public String getFruit() {
    return fruit;
  }

  public double getCapacity() {
    return capacity;
  }
}
