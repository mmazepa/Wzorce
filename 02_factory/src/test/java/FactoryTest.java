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

    Factory factory1 = Factory.getInstance();
    Factory factory2 = Factory.getInstance();

    assertThat(factory2.hashCode(), equalTo(factory1.hashCode()));
    fm.displayHashCodes(factory1, factory2);
  }

  @Test
  public void makeJuiceTest() {
    fm.testHeader("Make Juice Test");

    Factory factory = Factory.getInstance();

    Juice juice1 = factory.makeJuice("orange", 500);
    System.out.println(juice1.getClass());
    juice1.getDetails();

    Juice juice2 = factory.makeJuice("strawberry", 750);
    System.out.println(juice2.getClass());
    juice2.getDetails();

    Juice juice3 = factory.makeJuice("kiwi", 250);
    System.out.println(juice3.getClass());
    juice3.getDetails();

    Juice juice4 = factory.makeJuice("mango", 330);
    System.out.println(juice4.getClass());
    juice4.getDetails();

    Juice juice5 = factory.makeJuice("pomegranate", 250);
    System.out.println(juice5.getClass());
    juice5.getDetails();

    assertThat(juice1, instanceOf(OrangeJuice.class));
    assertThat(juice1.getFruit(), equalTo("orange"));
    assertThat(juice1.getCapacity(), equalTo(500.0));
  }

  @Test
  public void makeBeerTest() {
    fm.testHeader("Make Beer Test");

    Factory factory = Factory.getInstance();

    Beer beer1 = factory.makeBeer("lager", 500, 7);
    System.out.println(beer1.getClass());
    beer1.getDetails();

    Beer beer2 = factory.makeBeer("wheat", 750, 5);
    System.out.println(beer2.getClass());
    beer2.getDetails();

    Beer beer3 = factory.makeBeer("pilzner", 250, 4.5);
    System.out.println(beer3.getClass());
    beer3.getDetails();

    Beer beer4 = factory.makeBeer("porter", 330, 8.2);
    System.out.println(beer4.getClass());
    beer4.getDetails();

    Beer beer5 = factory.makeBeer("stout", 250, 5.6);
    System.out.println(beer5.getClass());
    beer5.getDetails();

    assertThat(beer1, instanceOf(LagerBeer.class));
    assertThat(beer1.getType(), equalTo("lager"));
    assertThat(beer1.getCapacity(), equalTo(500.0));
    assertThat(beer1.getAlcohol(), equalTo(7.0));
  }

  @Test
  public void makeTeaTest() {
    fm.testHeader("Make Tea Test");

    Factory factory = Factory.getInstance();

    Tea tea1 = factory.makeTea("black", 500);
    System.out.println(tea1.getClass());
    tea1.getDetails();

    Tea tea2 = factory.makeTea("green", 750);
    System.out.println(tea2.getClass());
    tea2.getDetails();

    Tea tea3 = factory.makeTea("red", 250);
    System.out.println(tea3.getClass());
    tea3.getDetails();

    Tea tea4 = factory.makeTea("white", 330);
    System.out.println(tea4.getClass());
    tea4.getDetails();

    Tea tea5 = factory.makeTea("yellow", 250);
    System.out.println(tea5.getClass());
    tea5.getDetails();

    assertThat(tea1, instanceOf(BlackTea.class));
    assertThat(tea1.getTaste(), equalTo("black"));
    assertThat(tea1.getCapacity(), equalTo(500.0));
  }
}
