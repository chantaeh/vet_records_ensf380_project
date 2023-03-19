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

    @Test
    public void testTimeConstructor() {
        Task task = new Task();
        Time givenHour = new Time(tasks);
        assertNotNull("Time object should not be null", schedule);
    }

    @Test
    public void testTimeGetTask() {
        Task task = new Task();
        Time givenHour = new Time(0, task);

        ArrayList<Task> expectedList = new ArrayList<Task>();
        expectedList.add();
         
        ArrayList<Task> actualList = givenHour.getTask();

        assertArrayEquals("getTask did not return expected result" ,expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void testTimeAddTask() {
        Task task = new Task();
        Time givenHour = new Time(0, task);

        ArrayList<Task> expectedList = new ArrayList<Task>();
        expectedList.add();
        expectedList.add();
         
        Task newTask = new Task();
        givenHour.addTask(newTask);
        ArrayList<Task> actualList = givenHour.getTask();

        assertArrayEquals("addTask did not add properly", expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void testTimeGetHour() {
        Task task = new Task();
        Time givenHour = new Time(1, task);

        int expResult = 1;
        int actResult = givenHour.getHour();

        assertEquals("getHour did not return expected result", expResult, actResult);
    }

    @Test
    public void testTimeUpdateTimeAvailable() {
        Task task = new Task();
        Time givenHour = new Time(0, task);

        int expResult = 20;
        schedule[0].udateTimeAvailable();
        int actResult = givenHour.getTimeAvailablee();

        assertEquals("updateTimeAvailable did not update properly", expResult, actResult);
        
    }

    @Test
    public void testTimeGetTimeAvailable() {
        Task task = new Task();
        Time givenHour = new Time(0, task);
        
        int expResult = 40;
        int actResult = givenHour.getTimeAvailablee();

        assertEquals("getTimeAvailable did not return expected result", expResult, actResult);

    }

    @Test
    public void testTestGetBackupRequire() {
        Task task = new Task();
        Time givenHour = new Time(0, task);

        boolean expResult = true;
        boolean actResult = givenHour.getBackupRequire();

        assertTrue("getBackupRequire did not return expected result", expResult == actResult);
    }

    @Test
    public void testTimeBackupCheck() {
        Task task = new Task();
        Time givenHour = new Time(0, task);
        
        boolean expResult = true;
        boolean actResult = givenHour[0].backupCheck();

        assertTrue("backupCheck did not return expected result", expResult == actResult);
    }

    @Test
    public void testTimeConstructor() {
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        Task[] allTasks = [task1, task2, task3];

        Schedule schedule = new Schedule(allTasks);

        assertNotNull("Schedule should not be null", schedule);
    }

    @Test
    public void testScheduleDailyTaskFormatted() {
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        Task[] allTasks = [task1, task2, task3];

        Schedule schedule = new Schedule(allTasks);

        String expResult = "";
        String actResult = schedule.dailyTaskFormatted();

        assertEquals("dailyTaskFormatted did not return expected result", expResult, actResult);
    }
}