package edu.ucalgary.oop;

/**
 * Abstract class for Nocturnal animals. Gives int array of feeding hours.
 * @author chantaeh
 * @author andrewy94
 * @author Youssef
 * @author Tony
 * @version 1.1
 * @since 1.0
 */
abstract class Nocturnal extends Animal{
    private static final int FEED_START_HOUR = 0;

    /**
     * Constructor for Nocturnal class
     * @param nickname
     * @param numAnimals
     */
    public Nocturnal(String nickname, int numAnimals) {
        super(nickname, numAnimals);
    }

    /**
     * Getter for FEED_START_HOUR
     * @return FEED_START_HOUR
     */
    public static int getFeedStartHour() {
        return FEED_START_HOUR;
    }
}
