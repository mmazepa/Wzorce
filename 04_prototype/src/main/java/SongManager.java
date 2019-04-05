import java.util.Map;
import java.util.HashMap;

class SongManager {
  private static Map<String, SongPrototype> songs = new HashMap<String, SongPrototype>();

  public static SongPrototype getSong(String key) {
    return songs.get(key);
  }

  public static void setSong(String key, SongPrototype songPrototype) {
    songs.put(key, songPrototype);
  }

  public static Map<String, SongPrototype> getAllSongs() {
    return songs;
  }

  public static void displayBoth(String typeOfCopy, Song originalSong, Song clonedSong) {
    String original = "   [Oryginał]: ";
    typeOfCopy = "   [" + typeOfCopy + "Copy]: ";
    while (original.length() < typeOfCopy.length()) original += " ";
    System.out.println(original + originalSong.stringify());
    System.out.println(typeOfCopy + clonedSong.stringify());
  }
}
