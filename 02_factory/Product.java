abstract class Product {
  abstract void create();
}

class Product1 extends Product {
  public void create() {
    System.out.println("Wybrany typ: typ1");
  }
}

class Product2 extends Product {
  public void create() {
    System.out.println("Wybrany typ: typ2");
  }
}

class Product3 extends Product {
  public void create() {
    System.out.println("Wybrany typ: typ3");
  }
}
