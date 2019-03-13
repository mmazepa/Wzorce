import java.io.Serializable;

class Factory implements Serializable {
  private static Factory instance;

	private Factory() {
    	System.out.println("Factory(): Inicjalizowanie instacji!");
	}

	public static Factory getInstance() {
		if (instance == null) {
			synchronized(Factory.class) {
				if (instance == null) {
					System.out.println("getInstance(): Pierwsze wywołanie!");
					instance = new Factory();
				}
			}
		}
		return instance;
	}

  public void createProduct(Product p) {
    p.create();
  }

  // public static String createProduct(String productID) {
  //   switch (productID) {
  //     case "product1":
  //       System.out.println("wybrano produkt pierwszy");
  //       break;
  //     case "product2":
  //       System.out.println("wybrano produkt drugi");
  //       break;
  //
  //     // return null;
  //     return "nie ma!";
  //   }
  // }

  protected Object readResolve()
  {
    return instance;
  }
}
