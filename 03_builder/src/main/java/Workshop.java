class Workshop {
  // public Product construct(Builder builder) {
  public void construct(Builder builder) {
    System.out.println("Trwa budowanie produktu...");
    builder.buildPart1().buildPart2().buildPart3().buildPart4().buildPart5();
    // return builder;
  }
}
