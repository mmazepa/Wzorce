import java.util.ArrayList;

class Product {
  private String productType;
  private String part1;
  private String part2;
  private String part3;
  private String part4;
  private String part5;

  public Product(String productType) {
    this.productType = productType;
  }

  public void Show() {
    System.out.println("\n---------------------------");
    System.out.println("Product Type: " + productType);
    System.out.println("  Part1: " + part1);
    System.out.println("  Part2: " + part2);
    System.out.println("  Part3: " + part3);
    System.out.println("  Part4: " + part4);
    System.out.println("  Part5: " + part5);
  }
}
