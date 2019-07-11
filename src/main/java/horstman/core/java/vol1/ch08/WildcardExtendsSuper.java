package horstman.core.java.vol1.ch08;

import java.time.LocalDate;

public class WildcardExtendsSuper {
    public static void main(String[] args) {
        var managerBuddies = new Pair5<Manager3>(new Manager3("ceo"), new Manager3("cfo"));
        Pair5<? extends Employee3> wildcardBuddies = managerBuddies; // OK
//        wildcardBuddies.setFirst(new Employee3("Vasya"));

        min1(new LocalDate[2]);
        min2(new LocalDate[2]);
    }

    public static void printBuddies(Pair5<? extends Employee3> p) {
        Employee3 first = p.getFirst();
        Employee3 second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager3[] a, Pair5<? super Manager3> result) {
        if (a.length == 0) return;
        Manager3 min = a[0];
        Manager3 max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static <T extends Comparable<T>> T min1(T[] a) { //can pass String
        return a[0];
    }

    public static <T extends Comparable<? super T>> T min2(T[] a) { // can pass LocalDate
        return a[0];
    }
}

class Employee3 {
    private String name;
    private int salary;
    private LocalDate startDate;

    public Employee3(String name) {
        this.name = name;
    }

    public Employee3(String name, int salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.startDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

class Manager3 extends Employee3 {

    private int bonus;

    public Manager3(String name, int salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public Manager3(String name) {
        super(name);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

//class Pair5<? extends Employee3> {}

class Pair5<T>  {
    private T first;
    private T second;

    public Pair5() {
        first = null;
        second = null;
    }

    public Pair5(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}