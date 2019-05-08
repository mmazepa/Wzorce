class Shop {
  SpeakerSetBuilderManager ssbm = new SpeakerSetBuilderManager();

  public SpeakerSet construct(SpeakerSetBuilder builder) {
    ssbm.printWithLinesAround("   Trwa budowanie zestawu głośników...");
    ssbm.println("   [" + builder.getClass().getSimpleName() + "]");
    return SpeakerSetBuilder.getSpeakerSet(builder);
  }
}
