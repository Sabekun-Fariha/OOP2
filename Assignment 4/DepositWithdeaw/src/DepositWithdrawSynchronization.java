import java.util.concurrent.ThreadLocalRandom;

class Account{
    private int balance;

    Account(int balance){
        this.balance = balance;
    }

    public synchronized void deposit(int amount){
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " deposit " + amount + " , Balance:  " + balance);
    }

    public synchronized void withdraw(int amount){
        if(balance >= amount){
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " withdraw " + amount + " , Balance:  " + balance);
        }
        else{
            System.out.println("Insufficient Funds");
        }
    }

    public synchronized int getBalance(){
        return balance;
    }
}

public class DepositWithdrawSynchronization {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);

        Thread depositTask = new Thread(new Runnable() {
            public void run() {
                int amount = ThreadLocalRandom.current().nextInt(1, 1000);
                account.deposit(amount);
            }
        }, "Deposit Thread");

        Thread withdrawTask = new Thread(new Runnable() {
            public void run() {
                int amount = ThreadLocalRandom.current().nextInt(1, 1000);
                account.withdraw(amount);
            }
        }, "Withdraw Thread");

        depositTask.start();
        withdrawTask.start();

        depositTask.join();
        withdrawTask.join();

        System.out.println("Total Balance after deposit & withdraw: " + account.getBalance());
    }
}
