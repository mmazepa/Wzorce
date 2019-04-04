import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.time.Duration;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SongTest {

  static Person author1 = new Person("Robbie", "Rotten");
  static Person author2 = new Person("Jonathan", "Young");
  static Person author3 = new Person("Michał", "Jelonek");

  static String tag1 = "robbie";
  static String tag2 = "john_young";
  static String tag3 = "jelonek";

  static Song song1 = new Song(tag1, author1, "We Are Number One", Duration.ofSeconds(2*60+18), 2014);
  static Song song2 = new Song(tag2, author2, "BAIT", Duration.ofSeconds(2*60+43), 2018);
  static Song song3 = new Song(tag3, author3, "Akka", Duration.ofSeconds(2*60+33), 2007);

  static SongManager sm = new SongManager();

  @BeforeClass
  public static void setUpClass() {
    sm.mainHeader();

    sm.setSong(tag1, song1);
    sm.setSong(tag2, song2);
    sm.setSong(tag3, song3);

    System.out.println("Rozpoczęcie testowania...");
    // System.out.println("───────────────────────────────────────────────────────");
  }

  @AfterClass
  public static void tearDownClass() {
    System.out.println("───────────────────────────────────────────────────────");
    System.out.println("Testowanie zakończone.");
  }

  @Before
  public void setUp() {
    System.out.println("───────────────────────────────────────────────────────");
  }

  @After
  public void tearDown() {
    // System.out.println("───────────────────────────────────────────────────────");
  }

  @Test
  public void shallowCopyTest() throws CloneNotSupportedException {
    sm.testHeader("Shallow Copy Test");

    Song song1_shallowCopy = (Song) sm.getSong(song1.getTag()).ShallowCopy();
    song1.getAuthor().setFirstName("Robert");
    sm.displayBoth("Shallow", song1, song1_shallowCopy);
    assertSame(song1.getAuthor(), song1_shallowCopy.getAuthor());

    Song song2_shallowCopy = (Song) sm.getSong(song2.getTag()).ShallowCopy();
    song2.getAuthor().setLastName("Młody");
    sm.displayBoth("Shallow", song2, song2_shallowCopy);
    assertSame(song2.getAuthor(), song2_shallowCopy.getAuthor());

    Song song3_shallowCopy = (Song) sm.getSong(song3.getTag()).ShallowCopy();
    song3.getAuthor().setFirstName("Michael");
    song3.getAuthor().setLastName("Deer");
    sm.displayBoth("Shallow", song3, song3_shallowCopy);
    assertSame(song3.getAuthor(), song3_shallowCopy.getAuthor());
  }

  @Test
  public void deepCopyTest() throws CloneNotSupportedException {
    sm.testHeader("Deep Copy Test");

    Song song1_deepCopy = (Song) sm.getSong(song1.getTag()).DeepCopy();
    song1.getAuthor().setFirstName("Robert");
    sm.displayBoth("Deep", song1, song1_deepCopy);
    assertNotEquals(song1.getAuthor(), song1_deepCopy.getAuthor());
    assertNotSame(song1.getAuthor(), song1_deepCopy.getAuthor());

    Song song2_deepCopy = (Song) sm.getSong(song2.getTag()).DeepCopy();
    song2.getAuthor().setLastName("Młody");
    sm.displayBoth("Deep", song2, song2_deepCopy);
    assertNotEquals(song2.getAuthor(), song2_deepCopy.getAuthor());
    assertNotSame(song2.getAuthor(), song2_deepCopy.getAuthor());

    Song song3_deepCopy = (Song) sm.getSong(song3.getTag()).DeepCopy();
    song3.getAuthor().setFirstName("Michael");
    song3.getAuthor().setLastName("Deer");
    sm.displayBoth("Deep", song3, song3_deepCopy);
    assertNotEquals(song3.getAuthor(), song3_deepCopy.getAuthor());
    assertNotSame(song3.getAuthor(), song3_deepCopy.getAuthor());
  }
}
