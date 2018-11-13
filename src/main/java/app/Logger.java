package app;

public class Logger
{
    private static Logger uniqueInstance = new Logger();

    private Logger() { }

    public static Logger getInstance() {
        return uniqueInstance;
    }

    public void log(String msg) {
        System.out.println("[Log] " + msg);
    }
}
