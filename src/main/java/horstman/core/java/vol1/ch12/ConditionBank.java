package horstman.core.java.vol1.ch12;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public ConditionBank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " entering transfer()");

        bankLock.lock();
        try {
            while (accounts[from] < amount)
                sufficientFunds.await();

            System.out.println(Thread.currentThread().getName() + " continuous after condition.await()");
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

            System.out.println(Thread.currentThread().getName() + " is about to call condition.signallAll()");
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {

        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}
