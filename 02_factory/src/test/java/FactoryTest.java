import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

import java.util.concurrent.TimeUnit;
import java.lang.reflect.InvocationTargetException;

public class FactoryTest {

  static FactoryManager fm = new FactoryManager();

  static Map<JuiceType, Class> juices = new HashMap<JuiceType, Class>();
  static Map<BeerType, Class> beers = new HashMap<BeerType, Class>();
  static Map<TeaType, Class> teas = new HashMap<TeaType, Class>();

  @BeforeClass
  public static void setUpClass() {
    fm.mainHeader();
    System.out.println("Rozpoczęcie testowania...");
    System.out.println("───────────────────────────────────────────────────────");

    System.out.println("Przygotowanie piw...");
    beers.put(BeerType.LAGER, LagerBeer.class);
    beers.put(BeerType.PILZNER, PilznerBeer.class);
    beers.put(BeerType.PORTER, PorterBeer.class);
    beers.put(BeerType.STOUT, StoutBeer.class);
    beers.put(BeerType.WHEAT, WheatBeer.class);

    System.out.println("Przygotowanie soków...");
    juices.put(JuiceType.KIWI, KiwiJuice.class);
    juices.put(JuiceType.MANGO, MangoJuice.class);
    juices.put(JuiceType.ORANGE, OrangeJuice.class);
    juices.put(JuiceType.POMEGRANATE, PomegranateJuice.class);
    juices.put(JuiceType.STRAWBERRY, StrawberryJuice.class);

    System.out.println("Przygotowanie herbat...");
    teas.put(TeaType.BLACK, BlackTea.class);
    teas.put(TeaType.GREEN, GreenTea.class);
    teas.put(TeaType.RED, RedTea.class);
    teas.put(TeaType.WHITE, WhiteTea.class);
    teas.put(TeaType.YELLOW, YellowTea.class);
  }

  @AfterClass
  public static void tearDownClass() {
    System.out.println("───────────────────────────────────────────────────────");
    System.out.println("Testowanie zakończone.\n");
  }

  @Before
  public void setUp() {
    System.out.println("───────────────────────────────────────────────────────");
  }

  @After
  public void tearDown() {
    // System.out.println("───────────────────────────────────────────────────────");
    resetFactory(SimpleFactory.class, "factory");
  }

