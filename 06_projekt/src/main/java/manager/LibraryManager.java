import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class LibraryManager {
  private static Map<String, Prototype> libraries = new HashMap<String, Prototype>();

  public static Prototype getLibrary(String key) {
    return libraries.get(key);
  }

  public static void setLibrary(String key, Prototype libraryPrototype) {
    libraries.put(key, libraryPrototype);
  }

  public static Map<String, Prototype> getAllLibrarys() {
    return libraries;
  }

  public static void displayBoth(String typeOfCopy, Library originalLibrary, Library clonedLibrary) {
    String original = "   [Oryginał]: ";
    typeOfCopy = "   [" + typeOfCopy + "Copy]: ";
    while (original.length() < typeOfCopy.length()) original += " ";
    System.out.println(original + originalLibrary.toString());
    System.out.println(typeOfCopy + clonedLibrary.toString());
  }
}
