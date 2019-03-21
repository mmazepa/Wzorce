class RedTea implements Tea {
  protected String taste;
  protected double capacity;

  public RedTea(String taste, double capacity) {
    this.taste = taste;
    this.capacity = capacity;
  }

  public void getDetails() {
    System.out.println(taste + " tea (capacity: " + capacity + " ml)");
  }

  public String getTaste() {
    return taste;
  }

  public double getCapacity() {
    return capacity;
  }
}
