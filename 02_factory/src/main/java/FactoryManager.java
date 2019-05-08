import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

enum FrameType {
  TOP, MIDDLE, BOTTOM
}

public class FactoryManager {
  public static void mainHeader() {
    System.out.println(" _____         _                     _____         _   ");
    System.out.println("|   __|___ ___| |_ ___ ___ _ _      |_   _|___ ___| |_ ");
    System.out.println("|   __| .'|  _|  _| . |  _| | |       | | | -_|_ -|  _|");
    System.out.println("|__|  |__,|___|_| |___|_| |_  |       |_| |___|___|_|  ");
    System.out.println("                          |___|                        ");
  }

  public static String horiz(String frame, int times) {
    String pattern = frame;
    while (frame.length() < times) frame += pattern;
    return frame;
  }

  public static void testHeader(String testInfo) {
    System.out.print("╔" + horiz("═", testInfo.length() + 2) + "╗\n");
    System.out.println("║ " + testInfo + " ║");
    System.out.print("╚" + horiz("═", testInfo.length() + 2) + "╝\n");
  }

  public static void printFrame(FrameType type, int val1, int val2, int val3) {
    String first = new String();
    String middle = new String();
    String last = new String();
    String line = new String();

    if (type == FrameType.TOP) {
      first = "┏";
      middle = "┳";
      last = "┓";
      line = "━";
    } else if (type == FrameType.MIDDLE) {
      first = "┣";
      middle = "╇";
      last = "┫";
      line = "━";
    } else if (type == FrameType.BOTTOM) {
      first = "┗";
      middle = "┷";
      last = "┛";
      line = "━";
    }

    System.out.print("   " + first + horiz(line, val1) + middle + horiz(line, val2) + middle + horiz(line, val3) + last + "\n");
  }

  public static void printResults(Object[][] results) {
    printFrame(FrameType.TOP, 6, 31, 9);
    System.out.format("   ┃ %4s ┃ %29s ┃ %7s ┃\n", new String[] { "L.P.", "TESTOWANA FABRYKA", "CZAS" });
    printFrame(FrameType.MIDDLE, 6, 31, 9);
    for (int i = 0; i < results.length; i++)
      System.out.format("   ┃ %4s │ %29s │ %7s ┃\n", results[i]);
    printFrame(FrameType.BOTTOM, 6, 31, 9);
  }
}
