import java.time.Duration;
import java.util.Set;
import java.util.HashSet;

class SongTest {
  public static SongManager am = new SongManager();

  public static void displayBoth(Song originalSong, Song clonedSong) {
    System.out.println("   [Original]: " + originalSong.stringify());
    System.out.println("   [TheClone]: " + clonedSong.stringify());
  }

  public static void testCloning(String key, Song song) throws CloneNotSupportedException {
    Song clonedSong = (Song) am.getSong(key).Clone();

    song.setAuthor("NEW AUTHOR");
    clonedSong.setTitle("NEW TITLE");
    displayBoth(song, clonedSong);

    System.out.println("[original vs. clone]");
    System.out.println("   [EQUALS?]: " + song.equals(clonedSong));
    System.out.println("   [s1==s2?]: " + (song == clonedSong));
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    Song song1 = new Song("cartoon", "Robbie Rotten", "We Are Number One", Duration.ofSeconds(2*60+18), 2014);
    Song song2 = new Song("rock", "Jonathan Young", "BAIT", Duration.ofSeconds(2*60+43), 2018);
    Song song3 = new Song("metal", "Turbo", "Strażnik Światła", Duration.ofSeconds(8*60+21), 2009);

    am.setSong(song1.getTag(), song1);
    am.setSong(song2.getTag(), song2);
    am.setSong(song3.getTag(), song3);

    System.out.println("---------------------------------------------");
    testCloning(song1.getTag(), song1);
    System.out.println("---------------------------------------------");
    testCloning(song2.getTag(), song2);
    System.out.println("---------------------------------------------");
    testCloning(song3.getTag(), song3);
    System.out.println("---------------------------------------------");
  }
}
