class DisplayManager {
  public static void mainHeader() {
    System.out.println(" _____         _       _             _____         _   ");
    System.out.println("|  _  |___ ___| |_ ___| |_ _ _ ___ _|_   _|___ ___| |_ ");
    System.out.println("|   __|  _| . |  _| . |  _| | | . | -_| | | -_|_ -|  _|");
    System.out.println("|__|  |_| |___|_| |___|_| |_  |  _|___|_| |___|___|_|  ");
    System.out.println("                          |___|_|                       ");
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
}
