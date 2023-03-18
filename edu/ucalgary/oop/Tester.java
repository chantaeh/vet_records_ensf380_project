/**
 * JUnit Tester class
 * @author Group 25
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

public class Tester {
    String description = "description";
    int duration = 1;
    int maxWindow = 2;
    int startHour = 3;
    
    @Test
    public void testTaskCostrctor(){
        Task task = new Task();
        assertNotNull("Object was not created by Task when correct data was given ", task);
    }

    @Test
    public void testGetDescription(){
        Task task = new Task(description, duration, maxWindow, startHour);
        assertEquals("Description was not returned correctly", description, task.getDescription());
    }

    @Test
    public void testGetDuration(){
        Task task = new Task(description, duration, maxWindow, startHour);
        assertEquals("Duration was not returned correctly", duration, task.getDuration());
    }

    @Test
    public void testGetMaxWindow(){
        Task task = new Task(description, duration, maxWindow, startHour);
        assertEquals("MaxWindow was not returned correctly", maxWindow, task.getMaxWindow());
    }

    @Test
    public void testGetStartHour(){
        Task task = new Task(description, duration, maxWindow, startHour);
        assertEquals("StartHour was not returned correctly", startHour, task.getStartHour());
    }

}