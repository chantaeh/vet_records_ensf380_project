package edu.ucalgary.oop;

/**
 * Abstract class for Nocturnal animals. Gives int array of feeding hours.
 * @author chantaeh 
 * @version 1.0
 * @since 1.0
 */
abstract class Nocturnal extends Animal{
    private static final int FEED_START_HOUR = 0;

    public Nocturnal(String nickname, int numAnimals) {
        super(nickname, numAnimals);
    }

    public static int getFeedStartHour() {
        return FEED_START_HOUR;
    }
}
