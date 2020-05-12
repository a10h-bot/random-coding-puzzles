import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// Ways to create threads  
//using class Thread and Interface Runnable
public class myThread {
    public static void main(String[] args) {
        task task1 = new task("taskExecutor");
        task1.start();
        System.out.println(Thread.currentThread().getName());
        Job job = new Job();
        Thread task2 = new Thread(job);
        task2.start();
        TaskDemo callableTask = new TaskDemo();
        FutureTask<Integer> future = new FutureTask<>(callableTask);
        Thread t = new Thread(future);
        t.start();
        try {
            System.out.println(future.get());

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

class task extends Thread {
    public task(String name) {
        super(name);
    }

    public task() {
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Hello World from =>" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Job implements Runnable {

    @Override
    public void run() {
        System.out.println("This is from Thread =>" + Thread.currentThread().getName());

    }

}

class TaskDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 10;
    }
}