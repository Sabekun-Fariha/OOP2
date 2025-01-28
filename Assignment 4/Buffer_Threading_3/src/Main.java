public class Main {
    public static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer(10);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(char c='A'; c<='Z'; c++){
                        buffer.produce(c);
                        Thread.sleep(1000);
                    }
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        }, "Producer");

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0; i<26; i++){
                        buffer.consume();
                        Thread.sleep(1000);
                    }
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        }, "Consumer");


//        Thread producer = new Thread(new Producer(buffer), "Producer");
//        Thread consumer = new Thread(new Consumer(buffer), "Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Producer and Consumer Thread Finished.");
    }

}
