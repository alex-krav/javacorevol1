package horstman.core.java.vol1.ch12;

public class ConditionBankTest {
    public static final int NACCOUNTS = 100;
    public static final int INITIAL_BALANCE = 1000;
    public static final int MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new ConditionBank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while(true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((long) (DELAY * Math.random()));
                    }
                } catch (InterruptedException ignored) {}
            };
            var t = new Thread(r);
            t.start();
        }
    }
}
