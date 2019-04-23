class Shop {
  // public Product construct(Builder builder) {
  public void construct(SpeakerSetBuilder builder) {
    System.out.println("------------------------------------------------------");
    System.out.println("Trwa budowanie produktu...");
    System.out.println("------------------------------------------------------");
    builder.buildMembranes().buildSpeakers().buildAmplifier().paintSpeakerSet();
    // return builder;
  }
}
