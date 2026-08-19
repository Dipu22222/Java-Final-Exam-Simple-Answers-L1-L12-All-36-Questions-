// Thread via extending Thread class
class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Thread-A] " + i);
        }
    }
}

// Thread via implementing Runnable
class ThreadB implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Thread-B] " + i);
        }
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        Thread t2 = new Thread(new ThreadB());

        t1.start();
        t2.start();
    }
}
