public class ConcreteBook extends AbstractBook {
  private String tag;
  private Author author;
  private String title;
  private int pages;
  private int year;

  public ConcreteBook(String tag, Author author, String title, int pages, int year) {
    this.tag = tag;
    this.author = author;
    this.title = title;
    this.pages = pages;
    this.year = year;
  }

  @Override
  public String getTag() {
    return this.tag;
  }

  @Override
  public Author getAuthor() {
    return this.author;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public int getPages() {
    return this.pages;
  }

  @Override
  public int getYear() {
    return this.year;
  }
}
