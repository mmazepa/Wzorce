class MediumSetBuilder extends SpeakerSetBuilder {
  public MediumSetBuilder() {
    speakerSet = new SpeakerSet("Głośniki 2.1");
  }

  public MediumSetBuilder buildMembranes() {
    speakerSet.setPart("Membrany", "3");
    return this;
  };

  public MediumSetBuilder buildSpeakers() {
    speakerSet.setPart("Głośniki", "3");
    return this;
  };

  public MediumSetBuilder buildAmplifier() {
    speakerSet.setPart("Wzmacniacz", "60W");
    return this;
  };

  public MediumSetBuilder paintSpeakerSet() {
    speakerSet.setPart("Kolor", "srebrny");
    return this;
  };
}
