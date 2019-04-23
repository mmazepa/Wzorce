class SmallSetBuilder extends SpeakerSetBuilder {
  public SmallSetBuilder() {
    speakerSet = new SpeakerSet("Głośniki 2.0");
  }

  public SmallSetBuilder buildMembranes() {
    speakerSet.setPart("Membrany", "2");
    return this;
  };

  public SmallSetBuilder buildSpeakers() {
    speakerSet.setPart("Głośniki", "2");
    return this;
  };

  public SmallSetBuilder buildAmplifier() {
    speakerSet.setPart("Wzmacniacz", "14W");
    return this;
  };

  public SmallSetBuilder paintSpeakerSet() {
    speakerSet.setPart("Kolor", "biały");
    return this;
  };
}
