
//uses of executor interface to create threads
import java.util.concurrent.Executor;

public class ExecutorSample {
    public static void main(String[] args) {
        directTask dt = new directTask();
        dt.execute(new runnableTask());
    }
}

class directTask implements Executor {
    @Override
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}

class runnableTask implements Runnable {

    @Override
    public void run() {
        System.out.println("This is from " + Thread.currentThread().getName());
    }

}

