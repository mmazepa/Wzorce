class Singleton {
    
	private static Singleton instance;

	private Singleton() {
    	System.out.println("Singleton(): Inicjalizowanie instacji!");
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized(Singleton.class) {
				if (instance == null) {
					System.out.println("getInstance(): Pierwsze wywołanie!");
					instance = new Singleton();
				}
			}            
		}
		return instance;
	}
}