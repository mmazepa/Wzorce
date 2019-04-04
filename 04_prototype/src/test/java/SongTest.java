import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.time.Duration;

public class SongTest {

  static SongManager sm = new SongManager();

  @BeforeClass
  public static void setUpClass() {
    sm.mainHeader();
    System.out.println("Rozpoczęcie testowania...");
    System.out.println("-------------------------------------------------------");
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
  }

  @Test
  public void simpleCloningTest() throws CloneNotSupportedException {
    sm.testHeader("Simple Cloning Test");

    Song song1 = new Song("cartoon", "Robbie Rotten", "We Are Number One", Duration.ofSeconds(2*60+18), 2014);
    Song song2 = new Song("rock", "Jonathan Young", "BAIT", Duration.ofSeconds(2*60+43), 2018);
    Song song3 = new Song("metal", "Turbo", "Strażnik Światła", Duration.ofSeconds(8*60+21), 2009);

    sm.setSong(song1.getTag(), song1);
    sm.setSong(song2.getTag(), song2);
    sm.setSong(song3.getTag(), song3);

    System.out.println("---------------------------------------------");
    sm.testCloning(song1.getTag(), song1);
    System.out.println("---------------------------------------------");
    sm.testCloning(song2.getTag(), song2);
    System.out.println("---------------------------------------------");
    sm.testCloning(song3.getTag(), song3);
    System.out.println("---------------------------------------------");

    // assertThat(factory2.hashCode(), equalTo(factory1.hashCode()));
  }
}
