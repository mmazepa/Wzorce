public class SpeakerSetBuilderManager {
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

  public static void printWithLineAbove(String text) {
    System.out.println("-------------------------------------------------------");
    System.out.println(text);
  }
}
