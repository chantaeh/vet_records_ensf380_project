package edu.ucalgary.oop;

public class Diurnal extends Animal{
    private static final int[] FEEDING_HOURS = {19, 20, 21};

    public static int[] getFeedingHours() {
        return FEEDING_HOURS;
    }
}
