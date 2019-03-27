class WheatBeer implements Beer {
  protected double capacity;
  protected double alcohol;

  public WheatBeer() {}

  public WheatBeer(double capacity, double alcohol) {
    this.capacity = capacity;
    this.alcohol = alcohol;
  }

  // @Override
  public void setCapacity(double capacity) {
    this.capacity = capacity;
  }

  // @Override
  public double getCapacity() {
    return capacity;
  }

  // @Override
  public void setAlcohol(double alcohol) {
    this.alcohol = alcohol;
  }

  // @Override
  public double getAlcohol() {
    return alcohol;
  }
}
