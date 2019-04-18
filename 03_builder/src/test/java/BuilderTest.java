import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BuilderTest {

  static BuilderManager bm = new BuilderManager();

  @BeforeClass
  public static void setUpClass() {
    bm.mainHeader();
    System.out.println("Rozpoczęcie testowania...");
    System.out.println("-------------------------------------------------------");
  }

  @AfterClass
  public static void tearDownClass() {
    // System.out.println("-------------------------------------------------------");
    System.out.println("Testowanie zakończone.");
  }

  @Before
  public void setUp() {
    // System.out.println("-------------------------------------------------------");
  }

  @After
  public void tearDown() {
    System.out.println("-------------------------------------------------------");
  }

  @Test
  public void simpleBuilderTest() {
    bm.testHeader("Simple Builder Test");

    //...
  }
}
