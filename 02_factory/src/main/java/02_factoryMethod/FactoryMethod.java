import java.io.Serializable;

abstract class FactoryMethod implements Serializable {
  protected FactoryMethod factory;

  protected abstract FactoryMethod getInstance();

  protected abstract Juice makeJuice(JuiceType type);
  protected abstract Beer makeBeer(BeerType type);
  protected abstract Tea makeTea(TeaType type);

  protected Object readResolve() {
    factory = this;
    return factory;
  }
}
