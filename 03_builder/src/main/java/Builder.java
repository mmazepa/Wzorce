abstract class Builder {
  protected Product product;

  public Product GetProduct() { return product; }

  public abstract void BuildPart1();
  public abstract void BuildPart2();
  public abstract void BuildPart3();
  public abstract void BuildPart4();
  public abstract void BuildPart5();
}
