class SingletonTest {
    public static void compareInstances(Singleton instance1, Singleton instance2) {
        System.out.println("instance1: " + instance1.hashCode());
        System.out.println("instance2: " + instance2.hashCode());

        if (instance1.hashCode() == instance2.hashCode()) {
            System.out.println("Instancje identyczne!");
        } else {
            System.out.println("Instancje różnią się!");
        }
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        compareInstances(instance1, instance2);

        Singleton instance3;
        Singleton instance4;
        new Thread(() -> { instance3 = Singleton.getInstance(); }).start();
        new Thread(() -> { instance4 = Singleton.getInstance(); }).start();
        compareInstances(instance3, instance4);
    }
}