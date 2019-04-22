import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class Product {
  private String productType;
  private Map<String, String> parts = new HashMap<String, String>();

  public Product(String productType) {
    this.productType = productType;
  }

  public void setPart(String partKey, String partValue) {
    parts.put(partKey, partValue);
  }

  public void displayAllParts() {
    Iterator it = parts.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println("   " + pair.getKey() + ": " + pair.getValue());
    }
  }

  public void show() {
    System.out.println("---------------------------");
    System.out.println("Typ produktu: " + productType);
    displayAllParts();
  }
}
