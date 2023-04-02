package edu.ucalgary.oop;

/**
 * Abstract class for Diurnal animals. Gives int array of feeding hours.
 * @author chantaeh 
 * @version 1.0
 * @since 1.0
 */
public abstract class Diurnal extends Animal{
    private static final int FEED_START_HOUR = 8;

    public Diurnal(String nickname, int numAnimals) {
        super(nickname, numAnimals);
    }

    public static int getFeedStartHour() {
        return FEED_START_HOUR;
    }
}
