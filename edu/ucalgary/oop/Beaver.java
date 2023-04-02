package edu.ucalgary.oop;

/**
 * Beaver class, which inherits from the abstract class Diurnal.
 * Returns required time in mins for feeding, feeding preparation and cage cleaning.
 * @author andrewy94
 * @version 1.0
 * @since 1.0
 */

 public class Beaver extends Diurnal{
    private static final int FEED_MINS = 5;
    private static final int FEEDPREP_MINS = 0;
    private static final int CAGECLEAN_MINS = 5;

    public Beaver(String name, int numAnimals) {
        super(name, numAnimals);
    }

    public static int getFeedMins() {
        return FEED_MINS;
    }

    public static int getFeedingPrepMins() {
        return FEEDPREP_MINS;
    }

    public static int getCageCleanMins() {
        return CAGECLEAN_MINS;
    }
}
