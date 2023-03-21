/**
 * JUnit Tester class
 * @author Group 25
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;

public class Tester {
    /*
     * Tests of the Task class
     */
    
    
    String description = "description";
    int duration = 1;
    int maxWindow = 2;
    int startHour = 3;

    /*
     * test the constructor with invalid data
     */

    @Test
    public void testTaskConstructorInvalidData(){
        boolean exceptionThrown = false;
        try{
            Task task = new Task(description, -1, maxWindow, startHour);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when duration was negative", exceptionThrown);
        exceptionThrown = false;

        try{
            Task task = new Task(description, duration, -1, startHour);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when maxWindow was negative", exceptionThrown);
        exceptionThrown = false;

        try{
            Task task = new Task(description, duration, maxWindow, -1);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when startHour was negative", exceptionThrown);
        exceptionThrown = false;

        try{
            Task task = new Task(description, duration, maxWindow, 24);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when startHour was greater than 23", exceptionThrown);

    }

    /*
     * test the constructor with valid data
     */
    
    @Test
    public void testTaskConstructor(){
        Task task = new Task();
        assertNotNull("Object was not created by Task when correct data was given ", task);
    }

    /*
     * test the getters and setters
     */

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

    /*
     * test the constructor with invalid data
     */

    @Test
    public void testAnimalConstructorInvalidData(){
        boolean exceptionThrown = false;
        try{
            Animal animal = new Animal(animalNickname, "-1");
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when numAnimals was negative", exceptionThrown);

    }

    /*
     * test the constructor with valid data
     */

    @Test
    public void testAnimalConstructor(){
        Animal animal = new Animal( animalNickname, numAnimals);
        assertNotNull("Object was not created by Animal when correct data was given ", animal);
    }

    /*
     * test the getters and setters
     */

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



    

    /**
     * Test that Nocturnal inherits from Animal
     */
    @Test
    public void testNocturnalSuperclass() {
        Class superclass = Nocturnal.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Nocturnal class does not inherit from the Animal class.", "Animal", simpleClassName);
    }

    /**
     * Test that Diurnal inherits from Animal
     */
    @Test
    public void testDiurnalSuperclass() {
        Class superclass = Diurnal.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Diurnal class does not inherit from the Animal class.", "Animal", simpleClassName);
    }

    /**
     * Test that Crepuscular inherits from Animal
     */
    @Test
    public void testCrepuscularSuperclass() {
        Class superclass = Crepuscular.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Crepuscular class does not inherit from the Animal class.","Animal", simpleClassName);
    }

    /**
     * Test that Nocturnal is an abstract class
     */
    @Test
    public void testNocturnalAbstract() {
        Class aClass = Nocturnal.class;
        int modifiers = aClass.getModifiers();
        assertTrue("Nocturnal class is not abstract.", Modifier.isAbstract(modifiers));
    }

    /**
     * Test that Diurnal is an abstract class
     */
    @Test
    public void testDiurnalAbstract() {
        Class aClass = Diurnal.class;
        int modifiers = aClass.getModifiers();
        assertTrue("Diurnal class is not abstract.", Modifier.isAbstract(modifiers));
    }

    /**
     * Test that Crepuscular is an abstract class
     */
    @Test
    public void testCrepuscularAbstract() {
        Class aClass = Crepuscular.class;
        int modifiers = aClass.getModifiers();
        assertTrue("Crepuscular class is not abstract.", Modifier.isAbstract(modifiers));
    }

    /**
     * Test Nocturnal class's static getter method
     */
    @Test
    public void testNocturnalGetFeedingHours() {
        int[] expectedNocturnalHours = {0, 1, 2};
        int[] actualNocturnalHours = Nocturnal.getFeedingHours();

        for (int i = 0; i < expectedNocturnalHours.length; i++) {
            assertEquals("Nocturnal method getFeedingHours() does not return correct result.", expectedNocturnalHours[i], actualNocturnalHours[i]);
        }
    } 
    
    /**
     * Test Diurnal class's static getter method 
     */
    @Test
    public void testDiurnalGetFeedingHours() {
        int[] expectedDiurnalHours = {8, 9, 10};
        int[] actualDiurnalHours = Diurnal.getFeedingHours();

        for (int i = 0; i < expectedDiurnalHours.length; i++) {
            assertEquals("Diurnal method getFeedingHours() does not return correct result.", expectedDiurnalHours[i], actualDiurnalHours[i]);
        }
    } 

    /**
     * Test Crepuscular class's static getter method
     */
    @Test
    public void testCrepuscularGetFeedingHours() {
        int[] expectedCrepuscHours = {19, 20, 21};
        int[] actualCrepuscHours = Crepuscular.getFeedingHours();

        for (int i = 0; i < expectedCrepuscHours.length; i++) {
            assertEquals("Crepuscular method getFeedingHours() does not return correct result.", expectedCrepuscHours[i], actualCrepuscHours[i]);
        }
    } 

    /**
     * Test that Fox inherits from Nocturnal
     */
    @Test
    public void testFoxSuperclass() {
        Class superclass = Fox.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Fox class does not inherit from Nocturnal class.", "Nocturnal", simpleClassName);
    }   

    /**
     * Test that Raccoon inherits from Nocturnal
     */
    @Test
    public void testRaccoonSuperclass() {
        Class superclass = Raccoon.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Raccoon class does not inherit from Nocturnal class.", "Nocturnal", simpleClassName);
    }   

    /**
     * Test that Beaver inherits from Diurnal
     */
    @Test
    public void testBeaverSuperclass() {
        Class superclass = Beaver.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Beaver class does not inherit from Diurnal class.", "Diurnal", simpleClassName);
    }   

    
    /**
     * Test that Porcupine inherits from Crepuscular
     */
    @Test
    public void testPorcupineSuperclass() {
        Class superclass = Porcupine.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Porcupine class does not inherit from Crepuscular class.", "Crepuscular", simpleClassName);
    }  
    
    /**
     * Test that Coyote inherits from Crepuscular
     */
    @Test
    public void testCoyoteSuperclass() {
        Class superclass = Coyote.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Coyote class does not inherit from Crepuscular class.", "Crepuscular", simpleClassName);
    }   


}