import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LibraryTest {
  static Author author1;
  static Author author2;
  static Author author3;

  static String tag1 = "beedle";
  static String tag2 = "jezioro";
  static String tag3 = "dreamcatcher";

  static Book book1;
  static Book book2;
  static Book book3;

  static String libraryTag = "gdansk_library";
  static String libraryName = "CzytaMY, bo lubiMY!";
  static Library library;

  static DisplayManager dm = new DisplayManager();
  static BookManager sm = new BookManager();
  static LibraryManager msm = new LibraryManager();

  @BeforeClass
  public static void setUpClass() {
    dm.mainHeader();
    System.out.println("Rozpoczęcie testowania...");
  }

  @AfterClass
  public static void tearDownClass() {
    dm.horizontalLine(55);
    System.out.println("Testowanie zakończone.");
    System.out.print("\n");
  }

  @Before
  public void setUp() {
    author1 = new Author("Joanne Kathleen", "Rowling");
    author2 = new Author("Krystyna", "Siesicka");
    author3 = new Author("Stephen", "King");

    book1 = new Book(tag1, author1, "Baśnie Barda Beedle'a", 144, 2008);
    book2 = new Book(tag2, author2, "Jezioro osobliwości", 160, 1999);
    book3 = new Book(tag3, author3, "Łowca snów", 768, 2001);

    sm.setBook(tag1, book1);
    sm.setBook(tag2, book2);
    sm.setBook(tag3, book3);

    ArrayList<Book> books = new ArrayList<Book>();
    books.add(book1);
    books.add(book2);
    books.add(book3);

    library = new Library(libraryTag, libraryName, books);
    msm.setLibrary(libraryTag, library);

    dm.horizontalLine(55);
  }

  @After
  public void tearDown() {
    // dm.horizontalLine(55);
  }

  @Test
  public void book_shallowCopyTest() throws CloneNotSupportedException {
    dm.testHeader("Zad1. (Book) Shallow Copy Test");

    Book book1_shallowCopy = (Book) sm.getBook(book1.getTag()).ShallowCopy();
    book1.getAuthor().setFirstName("Jadwiga");
    sm.displayBoth("Shallow", book1, book1_shallowCopy);
    assertEquals(book1.getAuthor(), book1_shallowCopy.getAuthor());
    assertSame(book1.getAuthor(), book1_shallowCopy.getAuthor());

    Book book2_shallowCopy = (Book) sm.getBook(book2.getTag()).ShallowCopy();
    book2.getAuthor().setLastName("Młody");
    sm.displayBoth("Shallow", book2, book2_shallowCopy);
    assertEquals(book2.getAuthor(), book2_shallowCopy.getAuthor());
    assertSame(book2.getAuthor(), book2_shallowCopy.getAuthor());

    Book book3_shallowCopy = (Book) sm.getBook(book3.getTag()).ShallowCopy();
    book3.getAuthor().setFirstName("Stefan");
    book3.getAuthor().setLastName("Król");
    sm.displayBoth("Shallow", book3, book3_shallowCopy);
    assertEquals(book3.getAuthor(), book3_shallowCopy.getAuthor());
    assertSame(book3.getAuthor(), book3_shallowCopy.getAuthor());
  }

  @Test
  public void book_deepCopyTest() throws CloneNotSupportedException {
    dm.testHeader("Zad1. (Book) Deep Copy Test");

    Book book1_deepCopy = (Book) sm.getBook(book1.getTag()).DeepCopy();
    book1.getAuthor().setFirstName("Jadwiga");
    sm.displayBoth("Deep", book1, book1_deepCopy);
    assertNotEquals(book1.getAuthor(), book1_deepCopy.getAuthor());
    assertNotSame(book1.getAuthor(), book1_deepCopy.getAuthor());

    Book book2_deepCopy = (Book) sm.getBook(book2.getTag()).DeepCopy();
    book2.getAuthor().setLastName("Młody");
    sm.displayBoth("Deep", book2, book2_deepCopy);
    assertNotEquals(book2.getAuthor(), book2_deepCopy.getAuthor());
    assertNotSame(book2.getAuthor(), book2_deepCopy.getAuthor());

    Book book3_deepCopy = (Book) sm.getBook(book3.getTag()).DeepCopy();
    book3.getAuthor().setFirstName("Stefan");
    book3.getAuthor().setLastName("Król");
    sm.displayBoth("Deep", book3, book3_deepCopy);
    assertNotEquals(book3.getAuthor(), book3_deepCopy.getAuthor());
    assertNotSame(book3.getAuthor(), book3_deepCopy.getAuthor());
  }

  @Test
  public void library_shallowCopyTest() throws CloneNotSupportedException {
    dm.testHeader("Zad2. (Library) Shallow Copy Test");

    Library library_shallowCopy = (Library) msm.getLibrary(library.getTag()).ShallowCopy();
    library.getBooks().get(0).getAuthor().setFirstName("Flobby");
    System.out.print("───[ORYGINAŁ]──────────────────────────────────────────");
    System.out.println(library.toString());
    System.out.print("───[SHALLOW COPY]──────────────────────────────────────");
    System.out.println(library_shallowCopy.toString());

    Author original = library.getBooks().get(0).getAuthor();
    Author shallowCopy = library_shallowCopy.getBooks().get(0).getAuthor();
    assertEquals(original, shallowCopy);
    assertSame(original, shallowCopy);
  }

  @Test
  public void library_deepCopyTest() throws CloneNotSupportedException {
    dm.testHeader("Zad2. (Library) Deep Copy Test");

    Library library_deepCopy = (Library) msm.getLibrary(library.getTag()).DeepCopy();
    library.getBooks().get(0).getAuthor().setFirstName("Flobby");
    System.out.print("───[ORYGINAŁ]──────────────────────────────────────────");
    System.out.println(library.toString());
    System.out.print("───[DEEP COPY]─────────────────────────────────────────");
    System.out.println(library_deepCopy.toString());

    Author original = library.getBooks().get(0).getAuthor();
    Author deepCopy = library_deepCopy.getBooks().get(0).getAuthor();
    assertNotEquals(original, deepCopy);
    assertNotSame(original, deepCopy);
  }
}
