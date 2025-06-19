public class Logger {

    // Private static variable to hold the single instance of the class
    private static Logger instance;
    
    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created");
    }
    
    /**
     * Public static method to get the single instance of Logger
     * @return The single instance of Logger
     */
    public static Logger getInstance() {
        // Lazy initialization: create the instance only when it's accessed for the first time
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    /*
    /* Method to log messages
     * @param message The message to log
     */
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
    
    /*
    // Prevent cloning of the singleton instance
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    // Prevent deserialization from creating new instances
    protected Object readResolve() {
        return instance;
    }
    */
}
