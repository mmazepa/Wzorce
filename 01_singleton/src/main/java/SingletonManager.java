import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonManager {
  public static void howManyFrames(String frame, int times) {
    for (int i = 0; i < times; i++) {
      System.out.print(frame);
    }
  }

  public static void testHeader(String testInfo) {
    System.out.print("╔");
    howManyFrames("═", testInfo.length() + 2);
    System.out.print("╗\n");
    System.out.println("║ " + testInfo + " ║");
    System.out.print("╚");
    howManyFrames("═", testInfo.length() + 2);
    System.out.print("╝\n");
  }

  public static void displayHashCodes(Singleton instance1, Singleton instance2) {
      System.out.println("Instance 1: " + instance1.hashCode());
      System.out.println("Instance 2: " + instance2.hashCode());
  }

  public static void serialize(Singleton instance, String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(instance);
    out.close();
  }

  public static Singleton deserialize(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInput in = new ObjectInputStream(new FileInputStream(filename));
    Singleton instance = (Singleton) in.readObject();
    in.close();
    return instance;
  }
}
