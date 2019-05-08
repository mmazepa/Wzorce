import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;;

import manager.BuilderManager;
import builder.*;
import factory.*;

public class BuilderTest {
  static BuilderManager bm = new BuilderManager();

  @BeforeClass
  public static void setUpClass() {
    bm.mainHeader();
    System.out.println("Rozpoczęcie testowania...");
    System.out.println("───────────────────────────────────────────────────────");
  }

  @AfterClass
  public static void tearDownClass() {
    // System.out.println("───────────────────────────────────────────────────────");
    System.out.println("Testowanie zakończone.\n");
  }

  @Before
  public void setUp() {
    // System.out.println("───────────────────────────────────────────────────────");
  }

  @After
  public void tearDown() {
    System.out.println("───────────────────────────────────────────────────────");
  }

  @Test
  public void simpleBuilderTest() {
    bm.testHeader("Simple Builder Test");
    bm.setIsTimeTest(false);

    Shop shop = new Shop();

    builder.SpeakerSet small = shop.construct(new SmallSetBuilder());
    small.show();

    builder.SpeakerSet medium = shop.construct(new MediumSetBuilder());
    medium.show();

    builder.SpeakerSet large = shop.construct(new LargeSetBuilder());
    large.show();

    assertThat(small, instanceOf(builder.SpeakerSet.class));
    assertThat(medium, instanceOf(builder.SpeakerSet.class));
    assertThat(large, instanceOf(builder.SpeakerSet.class));
  }

  @Test
  public void simpleFactoryTest() {
    bm.testHeader("Simple Factory Test");
    bm.setIsTimeTest(false);

    SpeakerSetFactory speakerSetFactory = SpeakerSetFactory.getInstance();

    factory.SpeakerSet small = speakerSetFactory.makeSpeakerSet(SpeakerSetType.SMALL);
    small.show();

    factory.SpeakerSet medium = speakerSetFactory.makeSpeakerSet(SpeakerSetType.MEDIUM);
    small.show();

    factory.SpeakerSet large = speakerSetFactory.makeSpeakerSet(SpeakerSetType.LARGE);
    small.show();

    assertThat(small, instanceOf(factory.SpeakerSet.class));
    assertThat(medium, instanceOf(factory.SpeakerSet.class));
    assertThat(large, instanceOf(factory.SpeakerSet.class));
  }

  @Test
  public void builderVsAbstractFactoryTimeTest() {
    bm.testHeader("Builder vs. Abstract Factory Time Test");
    bm.setIsTimeTest(true);

    long startTime, endTime, timeElapsed;
    int limit = 1000000;

    Long[] results = new Long[2];

    // ----- BUILDER TIME TEST -------------------------------------------------
    SpeakerSetBuilder builder;
    Shop shop = new Shop();

    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      builder.SpeakerSet speaker = shop.construct(new SmallSetBuilder());
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[0] = timeElapsed;

    // ----- BUILDER TIME TEST -------------------------------------------------
    SpeakerSetFactory speakerSetFactory = SpeakerSetFactory.getInstance();

    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      factory.SpeakerSet speaker = speakerSetFactory.makeSpeakerSet(SpeakerSetType.SMALL);
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[1] = timeElapsed;

    System.out.println("   Builder Time: " + results[0] + " ms");
    System.out.println("   Factory Time: " + results[1] + " ms");
    System.out.print("\n");
    System.out.print("   And the winner is... ");
    System.out.println(results[0] < results[1] ? "BUILDER!" : "FACTORY!");
  }
}
