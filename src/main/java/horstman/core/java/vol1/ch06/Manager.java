package horstman.core.java.vol1.ch06;

public class Manager extends Employee implements Cloneable {

    private double bonus;

    /**
     * @param name   the employee's name
     * @param salary the salary
     * @param year   the hire year
     * @param month  the hire month
     * @param day    the hire day
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }

    /*@Override
    public String getProtectedName() {

    }*/

    @Override
    protected Manager clone() throws CloneNotSupportedException {
        return (Manager) super.clone();
    }

    @Override
    public String toString() {
        return "name="+getName()+", bonus="+bonus;
    }
}