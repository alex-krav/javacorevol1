package horstman.core.java.vol1.ch03;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();
        String username = console.readLine("User name: ");
        char[] password = console.readPassword("Password: ");
        System.out.println(String.format("Name: %s, password: %s", username, password));
    }
}
