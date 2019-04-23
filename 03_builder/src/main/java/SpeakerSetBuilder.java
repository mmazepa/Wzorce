abstract class SpeakerSetBuilder {
  protected SpeakerSet speakerSet;

  public SpeakerSet getSpeakerSet() { return speakerSet; }

  public abstract SpeakerSetBuilder buildMembranes();
  public abstract SpeakerSetBuilder buildSpeakers();
  public abstract SpeakerSetBuilder buildAmplifier();
  public abstract SpeakerSetBuilder paintSpeakerSet();

  // public static final Product Product(final Builder builder) {
  //   return builder
  //     .buildMembranes()
  //     .buildSpeakers()
  //     .buildAmplifier()
  //     .paintSpeakerSet()
  //     .speakerSet;
  // }
}
