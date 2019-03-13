import java.time.Duration;
import java.util.ArrayList;

class SongTest {
  public static ArrayList<Song> songsToTest = new ArrayList<Song>();

  public static void songDetails(Song song) {
    System.out.println(song.stringify());
  }

  public static void displayBoth(Song originalSong, Song clonedSong) {
    System.out.print("[Original]: ");
    songDetails(originalSong);
    System.out.print("[TheClone]: ");
    songDetails(clonedSong);
  }

  public static String equalOrNot(String string1, String string2) {
    if (string1.equals(string2)) return "equal";
    else return "not equal";
  }

  public static void testCloning(Song song) throws CloneNotSupportedException {
    SongManager am = new SongManager();
    am.setSong("cartoon", song);
    Song clonedSong = (Song) am.getSong("cartoon").Clone();

    displayBoth(song, clonedSong);
    song.setAuthor("NEW AUTHOR");
    clonedSong.setTitle("NEW TITLE");
    System.out.println("-------------");
    displayBoth(song, clonedSong);

    System.out.println(" ===> [author]: " + equalOrNot(song.getAuthor(), clonedSong.getAuthor()));
    System.out.println(" ===> [title]:  " + equalOrNot(song.getTitle(), clonedSong.getTitle()));
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    songsToTest.add(new Song("Robbie Rotten", "We Are Number One", Duration.ofSeconds(2*60+18), 2014));
    songsToTest.add(new Song("Jonathan Young", "BAIT", Duration.ofSeconds(2*60+43), 2018));
    songsToTest.add(new Song("Turbo", "Strażnik Światła", Duration.ofSeconds(8*60+21), 2009));

    for (Song song : songsToTest) {
      testCloning(song);
      System.out.println("---------------------------------------------");
    }
  }
}
