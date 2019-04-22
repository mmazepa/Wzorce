import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;;

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

    Builder builder;
    Workshop workshop = new Workshop();

    builder = new ProductBuilder();
    workshop.construct(builder);
    builder.getProduct().show();
  }
}
