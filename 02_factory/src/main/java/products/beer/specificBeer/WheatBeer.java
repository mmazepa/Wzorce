class WheatBeer implements Beer {
  protected double capacity;
  protected double alcohol;

  public WheatBeer() {}

  public WheatBeer(double capacity, double alcohol) {
    this.capacity = capacity;
    this.alcohol = alcohol;
  }

  public void setCapacity(double capacity) {
    this.capacity = capacity;
  }
  public double getCapacity() {
    return capacity;
  }

  public void setAlcohol(double alcohol) {
    this.alcohol = alcohol;
  }
  public double getAlcohol() {
    return alcohol;
  }
}
