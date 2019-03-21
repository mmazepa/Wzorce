class StoutBeer implements Beer {
  protected String type;
  protected double capacity;
  protected double alcohol;

  public StoutBeer(String type, double capacity, double alcohol) {
    this.type = type;
    this.capacity = capacity;
    this.alcohol = alcohol;
  }

  public void getDetails() {
    System.out.println(type + " beer (capacity: " + capacity + " ml, alcohol: " + alcohol + "%)");
  }

  public String getType() {
    return type;
  }

  public double getCapacity() {
    return capacity;
  }

  public double getAlcohol() {
    return alcohol;
  }
}
