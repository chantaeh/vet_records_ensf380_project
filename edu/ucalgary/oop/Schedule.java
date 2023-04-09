package edu.ucalgary.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class that allocates task for each given hour
 * @author chantaeh
 * @author andrewy94
 * @author Youssef
 * @author Tony
 * @version 1.0
 * @since 1.0
 */

public class Schedule {
    private ArrayList<ArrayList<Task>> dailyTasks = new ArrayList<ArrayList<Task>>(24);

    /**
     * Constructor for Schedule class
     * @param everyTasks
     * @throws IllegalArgumentException   
     * @throws TaskOverflowException  If there are too many tasks in an hour    
     */
    public Schedule(ArrayList<Task> everyTasks) throws IllegalArgumentException, TaskOverflowException {
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
            int hour = 0;
            if (timeUsed(hourlyTasks) > 120) {
                String message = "Too many tasks at time " + hour 
                    + ":00.\nChange the start hour for one or more or the following tasks by going"
                    + " to Edit Schedule > Move Treatment Start Hours. \nThen regenerate the schedule.\n\n";
                for (Task task : hourlyTasks) {
                    if (!task.getDescription().equals("Feeding") && !task.getDescription().equals("Cage cleaning")) {
                        message += task.getAnimal().getAnimalNickname() + ": " + task.getDescription() + ",\n";
                    }
                }
                throw new TaskOverflowException(message);
            }
            hour++;
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

    /**
     * Getter for dailyTasks
     * @return dailyTasks
     */
    public ArrayList<ArrayList<Task>> getDailyTasks() {
        return dailyTasks;
    }

}
