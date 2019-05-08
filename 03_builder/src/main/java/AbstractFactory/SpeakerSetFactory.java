public class SpeakerSetFactory implements SpeakerSetAbstractFactory {
  private static SpeakerSetFactory factory;

  private SpeakerSetFactory() {}

  public static SpeakerSetFactory getInstance() {
    if (factory == null) {
      synchronized (SpeakerSetFactory.class) {
        if (factory == null) {
          factory = new SpeakerSetFactory();
        }
      }
    }
    return factory;
  }

  public SpeakerSetBase makeSpeakerSet(SpeakerSetType type) {
    switch (type) {
      case SMALL:
        return new SmallSpeakerSet();
      case MEDIUM:
        return new MediumSpeakerSet();
      case LARGE:
        return new LargeSpeakerSet();
      default:
        return null;
    }
  }
}
