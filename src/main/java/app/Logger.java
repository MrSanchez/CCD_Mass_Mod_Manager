package app;

public class Logger
{
    private static Logger uniqueInstance = new Logger();

    private Logger() { }

    public static Logger getInstance() {
        return uniqueInstance;
    }

    public void logMessage(String msg) {
        System.out.println(msg);
    }
}
