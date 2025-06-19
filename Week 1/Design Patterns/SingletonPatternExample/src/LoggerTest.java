public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");
        
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
    }
}
