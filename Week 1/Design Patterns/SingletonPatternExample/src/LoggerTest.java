public class LoggerTest {
    public static void main(String[] args) {
        // Get the first instance
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");
        
        // Get the second instance
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");
        
        // Verify both references point to the same object
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
        
        /*
        // Test with threads to verify thread safety
        Thread thread1 = new Thread(() -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.log("Message from Thread 1");
            System.out.println("Thread 1 Logger instance: " + threadLogger.hashCode());
        });
        
        Thread thread2 = new Thread(() -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.log("Message from Thread 2");
            System.out.println("Thread 2 Logger instance: " + threadLogger.hashCode());
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Main thread instance
        System.out.println("Main thread Logger instance: " + logger1.hashCode());
        */
    }
}