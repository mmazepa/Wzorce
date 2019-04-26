class MediumSetFactory extends SpeakerSetFactory {
  public MediumSetFactory() {
    speakerSet = new SpeakerSetProduct("Głośniki 2.1");
  }

  @Override
  public MediumSetFactory buildMembranes() {
    speakerSet.setPart("Membrany", "3");
    return this;
  };

  @Override
  public MediumSetFactory buildAmplifier() {
    speakerSet.setPart("Wzmacniacz", "60W");
    return this;
  };

  @Override
  public MediumSetFactory buildSpeakers() {
    speakerSet.setPart("Głośniki", "3");
    return this;
  };

  @Override
  public MediumSetFactory paintSpeakerSet() {
    speakerSet.setPart("Kolor", "srebrny");
    return this;
  };
}
