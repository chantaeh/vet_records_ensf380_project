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
    private static final int FEEDPREP_MINS = 5;
    private static final int CAGECLEAN_MINS = 5;

    private String name;
    private int numAnimals;

    public Fox(String name, int numAnimals) {
        this.name = name;
        this.numAnimals = numAnimals;
    }

    public int getFeedMins() {
        return FEED_MINS;
    }

    public int getFeedinPrepMins() {
        return FEEDPREP_MINS;
    }

    public int getCageCleanMins() {
        return CAGECLEAN_MINS;
    }
}
