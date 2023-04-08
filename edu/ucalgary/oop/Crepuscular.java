package edu.ucalgary.oop;

/**
 * Abstract class for Crepuscular animals. Gives int array of feeding hours.
 * @author chantaeh 
 * @version 1.1
 * @since 1.0
 */
abstract class Crepuscular extends Animal{
    private static final int FEED_START_HOUR = 19;

    /**
     * Constructor for Crepuscular class
     * @param nickname
     * @param numAnimals
     */
    public Crepuscular(String nickname, int numAnimals) {
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
