import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.lang.reflect.InvocationTargetException;

public class ClassRegisterNoReflectionFactory {

  private static ClassRegisterNoReflectionFactory factory;
  private Map<JuiceType, Supplier<? extends Juice>> registeredJuices = new HashMap();

  private ClassRegisterNoReflectionFactory() { }

  public static ClassRegisterNoReflectionFactory getInstance() {
    if (factory == null) {
      synchronized (ClassRegisterNoReflectionFactory.class) {
        if (factory == null) {
          factory = new ClassRegisterNoReflectionFactory();
        }
      }
    }
    return factory;
  }

  public void registerJuice(JuiceType type, Supplier<? extends Juice> supplier) {
    registeredJuices.put(type, supplier);
  }

  public Juice createJuice(JuiceType type) {
    Supplier<? extends Juice> juice = registeredJuices.get(type);
    return juice != null ? juice.get() : null;
  }

  public Juice makeJuice(JuiceType type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Juice juice = factory.createJuice(type);
    return juice;
  }
}
