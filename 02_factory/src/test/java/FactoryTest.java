import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.Field;

public class FactoryTest {

  static FactoryManager fm = new FactoryManager();

  @BeforeClass
  public static void setUpClass() {
    fm.mainHeader();
    System.out.println("Rozpoczęcie testowania...");
    System.out.println("-------------------------------------------------------");
    System.out.println("Czyszczenie pamięci, instancja ustawiona na 'null'.");
    resetFactory(Factory.class, "factory");
  }

  @AfterClass
  public static void tearDownClass() {
    System.out.println("-------------------------------------------------------");
    System.out.println("Testowanie zakończone.");
  }

  @Before
  public void setUp() {
    System.out.println("-------------------------------------------------------");
  }

  @After
  public void tearDown() {
    System.out.println("-------------------------------------------------------");
    System.out.println("Czyszczenie pamięci, instancja ustawiona na 'null'.");
    resetFactory(Factory.class, "factory");
  }

  public static void resetFactory(Class theClass, String fieldName) {
    Field instance;
    try {
      instance = theClass.getDeclaredField(fieldName);
      instance.setAccessible(true);
      instance.set(null, null);
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  @Test
  public void simpleFactorySingletonTest() {
    fm.testHeader("Simple Factory Singleton Test");

    Factory factory1 = Factory.getFactory();
    Factory factory2 = Factory.getFactory();

    assertThat(factory2.hashCode(), equalTo(factory1.hashCode()));
    fm.displayHashCodes(factory1, factory2);
  }
}
