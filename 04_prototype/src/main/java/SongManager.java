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

  public static void mainHeader() {
    System.out.println(" _____         _       _             _____         _   ");
    System.out.println("|  _  |___ ___| |_ ___| |_ _ _ ___ _|_   _|___ ___| |_ ");
    System.out.println("|   __|  _| . |  _| . |  _| | | . | -_| | | -_|_ -|  _|");
    System.out.println("|__|  |_| |___|_| |___|_| |_  |  _|___|_| |___|___|_|  ");
    System.out.println("                          |___|_|                       ");
  }

  public static String howManyFrames(String frame, int times) {
    String pattern = frame;
    while (frame.length() < times) frame += pattern;
    return frame;
  }

  public static void testHeader(String testInfo) {
    System.out.print("╔" + howManyFrames("═", testInfo.length() + 2) + "╗\n");
    System.out.println("║ " + testInfo + " ║");
    System.out.print("╚" + howManyFrames("═", testInfo.length() + 2) + "╝\n");
  }

  public static void displayBoth(String typeOfCopy, Song originalSong, Song clonedSong) {
    String original = "   [Oryginał]: ";
    typeOfCopy = "   [" + typeOfCopy + "Copy]: ";
    while (original.length() < typeOfCopy.length()) original += " ";
    System.out.println(original + originalSong.stringify());
    System.out.println(typeOfCopy + clonedSong.stringify());
  }
}
