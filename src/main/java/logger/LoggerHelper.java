package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * LoggerHelper is a utility class to provide a logger instance for any class.
 * It uses Log4j2 for logging.
 */
public class LoggerHelper {

    /**
     * Get a logger instance for the specified class.
     *
     * @param clazz the class for which the logger is required
     * @return a Logger instance
     */
    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}