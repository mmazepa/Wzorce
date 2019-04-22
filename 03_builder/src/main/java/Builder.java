abstract class Builder {
  protected Product product;

  public Product getProduct() { return product; }

  public abstract ProductBuilder buildPart1();
  public abstract ProductBuilder buildPart2();
  public abstract ProductBuilder buildPart3();
  public abstract ProductBuilder buildPart4();
  public abstract ProductBuilder buildPart5();

  // public static final Product Product(final Builder builder) {
  //   return builder
  //     .buildPart1()
  //     .buildPart2()
  //     .buildPart3()
  //     .buildPart4()
  //     .buildPart5()
  //     .product;
  // }
}
