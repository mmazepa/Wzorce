package manager_package;

public class BuilderManager {
  private static boolean isTimeTest = false;

  public void setIsTimeTest(boolean isTimeTest) {
    this.isTimeTest = isTimeTest;
  }
  public static boolean getIsTimeTest() {
    return isTimeTest;
  }

  public static void mainHeader() {
    System.out.println(" _____     _ _   _            _____         _   ");
    System.out.println("| __  |_ _|_| |_| |___ ___   |_   _|___ ___| |_ ");
    System.out.println("| __ -| | | | | . | -_|  _|    | | | -_|_ -|  _|");
    System.out.println("|_____|___|_|_|___|___|_|      |_| |___|___|_|  ");
    System.out.print("\n");
  }

  public static String frameIt(String frame, int times) {
    String pattern = frame;
    while (frame.length() < times) frame += pattern;
    return frame;
  }

  public static void testHeader(String testInfo) {
    System.out.print("╔" + frameIt("═", testInfo.length() + 2) + "╗\n");
    System.out.println("║ " + testInfo + " ║");
    System.out.print("╚" + frameIt("═", testInfo.length() + 2) + "╝\n");
  }

  public static void printWithLinesAround(String text) {
    println("-------------------------------------------------------");
    println(text);
    println("-------------------------------------------------------");
  }

  public static void println(String text) {
    if (!getIsTimeTest())
      System.out.println(text);
  }
}
