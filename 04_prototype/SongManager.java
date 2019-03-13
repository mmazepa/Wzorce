import java.util.Map;
import java.util.HashMap;

class SongManager {
  private Map<String, SongPrototype> songs = new HashMap<String, SongPrototype>();

  public SongPrototype getSong(String key) {
    return songs.get(key);
  }

  public void setSong(String key, SongPrototype songPrototype) {
    songs.put(key, songPrototype);
  }
}
