class SmallSetFactory extends SpeakerSetFactory {
  public SmallSetFactory() {
    speakerSet = new SpeakerSetProduct("Głośniki 2.0");
  }

  @Override
  public SmallSetFactory buildMembranes() {
    speakerSet.setPart("Membrany", "2");
    return this;
  };

  @Override
  public SmallSetFactory buildAmplifier() {
    speakerSet.setPart("Wzmacniacz", "14W");
    return this;
  };

  @Override
  public SmallSetFactory buildSpeakers() {
    speakerSet.setPart("Głośniki", "2");
    return this;
  };

  @Override
  public SmallSetFactory paintSpeakerSet() {
    speakerSet.setPart("Kolor", "biały");
    return this;
  };
}
