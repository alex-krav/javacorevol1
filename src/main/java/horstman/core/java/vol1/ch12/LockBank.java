package horstman.core.java.vol1.ch12;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();

    public LockBank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) {
        bankLock.lock();

        try {
            if (accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();

        double sum = 0;
        try {
            for (double a : accounts)
                sum += a;
        } finally {
            bankLock.unlock();
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
