abstract class SpeakerSetFactory {
  protected SpeakerSetProduct speakerSet;

  public SpeakerSetProduct getSpeakerSet() {
    return speakerSet;
  }

  abstract SpeakerSetFactory buildMembranes();
  abstract SpeakerSetFactory buildAmplifier();
  abstract SpeakerSetFactory buildSpeakers();
  abstract SpeakerSetFactory paintSpeakerSet();
}
