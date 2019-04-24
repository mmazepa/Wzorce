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

    SpeakerSetBuilder builder;
    Shop shop = new Shop();

    SpeakerSet small = shop.construct(new SmallSetBuilder());
    small.show();

    SpeakerSet medium = shop.construct(new MediumSetBuilder());
    medium.show();

    SpeakerSet large = shop.construct(new LargeSetBuilder());
    large.show();
  }
}
