package edu.ucalgary.oop;

/**
 * Fox class, which inherits from the abstract class Crepuscular.
 * Returns required time in mins for feeding, feeding preparation and cage cleaning.
 * @author chantaeh
 * @author andrewy94
 * @author Youssef
 * @author Tony
 * @version 1.0
 * @since 1.0
 */

 public class Porcupine extends Crepuscular{
    private static final int FEED_MINS = 5;
    private static final int FEEDING_PREP_MINS = 0;
    private static final int CAGE_CLEAN_MINS = 10;

    /**
     * Constructor for Porcupine class
     * @param name
     * @param numAnimals
     */
    public Porcupine(String name, int numAnimals) {
        super(name, numAnimals);
    }

    /**
     * Getter for FEED_MINS
     * @return FEED_MINS
     */
    public static int getFeedMins() {
        return FEED_MINS;
    }

    /**
     * Getter for FEEDING_PREP_MINS
     * @return FEEDING_PREP_MINS
     */
    public static int getFeedingPrepMins() {
        return FEEDING_PREP_MINS;
    }

    /**
     * Getter for CAGE_CLEAN_MINS
     * @return CAGE_CLEAN_MINS
     */
    public static int getCageCleanMins() {
        return CAGE_CLEAN_MINS;
    }
}
