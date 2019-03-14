class ThreadTest implements Runnable {
  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    int hashCode = Singleton.getInstance().hashCode();
    SingletonTest.hm.put(threadName, hashCode);
    System.out.println(threadName + " : " + hashCode);
  }
}
