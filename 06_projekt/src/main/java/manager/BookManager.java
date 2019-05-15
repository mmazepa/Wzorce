import java.util.Map;
import java.util.HashMap;

class BookManager {
  private static Map<String, Prototype> books = new HashMap<String, Prototype>();

  public static Prototype getBook(String key) {
    return books.get(key);
  }

  public static void setBook(String key, Prototype bookPrototype) {
    books.put(key, bookPrototype);
  }

  public static Map<String, Prototype> getAllBooks() {
    return books;
  }

  public static void displayBoth(String typeOfCopy, Book originalBook, Book clonedBook) {
    String original = "   [Oryginał]: ";
    typeOfCopy = "   [" + typeOfCopy + "Copy]: ";
    while (original.length() < typeOfCopy.length()) original += " ";
    System.out.println(original + originalBook.toString());
    System.out.println(typeOfCopy + clonedBook.toString());
  }
}
