package factory;
import manager.BuilderManager;

public class SpeakerSetFactory implements SpeakerSetAbstractFactory {
  private static SpeakerSetFactory factory;
  BuilderManager bm = new BuilderManager();

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

  public SpeakerSet makeSpeakerSet(SpeakerSetType type) {
    bm.printWithLinesAround("   Trwa budowanie zestawu głośników...");
    bm.println("   [" + type + "]");
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
