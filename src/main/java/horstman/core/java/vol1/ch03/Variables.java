package horstman.core.java.vol1.ch03;

public class Variables {
//    var days = 10;

    public static void main(String[] args) {
        var days = 11;
        var name = "Vasya";
        System.out.println(String.format("Name: %s, days: %s", name, days));
        System.out.println(String.format("Name: %s, days: %d", name, days));
    }
}
