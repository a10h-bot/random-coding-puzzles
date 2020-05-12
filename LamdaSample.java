public class LamdaSample {
    public static void main(String[] args) {
        System.out.println("This is from Parent Thread ~" + Thread.currentThread().getName());
        // typical way to create a thread
        Thread t = new Thread(new Task());
        t.start();
        // Annonymous class way to create a Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is from the child thread again ~" + Thread.currentThread().getName());
            }
        }).start();
        // lamda expression to create a thread
        new Thread(() -> System.out
                .println("This is from Child thread again and again" + Thread.currentThread().getName())).start();

    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("This is from the child thread ~" + Thread.currentThread().getName());
        }
    }
}