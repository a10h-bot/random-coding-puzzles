import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockSample {
    static int count = 0;

    public static void main(final String[] args) {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                sharedResource();
            }
        });
        t1.start();
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
            sharedResource();

        }).start();
        // t2.start();
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                sharedResource();
            }
        });
        t3.start();
    }

    private static void sharedResource() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(count++);
        }

        finally {
            lock.unlock();
        }

    }

}
