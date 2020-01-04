package Toolkit.Controller;

public class Logger {
    private static Logger mInstance;
    private Logger() {

    }
    public static Logger getInstance() {
        if(mInstance == null) {
            mInstance = new Logger();
        }
        return mInstance;
    }

    public void info(String msg) {
        System.out.println("[INFO]" + msg);
    }

    public void debug(String msg) {
        System.out.println("[DEBUG]" + msg);
    }

    public void warn(String msg) {
        System.out.println("[WARN]" + msg);
    }

    public void error(String msg) {
        System.out.println("[ERROR]" + msg);
    }
}
