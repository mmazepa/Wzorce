class LargeSetBuilder extends SpeakerSetBuilder {
  public LargeSetBuilder() {
    speakerSet = new SpeakerSet("Głośniki 5.1");
  }

  public LargeSetBuilder buildMembranes() {
    speakerSet.setPart("Membrany", "7");
    return this;
  };

  public LargeSetBuilder buildSpeakers() {
    speakerSet.setPart("Głośniki", "6");
    return this;
  };

  public LargeSetBuilder buildAmplifier() {
    speakerSet.setPart("Wzmacniacz", "80W");
    return this;
  };

  public LargeSetBuilder paintSpeakerSet() {
    speakerSet.setPart("Kolor", "czarny");
    return this;
  };
}
