public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // private constructor prevents external instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance: " + this.hashCode());
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.showMessage();
        s2.showMessage();
        System.out.println("Same instance? " + (s1 == s2));
    }
}
