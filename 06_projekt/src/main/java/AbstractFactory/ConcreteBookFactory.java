public class ConcreteBookFactory implements BookAbstractFactory {
  private String tag;
  private Author author;
  private String title;
  private int pages;
  private int year;

  public ConcreteBookFactory(String tag, Author author, String title, int pages, int year) {
    this.tag = tag;
    this.author = author;
    this.title = title;
    this.pages = pages;
    this.year = year;
  }

	@Override
	public AbstractBook createBook() {
    System.out.println("-------------------------------------------------------");
    System.out.println("   Trwa \"budowanie\" książki...");
    System.out.println("-------------------------------------------------------");
		return new ConcreteBook(tag, author, title, pages, year);
	}
}
