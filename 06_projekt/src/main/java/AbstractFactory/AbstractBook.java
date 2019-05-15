public abstract class AbstractBook {
  public abstract String getTag();
  public abstract Author getAuthor();
  public abstract String getTitle();
  public abstract int getPages();
  public abstract int getYear();

  @Override
  public String toString() {
    return this.getAuthor().toString() + ", \"" + this.getTitle() + "\", " + this.getPages() + ", " + this.getYear();
  }
}
