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

public class SingletonTest {

  static SingletonManager sm = new SingletonManager();
  static String filename = "instance.ser";

  @BeforeClass
  public static void setUpClass() throws FileNotFoundException, IOException, ClassNotFoundException {
    // Before testing
    System.out.println("Tests start!");
    sm.serialize(Singleton.getInstance(), filename);
  }

  @AfterClass
  public static void tearDownClass() {
    // After testing
    System.out.println("-------------------------------------------------------");
    System.out.println("Tests end!");
  }

  @Before
  public void setUp() {
    // Before every test
    System.out.println("-------------------------------------------------------");
  }

  @After
  public void tearDown() {
    // After every test
    System.out.println("-------------------------------------------------------");
    System.out.println("Czyszczenie pamięci, instancja ustawiona na 'null'.");
    resetSingleton(Singleton.class, "instance");
  }

  public static void resetSingleton(Class theClass, String fieldName) {
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
  public void simpleSingletonTest() {
    sm.testHeader("Simple Singleton Test");

    Singleton instance1 = Singleton.getInstance();
    Singleton instance2 = Singleton.getInstance();

    assertEquals(instance1.hashCode(), instance2.hashCode());
    sm.displayHashCodes(instance1, instance2);
  }

  @Test
  public void serializationWithInstanceTest() throws FileNotFoundException, IOException, ClassNotFoundException {
    sm.testHeader("Serialization WITH Instance Test");

    Singleton instance1 = Singleton.getInstance();
    Singleton instance2;

    sm.serialize(instance1, filename);
    instance2 = sm.deserialize(filename);

    assertEquals(instance1.hashCode(), instance2.hashCode());
    sm.displayHashCodes(instance1, instance2);
  }

  @Test
  public void serializationWithoutInstanceTest() throws FileNotFoundException, IOException, ClassNotFoundException {
    sm.testHeader("Serialization WITHOUT Instance Test");

    Singleton instance1 = sm.deserialize(filename);
    Singleton instance2 = Singleton.getInstance();

    assertEquals(instance1.hashCode(), instance2.hashCode());
    sm.displayHashCodes(instance1, instance2);
  }
}
