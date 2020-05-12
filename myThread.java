import java.util.concurrent.Callable;

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

class TaskDemo implements Callable {
    @Override
    public Integer call() {
        return 10;
    }
}