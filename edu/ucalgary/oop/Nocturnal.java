package edu.ucalgary.oop;

/**
 * Abstract class for Nocturnal animals. Gives int array of feeding hours.
 * @author chantaeh 
 * @version 1.0
 * @since 1.0
 */
abstract class Nocturnal extends Animal{
    private static final int[] FEEDING_HOURS = {0, 1, 2};

    public static int[] getFeedingHours() {
        return FEEDING_HOURS;
    }
}
