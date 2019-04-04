import java.time.Duration;

abstract class SongPrototype {
  public abstract SongPrototype Clone() throws CloneNotSupportedException;
}
