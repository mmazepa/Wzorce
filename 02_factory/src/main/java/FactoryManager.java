import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FactoryManager {
  public static void mainHeader() {
    System.out.println(" _____         _                     _____         _   ");
    System.out.println("|   __|___ ___| |_ ___ ___ _ _      |_   _|___ ___| |_ ");
    System.out.println("|   __| .'|  _|  _| . |  _| | |       | | | -_|_ -|  _|");
    System.out.println("|__|  |__,|___|_| |___|_| |_  |       |_| |___|___|_|  ");
    System.out.println("                          |___|                        ");
  }

  public static String howManyFrames(String frame, int times) {
    String pattern = frame;
    while (frame.length() < times) frame += pattern;
    return frame;
  }

  public static void testHeader(String testInfo) {
    System.out.print("╔" + howManyFrames("═", testInfo.length() + 2) + "╗\n");
    System.out.println("║ " + testInfo + " ║");
    System.out.print("╚" + howManyFrames("═", testInfo.length() + 2) + "╝\n");
  }

  public static void displayHashCodes(Object factory1, Object factory2) {
      System.out.println("Instance 1: " + factory1.hashCode());
      System.out.println("Instance 2: " + factory2.hashCode());
  }

  // public static void displayHashCodes(SimpleFactory factory1, SimpleFactory factory2) {
  //     System.out.println("Instance 1: " + factory1.hashCode());
  //     System.out.println("Instance 2: " + factory2.hashCode());
  // }
  //
  // public static void displayHashCodes(FactoryMethod factory1, FactoryMethod factory2) {
  //     System.out.println("Instance 1: " + factory1.hashCode());
  //     System.out.println("Instance 2: " + factory2.hashCode());
  // }
}
