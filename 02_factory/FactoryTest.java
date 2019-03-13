class FactoryTest {
  public static void main(String[] args) {
    Factory factory = Factory.getInstance();
    Product product;

    product = new Product1();
    factory.createProduct(product);

    product = new Product2();
    factory.createProduct(product);

    product = new Product3();
    factory.createProduct(product);
  }
}
