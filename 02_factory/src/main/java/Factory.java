import java.io.Serializable;

class Factory implements Serializable {
  private static Factory factory;

	private Factory() {
    	System.out.println("Factory(): Inicjalizowanie instacji.");
	}

	public static Factory getFactory() {
		if (factory == null) {
			synchronized(Factory.class) {
				if (factory == null) {
					System.out.println("getFactory(): Pierwsze wywołanie.");
					factory = new Factory();
				}
			}
		}
		return factory;
	}

  protected Object readResolve() {
    if (factory == null) factory = this;
    return factory;
  }
}
