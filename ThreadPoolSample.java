
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSample {
    public static void main(final String[] args) {
        // We can submii Runnable task to the Executor Service
        final ExecutorService executeEngine = Executors.newFixedThreadPool(3);
        final ExecutorService executeEngine2 = Executors.newCachedThreadPool();

        executeEngine.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("This is demo task !" + Thread.currentThread().getName());
            }
        });

        executeEngine.execute(new MyTask());
        executeEngine2.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("This is from different thread pool " + Thread.currentThread().getName());
            }
        });

    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("This is from child Thread -> " + Thread.currentThread().getName());

    }

}