  public static void resetFactory(Class theClass, String fieldName) {
    Field instance;
    try {
      instance = theClass.getDeclaredField(fieldName);
      instance.setAccessible(true);
      instance.set(null, null);
      instance.setAccessible(false);
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  @Test
  public void makeJuiceTest_simpleFactory() {
    fm.testHeader("Make Juice Test - Simple Factory");

    SimpleFactory factory = SimpleFactory.getInstance();

    for (Map.Entry<JuiceType, Class> entry : juices.entrySet()) {
      JuiceType wantedJuice = entry.getKey();
      Class expectedClass = entry.getValue();

      Juice juice = factory.makeJuice(wantedJuice);
      assertThat(juice, instanceOf(expectedClass));
    }

    System.out.println("   OK!");
  }

  @Test
  public void makeJuiceTest_factoryMethod() {
    fm.testHeader("Make Juice Test - Factory Method");

    FactoryMethod factory;

    factory = new PolishFactory();
    Juice juice1 = factory.makeJuice(JuiceType.KIWI);
    Juice juice2 = factory.makeJuice(JuiceType.MANGO);

    factory = new AmericanFactory();
    Juice juice3 = factory.makeJuice(JuiceType.ORANGE);

    factory = new GermanFactory();
    Juice juice4 = factory.makeJuice(JuiceType.POMEGRANATE);

    factory = new EnglishFactory();
    Juice juice5 = factory.makeJuice(JuiceType.STRAWBERRY);

    assertThat(juice1, instanceOf(KiwiJuice.class));
    assertThat(juice2, instanceOf(MangoJuice.class));
    assertThat(juice3, instanceOf(OrangeJuice.class));
    assertThat(juice4, instanceOf(PomegranateJuice.class));
    assertThat(juice5, instanceOf(StrawberryJuice.class));

    System.out.println("   OK!");
  }

  @Test
  public void makeBeerTest_simpleFactory() {
    fm.testHeader("Make Beer Test - Simple Factory");

    SimpleFactory factory = SimpleFactory.getInstance();

    for (Map.Entry<BeerType, Class> entry : beers.entrySet()) {
      BeerType wantedBeer = entry.getKey();
      Class expectedClass = entry.getValue();

      Beer beer = factory.makeBeer(wantedBeer);
      assertThat(beer, instanceOf(expectedClass));
    }

    System.out.println("   OK!");
  }

  @Test
  public void makeBeerTest_factoryMethod() {
    fm.testHeader("Make Beer Test - Factory Method");

    FactoryMethod factory;

    factory = new PolishFactory();
    Beer beer1 = factory.makeBeer(BeerType.LAGER);
    Beer beer2 = factory.makeBeer(BeerType.PILZNER);

    factory = new AmericanFactory();
    Beer beer3 = factory.makeBeer(BeerType.PORTER);

    factory = new GermanFactory();
    Beer beer4 = factory.makeBeer(BeerType.STOUT);

    factory = new EnglishFactory();
    Beer beer5 = factory.makeBeer(BeerType.WHEAT);

    assertThat(beer1, instanceOf(LagerBeer.class));
    assertThat(beer2, instanceOf(PilznerBeer.class));
    assertThat(beer3, instanceOf(PorterBeer.class));
    assertThat(beer4, instanceOf(StoutBeer.class));
    assertThat(beer5, instanceOf(WheatBeer.class));

    System.out.println("   OK!");
  }

  @Test
  public void makeTeaTest_simpleFactory() {
    fm.testHeader("Make Tea Test - Simple Factory");

    SimpleFactory factory = SimpleFactory.getInstance();

    for (Map.Entry<TeaType, Class> entry : teas.entrySet()) {
      TeaType wantedTea = entry.getKey();
      Class expectedClass = entry.getValue();

      Tea tea = factory.makeTea(wantedTea);
      assertThat(tea, instanceOf(expectedClass));
    }

    System.out.println("   OK!");
  }

  @Test
  public void makeTeaTest_factoryMethod() {
    fm.testHeader("Make Tea Test - Factory Method");

    FactoryMethod factory;

    factory = new PolishFactory();
    Tea tea1 = factory.makeTea(TeaType.BLACK);
    Tea tea2 = factory.makeTea(TeaType.GREEN);

    factory = new AmericanFactory();
    Tea tea3 = factory.makeTea(TeaType.RED);

    factory = new GermanFactory();
    Tea tea4 = factory.makeTea(TeaType.WHITE);

    factory = new EnglishFactory();
    Tea tea5 = factory.makeTea(TeaType.YELLOW);

    assertThat(tea1, instanceOf(BlackTea.class));
    assertThat(tea2, instanceOf(GreenTea.class));
    assertThat(tea3, instanceOf(RedTea.class));
    assertThat(tea4, instanceOf(WhiteTea.class));
    assertThat(tea5, instanceOf(YellowTea.class));

    System.out.println("   OK!");
  }

  @Test
  public void abstractFactoryTest() {
    fm.testHeader("Abstract Factory Test");

    NorwegianFactory norwegianFactory = NorwegianFactory.getInstance();
    SwedishFactory swedishFactory = SwedishFactory.getInstance();

    Drink norwegianMorningDrink = norwegianFactory.createDrink(JuiceType.ORANGE);
    Drink norwegianAfternoonDrink = norwegianFactory.createDrink(JuiceType.KIWI);
    Drink swedishMorningDrink = swedishFactory.createDrink(JuiceType.ORANGE);
    Drink swedishAfternoonDrink = swedishFactory.createDrink(JuiceType.KIWI);

    assertNotEquals(norwegianMorningDrink, norwegianAfternoonDrink);
    assertNotEquals(swedishMorningDrink, swedishAfternoonDrink);

    System.out.println("   OK!");
  }

  @Test
  public void timeTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    fm.testHeader("Factories Time Test");

    long startTime, endTime, timeElapsed;
    int limit = 1000000;
    final Object[][] results = new String[5][];

    // ----- SIMPLE FACTORY TIME TEST ------------------------------------------
	  startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      SimpleFactory simpleFactory = SimpleFactory.getInstance();
      Juice juice = simpleFactory.makeJuice(JuiceType.ORANGE);
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[0] = new String[] { "1", "SimpleFactory", timeElapsed + " ms" };

    // ----- FACTORY METHOD TIME TEST ------------------------------------------
    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      FactoryMethod factory;
      factory = new PolishFactory();
      Juice juice = factory.makeJuice(JuiceType.ORANGE);
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[1] = new String[] { "2", "FactoryMethod", timeElapsed + " ms" };

    // ----- ABSTRACT FACTORY TIME TEST ----------------------------------------
    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      SwedishFactory swedishFactory = SwedishFactory.getInstance();
      Drink swedishMorningDrink = swedishFactory.createDrink(JuiceType.ORANGE);
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[2] = new String[] { "3", "AbstractFactory", timeElapsed + " ms" };

    // ----- REGISTRATION CLASS WITH REFLECTION FACTORY TEST -------------------
    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      ClassRegisterReflectionFactory factory = ClassRegisterReflectionFactory.getInstance();
      factory.registerJuice(JuiceType.ORANGE, OrangeJuice.class);
      Juice juice = factory.makeJuice(JuiceType.ORANGE);
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[3] = new String[] { "4", "RegistrationClassReflection", timeElapsed + " ms" };

    // ----- REGISTRATION CLASS WITHOUT REFLECTION FACTORY TEST ----------------
    startTime = System.currentTimeMillis();
    for (int i = 0; i < limit; i++) {
      ClassRegisterNoReflectionFactory factory = ClassRegisterNoReflectionFactory.getInstance();
      factory.registerJuice(JuiceType.ORANGE, new OrangeJuiceSupplier());
      Juice juice = factory.makeJuice(JuiceType.ORANGE);
    }
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    results[4] = new String[] { "5", "RegistrationClassNoReflection", timeElapsed + " ms" };

    fm.printResults(results);
  }
}
