package edu.ucalgary.oop;

/**
 * Abstract class for Crepuscular animals. Gives int array of feeding hours.
 * @author chantaeh 
 * @version 1.0
 * @since 1.0
 */
public abstract class Crepuscular extends Animal{
    private static final int[] FEEDING_HOURS = {19, 20, 21};

    public Crepuscular(String nickname, int numAnimals) {
        super(nickname, numAnimals);
    }

    public static int[] getFeedingHours() {
        return FEEDING_HOURS;
    }
}
