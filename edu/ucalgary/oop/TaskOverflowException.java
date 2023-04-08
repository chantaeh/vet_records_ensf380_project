package edu.ucalgary.oop;

/**
 * Custom exception to be used when there are too many tasks
 * assigned to one hour.
 * @author Youssef
 * @version 1.0
 * @since 1.0
 */
public class TaskOverflowException extends Exception {
    /**
     * Constructor for TaskOverflowException
     * @param message
     */
    public TaskOverflowException(String message) {
        super(message);
    }

    
}
