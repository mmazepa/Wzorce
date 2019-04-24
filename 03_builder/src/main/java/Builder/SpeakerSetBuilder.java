abstract class SpeakerSetBuilder {
  protected SpeakerSet speakerSet;

  public SpeakerSet getSpeakerSet() {
    return speakerSet;
  }

  public abstract SpeakerSetBuilder buildMembranes();
  public abstract SpeakerSetBuilder buildAmplifier();
  public abstract SpeakerSetBuilder buildSpeakers();
  public abstract SpeakerSetBuilder paintSpeakerSet();

  public static SpeakerSet getSpeakerSet(SpeakerSetBuilder builder) {
    return builder
      .buildMembranes()
      .buildAmplifier()
      .buildSpeakers()
      .paintSpeakerSet()
      .speakerSet;
  }
}
