class ProductBuilder extends Builder {
  public ProductBuilder() {
    product = new Product("Produkt");
  }

  public ProductBuilder buildPart1() {
    System.out.println("Part1 zbudowana...");
    product.setPart("part1", "część nr 1");
    return this;
  };

  public ProductBuilder buildPart2() {
    System.out.println("Part2 zbudowana...");
    product.setPart("part2", "część nr 2");
    return this;
  };

  public ProductBuilder buildPart3() {
    System.out.println("Part3 zbudowana...");
    product.setPart("part3", "część nr 3");
    return this;
  };

  public ProductBuilder buildPart4() {
    System.out.println("Part4 zbudowana...");
    product.setPart("part4", "część nr 4");
    return this;
  };

  public ProductBuilder buildPart5() {
    System.out.println("Part5 zbudowana...");
    product.setPart("part5", "część nr 5");
    return this;
  };
}
