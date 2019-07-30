package horstman.core.java.vol1.ch12;

import java.util.Arrays;

public class SyncBlockBank {
    private final double[] accounts;

    public SyncBlockBank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        synchronized (accounts) {
            while (accounts[from] < amount)
                accounts.wait();

            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            accounts.notifyAll();
        }
    }

    public double getTotalBalance() {
        synchronized (accounts) {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        }
    }

    public int size() {
        return accounts.length;
    }
}
