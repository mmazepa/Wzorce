import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ClassRegisterReflectionFactory {

  private static ClassRegisterReflectionFactory factory;
  private HashMap registeredJuices = new HashMap();

  private ClassRegisterReflectionFactory() { }

  public static ClassRegisterReflectionFactory getInstance() {
    if (factory == null) {
      synchronized (ClassRegisterReflectionFactory.class) {
        if (factory == null) {
          factory = new ClassRegisterReflectionFactory();
        }
      }
    }
    return factory;
  }

  public void registerJuice(JuiceType type, Class juiceClass) {
    registeredJuices.put(type, juiceClass);
  }

  public Juice createJuice(JuiceType type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class juiceClass = (Class) registeredJuices.get(type);
    Constructor juiceConstructor = juiceClass.getDeclaredConstructor(new Class[] {});
    return (Juice) juiceConstructor.newInstance(new Object[] { });
  }

  public Juice makeJuice(JuiceType type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Juice juice = factory.createJuice(type);
    return juice;
  }
}
