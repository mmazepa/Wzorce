import java.io.Serializable;

abstract class FactoryMethod implements Serializable {
  private static FactoryMethod factory;

	// private FactoryMethod() {
  public FactoryMethod() { }

	public static FactoryMethod getInstance() {
		if (factory == null) {
			synchronized(FactoryMethod.class) {
				if (factory == null) {
					// factory = new FactoryMethod();
				}
			}
		}
		return factory;
	}

  protected abstract Juice makeJuice(String type);
  protected abstract Beer makeBeer(String type);
  protected abstract Tea makeTea(String type);

  protected Object readResolve() {
    factory = this;
    return factory;
  }
}
