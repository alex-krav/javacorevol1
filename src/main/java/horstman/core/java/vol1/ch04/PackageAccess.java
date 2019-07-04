package horstman.core.java.vol1.ch04;

/**
 * The javac compiler always looks for files in the current directory,
 * but the java virtual machine launcher only looks into the current directory
 * if the “.” directory is on the class path.
 *
 * If you have no class path set, it’s not a problem — the default class path consists
 * of the “.” directory. But if you have set the class path and forgot to include
 * the “.” directory, your programs will compile without error, but they won’t run.
 *
 * Preferred:
 * - classpath
 * - cp
 * --class-path
 *
 * java -classpath /home/user/classdir:.:/home/user/archives/archive.jar MyProg
 * java -classpath c:\classdir;.;c:\archives\archive.jar MyProg
 *
 * Alternate:
 * export CLASSPATH=/home/user/classdir:.:/home/user/archives/archive.jar
 * set CLASSPATH=c:\classdir;.;c:\archives\archive.jar
 */
public class PackageAccess {
    private String privateStr;
    protected String protectedStr;
    String packageStr;
    public String publicStr;
}
