package edu.ucalgary.oop;

abstract class Nocturnal extends Animal{
    private static final int[] FEEDING_HOURS = {0, 1, 2};

    public static int[] getFeedingHours() {
        return FEEDING_HOURS;
    }
}
