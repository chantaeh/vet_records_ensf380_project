package edu.ucalgary.oop;

/**
 * Fox class, which inherits from the abstract class Nocturnal.
 * Returns required time in mins for feeding, feeding preparation and cage cleaning.
 * @author andrewy94
 * @version 1.0
 * @since 1.0
 */

 public class Fox extends Nocturnal{
    private static final int FEED_MINS = 5;
    private static final int FEED_PREP_MINS = 5;
    private static final int CAGE_CLEAN_MINS = 5;

    public Fox(String name, int numAnimals) {
        super(name, numAnimals);
    }

    public static int getFeedMins() {
        return FEED_MINS;
    }

    public static int getFeedingPrepMins() {
        return FEED_PREP_MINS;
    }

    public static int getCageCleanMins() {
        return CAGE_CLEAN_MINS;
    }
}
