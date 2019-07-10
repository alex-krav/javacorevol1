package horstman.core.java.vol1.ch08;

import java.time.LocalDate;

public class TranslatingGenericMethods {
    public static void main(String[] args) {
        var interval = new DateInterval(
                LocalDate.of(2000, 3, 4),
                LocalDate.of(2000, 5, 6)
        );
        Pair<LocalDate> pair = interval; // OK--assignment to superclass
        pair.setSecond(LocalDate.of(2000, 1, 2));
        pair.getSecond();
    }
}

class DateInterval extends Pair<LocalDate> {
    public DateInterval(LocalDate from, LocalDate to) {
        super(from, to);
    }

    public void setSecond(LocalDate second) {
        System.out.println("DateInterval.setSecond");
        if (second.compareTo(getFirst()) >= 0)
            super.setSecond(second);
    }

    public LocalDate getSecond() {
        System.out.println("DateInterval.getSecond");
        return super.getSecond();
    }
}