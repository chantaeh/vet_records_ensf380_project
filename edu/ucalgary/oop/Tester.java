/**
 * JUnit Tester class
 * @author Group 25
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

public class Tester {
    /*
     * Tests of the Task class
     */
    
    
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

    @Test
    public void testSetDescription(){
        Task task = new Task(description, duration, maxWindow, startHour);
        task.setDescription(description);
        assertEquals("Description was not set correctly", description, task.getDescription());
    }

    @Test
    public void testSetDuration(){
        Task task = new Task(description, duration, maxWindow, startHour);
        task.setDuration(duration);
        assertEquals("Duration was not set correctly", duration, task.getDuration());
    }

    @Test
    public void testSetMaxWindow(){
        Task task = new Task(description, duration, maxWindow, startHour);
        task.setMaxWindow(maxWindow);
        assertEquals("MaxWindow was not set correctly", maxWindow, task.getMaxWindow());
    }

    @Test
    public void testSetStartHour(){
        Task task = new Task(description, duration, maxWindow, startHour);
        task.setStartHour(startHour);
        assertEquals("StartHour was not set correctly", startHour, task.getStartHour());
    }

    
    /*
     *   Tests of the animal class
     */

    String animalNickname = "name";
    String numAnimals = "1";

    @Test
    public void testAnimalCostrctor(){
        Animal animal = new Animal( animalNickname, numAnimals);
        assertNotNull("Object was not created by Animal when correct data was given ", animal);
    }

    @Test
    public void testGetAnimalNickname(){
        Animal animal = new Animal( animalNickname, numAnimals);
        assertEquals("AnimalNickname was not returned correctly", animalNickname, animal.getAnimalNickname());
    }

    @Test
    public void testGetNumAnimals(){
        Animal animal = new Animal( animalNickname, numAnimals);
        assertEquals("NumAnimals was not returned correctly", numAnimals, animal.getNumAnimals());
    }

    @Test
    public void testSetAnimalNickname(){
        Animal animal = new Animal( animalNickname, numAnimals);
        animal.setAnimalNickname(animalNickname);
        assertEquals("AnimalNickname was not set correctly", animalNickname, animal.getAnimalNickname());
    }

    @Test
    public void testSetNumAnimals(){
        Animal animal = new Animal( animalNickname, numAnimals);
        animal.setNumAnimals(numAnimals);
        assertEquals("NumAnimals was not set correctly", numAnimals, animal.getNumAnimals());
    }



    

}