import java.io.Serializable;

abstract class FactoryMethod implements Serializable {
  protected FactoryMethod factory;

  protected abstract FactoryMethod getInstance();

  protected abstract Juice makeJuice(String type);
  protected abstract Beer makeBeer(String type);
  protected abstract Tea makeTea(String type);

  protected Object readResolve() {
    factory = this;
    return factory;
  }
}
