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
    resetFactory(SimpleFactory.class, "factory");
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
    resetFactory(SimpleFactory.class, "factory");
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

  //@Test
  public void simpleSimpleFactorySingletonTest() {
    fm.testHeader("SimpleFactory Singleton Test");

    SimpleFactory factory1 = SimpleFactory.getInstance();
    SimpleFactory factory2 = SimpleFactory.getInstance();

    assertThat(factory2.hashCode(), equalTo(factory1.hashCode()));
    fm.displayHashCodes(factory1, factory2);
  }

  //@Test
  public void simpleFactoryMethodSingletonTest() {
    fm.testHeader("FactoryMethod Singleton Test");

    FactoryMethod factory1 = FactoryMethod.getInstance();
    FactoryMethod factory2 = FactoryMethod.getInstance();

    assertThat(factory2.hashCode(), equalTo(factory1.hashCode()));
    fm.displayHashCodes(factory1, factory2);
  }

  @Test
  public void makeJuiceTest_simpleFactory() {
    fm.testHeader("Make Juice Test - Simple Factory");

    SimpleFactory factory = SimpleFactory.getInstance();

    Juice juice1 = factory.makeJuice("orange");
    Juice juice2 = factory.makeJuice("strawberry");
    Juice juice3 = factory.makeJuice("kiwi");
    Juice juice4 = factory.makeJuice("mango");
    Juice juice5 = factory.makeJuice("pomegranate");

    System.out.println(juice1.getClass());
    System.out.println(juice2.getClass());
    System.out.println(juice3.getClass());
    System.out.println(juice4.getClass());
    System.out.println(juice5.getClass());

    assertThat(juice1, instanceOf(OrangeJuice.class));
    assertThat(juice2, instanceOf(StrawberryJuice.class));
    assertThat(juice3, instanceOf(KiwiJuice.class));
    assertThat(juice4, instanceOf(MangoJuice.class));
    assertThat(juice5, instanceOf(PomegranateJuice.class));
  }

  @Test
  public void makeJuiceTest_factoryMethod() {
    fm.testHeader("Make Juice Test - Factory Method");

    FactoryMethod factory;

    factory = new PolishFactory();
    Juice juice1 = factory.makeJuice("orange");
    Juice juice2 = factory.makeJuice("strawberry");

    factory = new AmericanFactory();
    Juice juice3 = factory.makeJuice("kiwi");

    factory = new GermanFactory();
    Juice juice4 = factory.makeJuice("mango");

    factory = new EnglishFactory();
    Juice juice5 = factory.makeJuice("pomegranate");

    System.out.println(juice1.getClass());
    System.out.println(juice2.getClass());
    System.out.println(juice3.getClass());
    System.out.println(juice4.getClass());
    System.out.println(juice5.getClass());

    assertThat(juice1, instanceOf(OrangeJuice.class));
    assertThat(juice2, instanceOf(StrawberryJuice.class));
    assertThat(juice3, instanceOf(KiwiJuice.class));
    assertThat(juice4, instanceOf(MangoJuice.class));
    assertThat(juice5, instanceOf(PomegranateJuice.class));
  }

  @Test
  public void makeBeerTest_simpleFactory() {
    fm.testHeader("Make Beer Test - Simple Factory");

    SimpleFactory factory = SimpleFactory.getInstance();

    Beer beer1 = factory.makeBeer("lager");
    Beer beer2 = factory.makeBeer("wheat");
    Beer beer3 = factory.makeBeer("pilzner");
    Beer beer4 = factory.makeBeer("porter");
    Beer beer5 = factory.makeBeer("stout");

    System.out.println(beer1.getClass());
    System.out.println(beer2.getClass());
    System.out.println(beer3.getClass());
    System.out.println(beer4.getClass());
    System.out.println(beer5.getClass());

    assertThat(beer1, instanceOf(LagerBeer.class));
    assertThat(beer2, instanceOf(WheatBeer.class));
    assertThat(beer3, instanceOf(PilznerBeer.class));
    assertThat(beer4, instanceOf(PorterBeer.class));
    assertThat(beer5, instanceOf(StoutBeer.class));
  }

  @Test
  public void makeBeerTest_factoryMethod() {
    fm.testHeader("Make Beer Test - Factory Method");

    FactoryMethod factory;

    factory = new PolishFactory();
    Beer beer1 = factory.makeBeer("lager");
    Beer beer2 = factory.makeBeer("wheat");

    factory = new AmericanFactory();
    Beer beer3 = factory.makeBeer("pilzner");

    factory = new GermanFactory();
    Beer beer4 = factory.makeBeer("porter");

    factory = new EnglishFactory();
    Beer beer5 = factory.makeBeer("stout");

    System.out.println(beer1.getClass());
    System.out.println(beer2.getClass());
    System.out.println(beer3.getClass());
    System.out.println(beer4.getClass());
    System.out.println(beer5.getClass());

    assertThat(beer1, instanceOf(LagerBeer.class));
    assertThat(beer2, instanceOf(WheatBeer.class));
    assertThat(beer3, instanceOf(PilznerBeer.class));
    assertThat(beer4, instanceOf(PorterBeer.class));
    assertThat(beer5, instanceOf(StoutBeer.class));
  }

  @Test
  public void makeTeaTest_simpleFactory() {
    fm.testHeader("Make Tea Test - Simple Factory");

    SimpleFactory factory = SimpleFactory.getInstance();

    Tea tea1 = factory.makeTea("black");
    Tea tea2 = factory.makeTea("green");
    Tea tea3 = factory.makeTea("red");
    Tea tea4 = factory.makeTea("white");
    Tea tea5 = factory.makeTea("yellow");

    System.out.println(tea1.getClass());
    System.out.println(tea2.getClass());
    System.out.println(tea3.getClass());
    System.out.println(tea4.getClass());
    System.out.println(tea5.getClass());

    assertThat(tea1, instanceOf(BlackTea.class));
    assertThat(tea2, instanceOf(GreenTea.class));
    assertThat(tea3, instanceOf(RedTea.class));
    assertThat(tea4, instanceOf(WhiteTea.class));
    assertThat(tea5, instanceOf(YellowTea.class));
  }

  @Test
  public void makeTeaTest_factoryMethod() {
    fm.testHeader("Make Tea Test - Factory Method");

    FactoryMethod factory;

    factory = new PolishFactory();
    Tea tea1 = factory.makeTea("black");
    Tea tea2 = factory.makeTea("green");

    factory = new AmericanFactory();
    Tea tea3 = factory.makeTea("red");

    factory = new GermanFactory();
    Tea tea4 = factory.makeTea("white");

    factory = new EnglishFactory();
    Tea tea5 = factory.makeTea("yellow");

    System.out.println(tea1.getClass());
    System.out.println(tea2.getClass());
    System.out.println(tea3.getClass());
    System.out.println(tea4.getClass());
    System.out.println(tea5.getClass());

    assertThat(tea1, instanceOf(BlackTea.class));
    assertThat(tea2, instanceOf(GreenTea.class));
    assertThat(tea3, instanceOf(RedTea.class));
    assertThat(tea4, instanceOf(WhiteTea.class));
    assertThat(tea5, instanceOf(YellowTea.class));
  }
}
