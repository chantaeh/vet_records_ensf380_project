/**
 * JUnit Tester class
 * @author Group 25
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class Tester {

    /*
     * Test for Schedule class
     */

    @Test
    public void testScheduleConstructor() {
        Fox fox = new Fox("Snowball", 1);
        Task task = new Task("Eyedrops", 25, 1, 22, fox);
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task);
        Schedule schedule = new Schedule(dailyTasks);

        assertNotNull("Time object should not be null", schedule);
    }

    @Test
    public void testScheduleConstructorException() {
        Fox fox = new Fox("Snowball", 1);
        Task task = new Task("Eyedrops", 25, 1, 22, fox);
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Schedule schedule = new Schedule(dailyTasks);
        });

        assertEquals("Invalid tasks should throw an exception", exception.getMessage());
    }

    @Test
    public void testScheduleTimeUsed() {
        Fox fox = new Fox("Snowball", 1);
        Coyote coyote = new Coyote("Narseh", 2);
        Task task1 = new Task("Eyedrops", 25, 1, 22, fox);
        Task task2 = new Task("Give fluid injection", 10, 1, 22, coyote);
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task1);
        dailyTasks.add(task2);
        Schedule schedule = new Schedule(dailyTasks);

        int expResult = 35;
        int actResult = schedule.timeUsed(schedule.getOverallTask().get(21));

        assertEquals("timeUsed did not return expected result", expResult, actResult);
    }

    @Test
    public void testScheduleGetDailyTasks() {
        Fox fox = new Fox("Snowball", 1);
        Coyote coyote = new Coyote("Narseh", 2);
        Task task1 = new Task("Eyedrops", 25, 1, 22, fox);
        Task task2 = new Task("Give fluid injection", 10, 1, 22, coyote);
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task1);
        dailyTasks.add(task2);
        Schedule schedule = new Schedule(dailyTasks);

        ArrayList<ArrayList<Task>> dailyTasks = new ArrayList<ArrayList<Task>>(24);
        ArrayList<Task> hourTasks = new ArrayList<>();
        hourTasks.add(task1);
        hourTasks.add(task2);
        dailyTasks.set(21, hourTasks);

        ArrayList<ArrayList<Task>> expResult = dailyTasks;
        ArrayList<ArrayList<Task>> actResult = schedule.getDailyTasks();

        assertEquals("getDailyTasks did not return expected result", expResult.size(), actResult.size());

        for (int i = 0; i < list1.size(); i++) {
            assertEquals("getDailyTasks did not return expected result", expResult.get(i), actResult.get(i));
        }
    }

    /*
     * Test for Scheduler class
     */

    @Test
    public void testSchedulerGetFromatted() {
        Fox fox = new Fox("Snowball", 1);
        Coyote coyote = new Coyote("Narseh", 2);
        Task task1 = new Task("Eyedrops", 25, 1, 22, fox);
        Task task2 = new Task("Give fluid injection", 10, 1, 22, coyote);
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task1);
        dailyTasks.add(task2);
        Schedule schedule = new Schedule(dailyTasks);

        String expResult = "22:00\n";
        expResult += "* Eyedrops (Snowball)\n";
        expResult += "* Give fluid injection (Narseh)";
        String actResult = scheduler.getFormatted(schedule.getOverallTask());

        assertEquals("getFormatted did not return expected result", expResult, actResult);
    }

}