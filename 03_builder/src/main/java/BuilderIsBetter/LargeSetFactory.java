class LargeSetFactory extends SpeakerSetFactory {
  public LargeSetFactory() {
    speakerSet = new SpeakerSetProduct("Głośniki 5.1");
  }

  @Override
  public LargeSetFactory buildMembranes() {
    speakerSet.setPart("Membrany", "7");
    return this;
  };

  @Override
  public LargeSetFactory buildAmplifier() {
    speakerSet.setPart("Wzmacniacz", "120W");
    return this;
  };

  @Override
  public LargeSetFactory buildSpeakers() {
    speakerSet.setPart("Głośniki", "6");
    return this;
  };

  @Override
  public LargeSetFactory paintSpeakerSet() {
    speakerSet.setPart("Kolor", "czarny");
    return this;
  };
}
