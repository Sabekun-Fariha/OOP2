import java.io.IOException;

public class BkashCredit {
    public static void main(String[]args) throws Exception {
        BkashAccount b = new BkashAccount();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                b.setBalance(5000);
            }
        }, "Agent 1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                b.setBalance(2000);
            }
        }, "Agent 2");
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                b.setBalance(1000);
            }
        }, "Agent 3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println( "Total balance is : " + b.getBalance());
    }


}
class BkashAccount{
    private int balance;
    public synchronized int getBalance(){
        return balance;
    }
    public synchronized void setBalance(int balance){
        this.balance = this.balance+ balance;
        System.out.println(Thread.currentThread().getName()+" credited & Balance = " + this.balance);
    }
}
