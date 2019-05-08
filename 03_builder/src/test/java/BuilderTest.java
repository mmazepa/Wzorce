import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;;

public class BuilderTest {

  static SpeakerSetBuilderManager ssbm = new SpeakerSetBuilderManager();

  @BeforeClass
  public static void setUpClass() {
    ssbm.mainHeader();
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
    ssbm.testHeader("Simple Builder Test");
    ssbm.setIsTimeTest(false);

    SpeakerSetBuilder builder;
    Shop shop = new Shop();

    SpeakerSet small = shop.construct(new SmallSetBuilder());
    small.show();

    SpeakerSet medium = shop.construct(new MediumSetBuilder());
    medium.show();

    SpeakerSet large = shop.construct(new LargeSetBuilder());
    large.show();

    assertThat(small, instanceOf(SpeakerSet.class));
    assertThat(medium, instanceOf(SpeakerSet.class));
    assertThat(large, instanceOf(SpeakerSet.class));
  }

  @Test
  public void builderVsAbstractFactoryTimeTest() {
    ssbm.testHeader("Builder vs. Abstract Factory Time Test");
    ssbm.setIsTimeTest(true);

    long startTime, endTime, timeElapsed;
    int limit = 1000000;

    Long[] results = new Long[2];

    // ----- BUILDER TIME TEST -------------------------------------------------
    SpeakerSetBuilder builder;
    Shop shop = new Shop();

    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      SpeakerSet speaker = shop.construct(new SmallSetBuilder());
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[0] = timeElapsed;

    // ----- BUILDER TIME TEST -------------------------------------------------
    SpeakerSetFactory factory = SpeakerSetFactory.getInstance();

    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      SpeakerSetBase speaker = factory.makeSpeakerSet(SpeakerSetType.SMALL);
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
