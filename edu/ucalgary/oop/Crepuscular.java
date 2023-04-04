package edu.ucalgary.oop;

/**
 * Abstract class for Crepuscular animals. Gives int array of feeding hours.
 * @author chantaeh 
 * @version 1.0
 * @since 1.0
 */
abstract class Crepuscular extends Animal{
    private static final int FEED_START_HOUR = 19;

    public Crepuscular(String nickname, int numAnimals) {
        super(nickname, numAnimals);
    }

    public static int getFeedStartHour() {
        return FEED_START_HOUR;
    }
}
