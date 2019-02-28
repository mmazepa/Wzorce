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
        Singleton firstInstance = Singleton.getInstance();
        Singleton secondInstance = Singleton.getInstance();
        compareInstances(firstInstance, secondInstance);
    }
}