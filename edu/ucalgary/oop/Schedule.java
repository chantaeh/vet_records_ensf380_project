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
        // Allocate medical tasks
        for (Task task : everyTasks) {
            int hour = task.getStartHour();

            if (task.getDescription() != "Feeding" && task.getDescription() != "Cage cleaning") {
                if (dailyTasks.get(hour - 1) == null) {
                    ArrayList<Task> hourlyTasks = new ArrayList<>();
                    hourlyTasks.add(task);
                    dailyTasks.add(hour - 1, hourlyTasks);
                }
                else {
                    dailyTasks.get(hour - 1).add(task);
                }
            }
        }

        // Allocate feeding
        for (Task task : everyTasks) { 
            if (task.getDescription() == "Feeding") {
                int minHour = task.getStartHour() - 1;
                int minHourTime = timeUsed(dailyTasks.get(minHour));

                for (int i = task.getStartHour() - 1; i < task.getStartHour() - 1 + task.getDuration(); i++) {
                    int timeUsed = timeUsed(dailyTasks.get(i));
                    if (timeUsed < minHourTime) {
                        minHour = i;
                        minHourTime = timeUsed;
                    }
                }

                dailyTasks.get(minHour).add(task);
            }
        }


        // Allocate cage cleaning
        for (Task task : everyTasks) { 
            if (task.getDescription() == "Cage cleaning") {
                int minHour = 0;
                int minHourTime = 0;

                for (int i = 1; i < 24; i++) {
                    int timeUsed = timeUsed(dailyTasks.get(i));
                    if (timeUsed < minHourTime) {
                        minHour = i;
                        minHourTime = timeUsed;
                    }
                }

                dailyTasks.get(minHour).add(task);
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
