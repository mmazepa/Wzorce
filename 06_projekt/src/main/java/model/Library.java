import java.util.ArrayList;

class Library extends Prototype implements Cloneable {
  private String tag;
  private String name;
  private ArrayList<Book> books;

  public Library(String tag, String name, ArrayList<Book> books) {
    this.tag = tag;
    this.name = name;
    this.books = books;
  }

  public Library(Library library) throws CloneNotSupportedException {
    this(library.getTag(), library.getName(), library.prepareClonedBooks(library));
  }

  String getTag() { return this.tag; }
  void setTag(String tag) { this.tag = tag; }

  String getName() { return this.name; }
  void setName(String name) { this.name = name; }

  ArrayList<Book> getBooks() { return this.books; }
  void setBooks(ArrayList<Book> books) { this.books = books; }

  public ArrayList<Book> prepareClonedBooks(Library library) throws CloneNotSupportedException {
    ArrayList<Book> books = new ArrayList<Book>();
    for (Book book : library.getBooks()) {
      books.add((Book) book.DeepCopy());
    }
    return books;
  }

  public String toString() {
    String generalInfo = "\n   Biblioteka \"" + this.name + "\"\n";
    int booksCounter = 1;
    generalInfo += "      LISTA KSIĄŻEK:";
    for (Book book : books) {
      generalInfo += "\n         " + (booksCounter++) + ". " + book.toString();
    }
    return generalInfo;
  }

  @Override
  public Object ShallowCopy() throws CloneNotSupportedException {
    System.out.println("[SHALLOW COPYING]: " + this.toString());
    return (Prototype) this.clone();
  }

  @Override
  public Object DeepCopy() throws CloneNotSupportedException {
    System.out.println("[DEEP COPYING]: " + this.toString());
    return (Prototype) new Library(this);
  }
}
