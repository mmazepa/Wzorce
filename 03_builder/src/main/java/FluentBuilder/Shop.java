package builder;
import manager.BuilderManager;

public class Shop {
  BuilderManager bm = new BuilderManager();

  public SpeakerSet construct(SpeakerSetBuilder builder) {
    bm.printWithLinesAround("   Trwa budowanie zestawu głośników...");
    bm.println("   [" + builder.getClass().getSimpleName() + "]");
    return SpeakerSetBuilder.getSpeakerSet(builder);
  }
}
