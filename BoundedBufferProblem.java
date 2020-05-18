public class BoundedBufferProblem{
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            sample.produce();
        })
        Thread t2 = new Thread(()->{
            sample.consume();
        })

        t1.start();
        t2.start();

        
    }

    static class sample{
        public void produce(){

        }

        public void consume(){

        }
    }
}