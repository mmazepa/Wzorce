class Shop {
  SpeakerSetBuilderManager ssbm = new SpeakerSetBuilderManager();

  public SpeakerSet construct(SpeakerSetBuilder builder) {
    ssbm.printWithLineAbove("Trwa budowanie zestawu głośników...");
    return builder
      .buildMembranes()
      .buildAmplifier()
      .buildSpeakers()
      .paintSpeakerSet()
      .getSpeakerSet();
  }
}
