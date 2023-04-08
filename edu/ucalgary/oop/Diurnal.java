package edu.ucalgary.oop;

/**
 * Abstract class for Diurnal animals. Gives int array of feeding hours.
 * @author chantaeh 
 * @version 1.0
 * @since 1.0
 */
abstract class Diurnal extends Animal{
    private static final int FEED_START_HOUR = 8;

    /**
     * Constructor for Diurnal class
     * @param nickname
     * @param numAnimals
     */

    public Diurnal(String nickname, int numAnimals) {
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
