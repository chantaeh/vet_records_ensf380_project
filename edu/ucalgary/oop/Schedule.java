package edu.ucalgary.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class that allocates task for each given hour
 * @author Tony
 * @version 1.0
 * @since 1.0
 */

public class Schedule {
    private ArrayList<ArrayList<Task>> dailyTasks = new ArrayList<ArrayList<Task>>(24);

    public Schedule(ArrayList<Task> everyTasks) {
        // Allocate each task to an hour
    }

    /**
     * Compute the sum of each task duration
     * @param hourlyTasks the array containing every task in a given hour
     * @return the sum of each task duration
     */
    public int timeUsed(ArrayList<Task> hourlyTasks) {
        int timeUsed = 0;

        for (Task task : hourlyTasks) {
            timeUsed += task.getDuration();
        }

        return timeUsed;
    }

    public ArrayList<ArrayList<Task>> getDailyTasks() {
        return dailyTasks;
    }

}
