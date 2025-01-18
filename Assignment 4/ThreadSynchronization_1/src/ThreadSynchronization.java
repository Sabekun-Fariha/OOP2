import java.sql.SQLOutput;

public class ThreadSynchronization {

    private static Integer sum = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running without synchronization");
        runWithoutSynchronization();

        System.out.println("Running with synchronization");
        runWithSynchronization();
    }

    private static void runWithoutSynchronization(){

        Thread threads[] = new Thread[1000];
        sum = 0;

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    sum++;
                }
            });
        }
        for (Thread i : threads) {
            i.start();
        }
        for (Thread i : threads) {
            try{
                i.join();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum without synchronization: " + sum);
    }

    private static void runWithSynchronization()throws InterruptedException {
        Thread threads[] = new Thread[1000];
        sum = 0;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (sum) {
                    sum++;
                }
            });

        }
        for (Thread i : threads) {
            i.start();
        }
        for (Thread i : threads) {
            i.join();
        }
        System.out.println("Sum with synchronization: " + sum);

    }
}
