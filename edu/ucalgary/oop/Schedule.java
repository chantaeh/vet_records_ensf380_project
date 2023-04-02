package edu.ucalgary.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class that allocates task for each given hour
 * @author Tony
 * @version 1.0
 * @since 1.0
 */

public class Schedule {
    private ArrayList<ArrayList<Task>> dailyTasks = new ArrayList<ArrayList<Task>>(24);

    public Schedule(ArrayList<Task> everyTasks) throws IllegalArgumentException{
        // Create empty array for each hour
        for (int i = 0; i < 24; i++) {
            ArrayList<Task> newArray = new ArrayList<>();
            dailyTasks.add(newArray);
        }

        // Allocate medical tasks
        for (Task task : everyTasks) {
            int hour = task.getStartHour();
            if (!task.getDescription().equals("Feeding") && !task.getDescription().equals("Cage cleaning")) {
                dailyTasks.get(hour).add(task);
            }
        }

        // Allocate feeding tasks
        for (Task task : everyTasks) { 
            if (task.getDescription().equals("Feeding")) {
                int minHour = task.getStartHour();
                int minHourTime = timeUsed(dailyTasks.get(minHour));

                for (int i = task.getStartHour(); i < task.getStartHour() + task.getMaxWindow(); i++) {
                    int timeUsed = timeUsed(dailyTasks.get(i));
                    if (timeUsed < minHourTime) {
                        minHour = i;
                        minHourTime = timeUsed;
                    }
                }
                task.setStartHour(minHour);
                dailyTasks.get(minHour).add(task);
            }
        }

        // Allocate cage cleaning tasks
        for (Task task : everyTasks) { 
            if (task.getDescription().equals("Cage cleaning")) {
                int minHour = 0;
                int minHourTime = timeUsed(dailyTasks.get(minHour));

                for (int i = 1; i < 24; i++) {
                    int timeUsed = timeUsed(dailyTasks.get(i));
                    if (timeUsed < minHourTime) {
                        minHour = i;
                        minHourTime = timeUsed;
                    }
                }
                task.setStartHour(minHour);
                dailyTasks.get(minHour).add(task);
            }
        }

        // Check if there is enough time to complete the tasks
        for (ArrayList<Task> hourlyTasks : dailyTasks) {
            if (timeUsed(hourlyTasks) > 120) {
                String message = "Change the start hour for the following tasks: ";
                for (Task task : hourlyTasks) {
                    if (!task.getDescription().equals("Feeding") && !task.getDescription().equals("Cage cleaning")) {
                        message += task.getDescription() + ", ";
                    }
                }
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Compute the sum of each task duration
     * @param hourlyTasks the array containing every task in a given hour
     * @return the sum of each task duration
     */
    public static int timeUsed(ArrayList<Task> hourlyTasks) {
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
