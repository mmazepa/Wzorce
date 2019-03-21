import java.io.Serializable;

class FactoryMethod implements Serializable {
  private static FactoryMethod factory;

	private FactoryMethod() {
    	System.out.println("FactoryMethod(): Inicjalizowanie instacji.");
	}

	public static FactoryMethod getInstance() {
		if (factory == null) {
			synchronized(FactoryMethod.class) {
				if (factory == null) {
					System.out.println("getInstance(): Pierwsze wywołanie.");
					factory = new FactoryMethod();
				}
			}
		}
		return factory;
	}

  //...

  protected Object readResolve() {
    if (factory == null) factory = this;
    return factory;
  }
}
