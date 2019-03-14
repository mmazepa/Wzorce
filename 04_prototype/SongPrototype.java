import java.time.Duration;

abstract class SongPrototype {
  public abstract SongPrototype Clone() throws CloneNotSupportedException;
}

class Song extends SongPrototype implements Cloneable {
  private String tag;
  private String author;
  private String title;
  private Duration duration;
  private int year;

  public Song(String tag, String author, String title, Duration duration, int year) {
    this.tag = tag;
    this.author = author;
    this.title = title;
    this.duration = duration;
    this.year = year;
  }

  String getTag() { return this.tag; }
  void setTag(String tag) { this.tag = tag; }

  String getAuthor() { return this.author; }
  void setAuthor(String author) { this.author = author; }

  String getTitle() { return this.title; }
  void setTitle(String title) { this.title = title; }

  Duration getDuration() { return this.duration; }
  void setDuration(Duration duration) { this.duration = duration; }

  int getYear() { return this.year; }
  void setYear(int year) { this.year = year; }

  public String prepareDuration() {
    int minutes = (int) this.duration.getSeconds()/60;
    int seconds = (int) this.duration.getSeconds()%60;
    return minutes + ":" + seconds;
  }

  public String stringify() {
    return this.author + ", \"" + this.title + "\", " + this.prepareDuration() + ", " + this.year;
  }

  @Override
  public SongPrototype Clone() throws CloneNotSupportedException {
    System.out.println("[CLONING]: " + this.stringify());
    return (SongPrototype) this.clone();
  }
}
