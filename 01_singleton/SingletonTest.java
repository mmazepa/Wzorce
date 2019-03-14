import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class SingletonTest {
  public static HashMap<String, Integer> hm = new HashMap<String, Integer>();
  public static String filename = "instance.ser";

  public static void compareInstances(Singleton instance1, Singleton instance2) {
    System.out.println("[Instance_01]: " + instance1.hashCode());
    System.out.println("[Instance_02]: " + instance2.hashCode());
    System.out.println((instance1.hashCode() == instance2.hashCode()) ? "Identyczne!" : "Różne!");
  }

  public static void compareSetOfInstances() {
    Set<Integer> values = new HashSet<Integer>(hm.values());
    System.out.println((values.size() == 1) ? "Identyczne!" : "Różne!");
  }

  public static Singleton createAndSerialize() throws FileNotFoundException, IOException, ClassNotFoundException {
    Singleton instance = Singleton.getInstance();
    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(instance);
    out.close();
    return instance;
  }

  public static Singleton deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInput in = new ObjectInputStream(new FileInputStream(filename));
    Singleton instance = (Singleton) in.readObject();
    in.close();
    return instance;
  }

  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    System.out.println("\n---[Test1]: SINGLETON TEST ---------------\n");

    Singleton instance1 = Singleton.getInstance();
    Singleton instance2 = Singleton.getInstance();
    compareInstances(instance1, instance2);

    instance1 = null;
    instance2 = null;

    System.out.println("\n---[Test2]: THREAD SAFE TEST -------------\n");

    ThreadTest tt1 = new ThreadTest();
    ThreadTest tt2 = new ThreadTest();
    ThreadTest tt3 = new ThreadTest();

    Thread thread1 = new Thread(tt1, "[Thread_01]");
    Thread thread2 = new Thread(tt2, "[Thread_02]");
    Thread thread3 = new Thread(tt3, "[Thread_03]");
    Thread thread4 = new Thread(tt1, "[Thread_04]");
    Thread thread5 = new Thread(tt1, "[Thread_05]");

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();

    try {
      for (Thread thread : new Thread[] { thread1, thread2, thread3, thread4, thread5 }) {
        thread.join();
      }
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }

    compareSetOfInstances();

    instance1 = null;
    instance2 = null;

    System.out.println("\n---[Test3]: SERIALIZATION TEST -----------\n");

    instance1 = createAndSerialize();
    instance2 = deserialize();
    SingletonTest.compareInstances(instance1, instance2);

    System.out.print("\n");
  }
}
