/**
 * JUnit Tester class
 * @author Group 25
 * @version 1.2
 * @since 1.1
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.junit.*;
import java.lang.reflect.*;
import java.time.LocalDate;

public class Tester {
      
    /**
     * Thes that getFeedStartHour() is inherited from Nocturnal
     */
    @Test
    public void testFoxGetFeedStartHour() {       
        int expected = 0;
        int actual = Fox.getFeedStartHour();
        
        assertEquals("Fox class is not inheriting getFeedStartHour from Nocturnal class", expected, actual);
    }
    
    /**
     * Test Fox contructor and getter methods inherited from Animal
     */
    @Test
    public void testFox() {
        String name = "Fox";
        int numAnimals = 1;
        
        Fox fox = new Fox(name, numAnimals);
        
        assertEquals("Fox Constructor does not return 'name' correctly", name, fox.getAnimalNickname());
        assertEquals("Fox Constructor does not return 'numAnimals' correctly", numAnimals, fox.getNumAnimals());
    }

    
    /**
     * Test Fox class's getFeedMins() method
     */
    @Test
    public void testFoxGetFeedMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals("Fox method GetFeedMins() does not return correct time.", 5, fox.getFeedMins());
    }

    /**
     * Test Fox class's getFeedingPrepMins() method
     */
    @Test
    public void testFoxGetFeedingPrepMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals("Fox method GetFeedingPrepMins() does not return correct time.",5, fox.getFeedingPrepMins());
    }

    /**
     * Test Fox class's getCageCleanMins() method
     */
    @Test
    public void testFoxGetCageCleanMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals("Fox method GetCageCleanMins() does not return correct time.", 5, fox.getCageCleanMins());
    }

    /**
     * Test that Raccoon inherits the method getFeedStartHour() from Nocturnal
     */
    @Test
    public void testRaccoonGetFeedStartHour() {
        
        int expected = 0;
        int actual = Raccoon.getFeedStartHour();
        
        assertEquals("Raccoon class is not inheriting getFeedStartHour from Nocturnal class",expected, actual);
    }
    
    /**
     * Test Raccoon constructor and getter methods inherited from Animal
     */
    @Test
    public void testRaccoon() {
        String name = "Raccoon";
        int numAnimals = 1;
        
        Raccoon raccoon = new Raccoon(name, numAnimals);
        
        assertEquals("Raccoon Constructor does not return 'name' correctly", name, raccoon.getAnimalNickname());
        assertEquals("Raccoon Constructor does not return 'numAnimals' correctly", numAnimals, raccoon.getNumAnimals());
        }
    
    /**
     * Test Raccoon class's getFeedMins() method
     */
    @Test
    public void testRaccoonGetFeedMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals("Raccoon method GetFeedMins() does not return correct time.", 5, raccoon.getFeedMins());
    }

    /**
     * Test Raccoon class's getFeedingPrepMins() method
     */
    @Test
    public void testRaccoonGetFeedingPrepMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals("Raccoon method GetFeedingPrepMins() does not return correct time.", 0, raccoon.getFeedingPrepMins());
    }

    /**
     * Test Raccoon class's getCageCleanMins() method
     */
    @Test
    public void testRaccoonGetCageCleanMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals("Raccoon method GetCageCleanMins() does not return correct time.", 5, raccoon.getCageCleanMins());
    }    

    /**
     * Test that Beaver inherits the method getFeedStartHour() from Diurnal
     */
    @Test
    public void testBeaverGetFeedStartHour() {
        
        int expected = 8;
        int actual = Beaver.getFeedStartHour();
        
        assertEquals("Beaver class is not inheriting getFeedStartHour from Diurnal class", expected, actual);
    }
    
    /**
     * Test Beaver constructor and getter methods inherited from Animal
     */
    @Test
    public void testBeaver() {
        String name = "Beaver";
        int numAnimals = 1;
        
        Beaver beaver = new Beaver(name, numAnimals);
        
        assertEquals("Beaver Constructor does not return 'name' correctly", name, beaver.getAnimalNickname());
        assertEquals("Beaver Constructor does not return 'numAnimals' correctly", numAnimals, beaver.getNumAnimals());
        }

    /**
     * Test Beaver class's getFeedMins() method
     */
    @Test
    public void testBeaverGetFeedMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals("Beaver method GetFeedMins() does not return correct time.", 5, beaver.getFeedMins());
    }

    /**
     * Test Beaver class's getFeedingPrepMins() method
     */
    @Test
    public void testBeaverGetFeedingPrepMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals("Beaver method GetFeedingPrepMins() does not return correct time.", 0, beaver.getFeedingPrepMins());
    }
    
    /**
     * Test Beaver class's getCageCleanMins() method
     */
    @Test
    public void testBeaverGetCageCleanMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals("Beaver method GetCageCleanMins() does not return correct time.", 5, beaver.getCageCleanMins());
    }    

    /**
     * Test that Porpupine inherits the method getFeedStartHour() from Crepuscular
     */
    @Test
    public void testPorcupinegetFeedStartHour() {
        int expected = 19;
        int actual = Porcupine.getFeedStartHour();
        
        assertEquals("Porcupine class is not inheriting getFeedStartHour from Crepuscular class",expected, actual);
    }
   
    /**
     * Test Porcupine constructor and getter methods inherited from Animal
     */
    @Test
    public void testPorcupine() {
        String name = "Porcupine";
        int numAnimals = 1;
        
        Porcupine porcupine = new Porcupine(name, numAnimals);
        
        assertEquals("Porcupine Constructor does not return 'name' correctly", name, porcupine.getAnimalNickname());
        assertEquals("Porcupine Constructor does not return 'numAnimals' correctly", numAnimals, porcupine.getNumAnimals());
        }
    
    /**
     * Test Porcupine class's getFeedMins() method
     */
    @Test
    public void testPorcupineGetFeedMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals("Porcupine method GetFeedMins() does not return correct time.", 5, porcupine.getFeedMins());
    }

    /**
     * Test Porcupine class's getFeedingPrepMins() method
     */
    @Test
    public void testPorcupineGetFeedingPrepMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals("Porcupine method GetFeedingPrepMins() does not return correct time.", 0, porcupine.getFeedingPrepMins());
    }

    /**
     * Test Porcupine class's getCageCleanMins() method
     */
    @Test
    public void testPorcupineGetCageCleanMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals("Porcupine method GetCageCleanMins() does not return correct time.", 10, porcupine.getCageCleanMins());
    }
    
    /**
     * Test that Coyote inherits method getFeedStartHour() from Crepuscular
     */
    @Test
    public void testCoyotegetFeedStartHour() {
        int expected = 19;
        int  actual = Coyote.getFeedStartHour();
        
        assertEquals("Coyote class is not inheriting getFeedStartHour from Crepuscular class",expected, actual);
    }
   
    /**
     * Test Coyote constructor and getter methods inherited from Animal
     */
    @Test
    public void testCoyote() {
        String name = "Coyote";
        int numAnimals = 1;
        
        Coyote coyote = new Coyote(name, numAnimals);
        
        assertEquals("Coyote Constructor does not return 'name' correctly", name, coyote.getAnimalNickname());
        assertEquals("Coyote Constructor does not return 'numAnimals' correctly", numAnimals, coyote.getNumAnimals());
    }
    
    /**
     * Test Coyote class's method getFeedMins()
     */
    @Test
    public void testCoyoteGetFeedMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals("Coyote method GetFeedMins() does not return correct time.", 5, coyote.getFeedMins());
    }

    /**
     * Test Coyote class's method getFeedingPrepMins()
     */
    @Test
    public void testCoyoteGetFeedingPrepMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals("Coyote method GetFeedingPrepMins() does not return correct time.", 10, coyote.getFeedingPrepMins());
    }

    /**
     * Test Coyote class's method getCageCleanMins()
     */
    @Test
    public void testCoyoteGetCageCleanMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals("Coyote method GetCageCleanMins() does not return correct time.", 5, coyote.getCageCleanMins());
    }   
    
    /*TESTS FOR ILLEGALARGUMENTEXCEPTION OF THE CONSTRUCTORS FOR FOX, RACCOON, ETC. */
    
    /**
     * Test that Fox constructor throws IllegalArgumentException given invalid input
     */
    @Test
    public void testFoxConstructorInvalidData() {
        boolean exceptionThrown = false;

        // Test with negative numAnimals
        try {
            Fox fox = new Fox("Fox", -1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when numAnimals was negative", exceptionThrown);
        exceptionThrown = false;

        // Test with null name
        try {
            Fox fox = new Fox(null, 1);
        } catch (IllegalArgumentException e) {
        exceptionThrown = true;
        }
            assertTrue("IllegalArgumentException was not thrown when name was null", exceptionThrown);
        exceptionThrown = false;
    }
        

    /**
     * Test that Raccoon constructor throws IllegalArgumentException given invalid input
     */
    @Test
    public void testRaccoonConstructorInvalidData() {
        boolean exceptionThrown = false;

        // Test with negative numAnimals
        try {
            Raccoon raccoon = new Raccoon("Raccoon", -1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when numAnimals was negative", exceptionThrown);
        exceptionThrown = false;

        // Test with null name
        try {
            Raccoon raccoon = new Raccoon(null, 1);
        } catch (IllegalArgumentException e) {
        exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when name was null", exceptionThrown);
        exceptionThrown = false;
    }

    /**
     * Test that Beaver constructor throws IllegalArgumentException given invalid input
     */
    @Test
    public void testBeaverConstructorInvalidData() {
        boolean exceptionThrown = false;

        // Test with negative numAnimals
        try {
            Beaver beaver = new Beaver("Beaver", -1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when numAnimals was negative", exceptionThrown);
        exceptionThrown = false;

        // Test with null name
        try {
            Beaver beaver = new Beaver(null, 1);
        } catch (IllegalArgumentException e) {
        exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when name was null", exceptionThrown);
        exceptionThrown = false;
    }

    /**
     * Test that Porcupine constructor throws IllegalArgumentException given invalid input
     */
    @Test
    public void testPorcupineConstructorInvalidData() {
        boolean exceptionThrown = false;

        // Test with negative numAnimals
        try {
            Porcupine porcupine = new Porcupine("Porcupine", -1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when numAnimals was negative", exceptionThrown);
        exceptionThrown = false;

        // Test with null name
        try {
            Porcupine porcupine = new Porcupine(null, 1);
        } catch (IllegalArgumentException e) {
        exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when name was null", exceptionThrown);
        exceptionThrown = false;
    }

    /**
     * Test that Coyote constructor throws IllegalArgumentException given invalid input
     */
    @Test
    public void testCoyoteConstructorInvalidData() {
        boolean exceptionThrown = false;

        // Test with negative numAnimals
        try {
            Coyote coyote = new Coyote("Coyote", -1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when numAnimals was negative", exceptionThrown);
        exceptionThrown = false;

        // Test with null name
        try {
            Coyote coyote = new Coyote(null, 1);
        } catch (IllegalArgumentException e) {
        exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when name was null", exceptionThrown);
        exceptionThrown = false;
    }

    /* Tests for Task class */
    
    String description = "description";
    int duration = 1;
    int maxWindow = 2;
    int startHour = 3;
    Animal animal = new Animal("animal", 1);

    /**
     * Test that Task constructor throws an IllegalArgumentException given a negative duration
     */
    @Test
    public void testTaskConstructorWithNegativeDuration(){
        boolean exceptionThrown = false;
        try{
            Task task = new Task(description, -1, maxWindow, startHour, animal);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when duration was negative", exceptionThrown);
    }

    /**
     * Test that Task constructor throws an IllegalArgumentException given a negative maxWindow
     */
    @Test
    public void testTaskConstructorWithNegativeMaxWindow() {
        boolean exceptionThrown = false;

        try{
            Task task = new Task(description, duration, -1, startHour, animal);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when maxWindow was negative", exceptionThrown);
    }

    /**
     * Test that Task constructor throws an IllegalArgumentException given a negative startHour
     */
    @Test
    public void testTaskConstructorWithNegativeStartHour() {
        boolean exceptionThrown = false;

        try{
            Task task = new Task(description, duration, maxWindow, -1, animal);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when startHour was negative", exceptionThrown);
    }

    /**
     * Test that Task constructor throws an IllegalArgumentException given a too-large startHour
     */
    @Test
    public void testTaskConstructorWithInvalidStartHour() {
        boolean exceptionThrown = false;

        try{
            Task task = new Task(description, duration, maxWindow, 24,  animal);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when startHour was greater than 23", exceptionThrown);

    }

    /**
     * Test Task constructor with valid data
     */
    @Test
    public void testTaskConstructor(){
        Task task = new Task( description, duration, maxWindow, startHour, animal);
        assertNotNull("Object was not created by Task when correct data was given ", task);
    }

    /* Test Task class getters and setters */

    /**
     * Test Task class's method getDescription()
     */
    @Test
    public void testGetDescription(){
        Task task = new Task(description, duration, maxWindow, startHour, animal);
        assertEquals("Description was not returned correctly", description, task.getDescription());
    }

    /**
     * Test Task class's method getDuration()
     */
    @Test
    public void testGetDuration(){
        Task task = new Task(description, duration, maxWindow, startHour,   animal);
        assertEquals("Duration was not returned correctly", duration, task.getDuration());
    }

    /**
     * Test Task class's method getMaxWindow()
     */
    @Test
    public void testGetMaxWindow(){
        Task task = new Task(description, duration, maxWindow, startHour, animal);
        assertEquals("MaxWindow was not returned correctly", maxWindow, task.getMaxWindow());
    }

    /**
     * Test Task class's method getStartHour()
     */
    @Test
    public void testGetStartHour(){
        Task task = new Task(description, duration, maxWindow, startHour, animal);
        assertEquals("StartHour was not returned correctly", startHour, task.getStartHour());
    }

    /**
     * Test Task class's method setDescription()
     */
    @Test
    public void testSetDescription(){
        Task task = new Task(description, duration, maxWindow, startHour, animal);
        String expected = "Changed description";
        task.setDescription(expected);
        String actual = task.getDescription();
        assertEquals("Description was not set correctly", expected, actual);
    }

    /**
     * Test Task class's method setDuration()
     */
    @Test
    public void testSetDuration(){
        Task task = new Task(description, duration, maxWindow, startHour, animal);
        int expected = 15;
        task.setDuration(expected);
        int actual = task.getDuration();
        assertEquals("Duration was not set correctly", expected, actual);
    }

    /**
     * Test Task class's method setMaxWindow()
     */
    @Test
    public void testSetMaxWindow(){
        Task task = new Task(description, duration, maxWindow, startHour, animal);
        int expected = 5;
        task.setMaxWindow(expected);
        int actual = task.getMaxWindow();
        assertEquals("MaxWindow was not set correctly", expected, actual);
    }

    /**
     * Test Task class's method setStartHour
     */
    @Test
    public void testSetStartHour(){
        Task task = new Task(description, duration, maxWindow, startHour, animal);
        int expected = 20;
        task.setStartHour(expected);
        int actual = task.getStartHour();
        assertEquals("StartHour was not set correctly", expected, actual);
    }

    /*
     *   Tests of the animal class
     */

    String animalNickname = "name";
    int numAnimals = 1;

    /**
     * Test that the Animal constructor throws in IllegalArgumentException given invalid input
     */
    @Test
    public void testAnimalConstructorInvalidData(){
        boolean exceptionThrown = false;
        try{
            Animal animal = new Animal(animalNickname, -1);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue("IllegalArgumentException was not thrown when numAnimals was negative", exceptionThrown);

    }

    /**
     * Test that the Animal constructor creates an Animal object given valid input
     */
    @Test
    public void testAnimalConstructor(){
        Animal animal = new Animal(animalNickname, numAnimals);
        assertNotNull("Object was not created by Animal when correct data was given ", animal);
    }

    /* Test the Animal class getters and setters */

    /**
     * Test Animal class's getAnimalNickname() method
     */
    @Test
    public void testGetAnimalNickname(){
        Animal animal = new Animal( animalNickname, numAnimals);
        assertEquals("AnimalNickname was not returned correctly", animalNickname, animal.getAnimalNickname());
    }

    /**
     * Test Animal class's getNumAnimals() method
     */
    @Test
    public void testGetNumAnimals(){
        Animal animal = new Animal( animalNickname, numAnimals);
        assertEquals("NumAnimals was not returned correctly", numAnimals, animal.getNumAnimals());
    }

    /**
     * Test Animal class's setAnimalNickname() method
     */
    @Test
    public void testSetAnimalNickname(){
        Animal animal = new Animal(animalNickname, numAnimals);
        String expected = "New name";
        animal.setAnimalNickname(expected);
        String actual = animal.getAnimalNickname();
        assertEquals("AnimalNickname was not set correctly", expected, actual);
    }

    /**
     * Test Animal class's setNumAnimals() method
     */
    @Test
    public void testSetNumAnimals(){
        Animal animal = new Animal(animalNickname, numAnimals);
        int expected = 3;
        animal.setNumAnimals(expected);
        int actual = animal.getNumAnimals();
        assertEquals("NumAnimals was not set correctly", expected, actual);
    }

    /**
     * Test polymorphism of Animal class through Coyote
     */
    @Test
    public void testAnimalCoyotePolymorphism() {
        String expectedName = "CoyoteName";
        int expectedNum = 2;
        Animal animal = new Coyote(expectedName, expectedNum);

        // Test superclass methods
        String actualName = animal.getAnimalNickname();
        int actualNum = animal.getNumAnimals();

        assertEquals("Animal object created as Coyote did not have correct nickname.", 
            expectedName, actualName);
        assertEquals("Animal object created as Coyote did not have correct numAnimals", 
            expectedNum, actualNum);
    }

    /**
     * Test polymorphism of Animal class through Beaver
     */
    @Test
    public void testAnimalBeaverPolymorphism() {
        String expectedName = "BeaverName";
        int expectedNum = 2;
        Animal animal = new Beaver(expectedName, expectedNum);

        // Test superclass methods
        String actualName = animal.getAnimalNickname();
        int actualNum = animal.getNumAnimals();

        assertEquals("Animal object created as Beaver did not have correct nickname.", 
            expectedName, actualName);
        assertEquals("Animal object created as Beaver did not have correct numAnimals", 
            expectedNum, actualNum);
    }

    /**
     * Test polymorphism of Animal class through Porcupine
     */
    @Test
    public void testAnimalPorcupinePolymorphism() {
        String expectedName = "PorcupineName";
        int expectedNum = 2;
        Animal animal = new Porcupine(expectedName, expectedNum);

        // Test superclass methods
        String actualName = animal.getAnimalNickname();
        int actualNum = animal.getNumAnimals();

        assertEquals("Animal object created as Porcupine did not have correct nickname.", 
            expectedName, actualName);
        assertEquals("Animal object created as Porcupine did not have correct numAnimals", 
            expectedNum, actualNum);
    }

    /**
     * Test polymorphism of Animal class through Raccoon
     */
    @Test
    public void testAnimalRaccoonPolymorphism() {
        String expectedName = "RaccoonName";
        int expectedNum = 2;
        Animal animal = new Raccoon(expectedName, expectedNum);

        // Test superclass methods
        String actualName = animal.getAnimalNickname();
        int actualNum = animal.getNumAnimals();

        assertEquals("Animal object created as Raccoon did not have correct nickname.", 
            expectedName, actualName);
        assertEquals("Animal object created as Raccoon did not have correct numAnimals", 
            expectedNum, actualNum);
    }

    /**
     * Test polymorphism of Animal class through Fox
     */
    @Test
    public void testAnimalFoxPolymorphism() {
        String expectedName = "FoxName";
        int expectedNum = 2;
        Animal animal = new Fox(expectedName, expectedNum);

        // Test superclass methods
        String actualName = animal.getAnimalNickname();
        int actualNum = animal.getNumAnimals();

        assertEquals("Animal object created as Fox did not have correct nickname.", 
            expectedName, actualName);
        assertEquals("Animal object created as Fox did not have correct numAnimals", 
            expectedNum, actualNum);
    }


    /* Tests for Nocturnal, Diurnal, Crepuscular classes */    

    /**
     * Test that Nocturnal inherits from Animal
     */
    @Test
    public void testNocturnalSuperclass() {
        Class aClass = Nocturnal.class;
        Class superclass = aClass.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Nocturnal class does not inherit from the Animal class.", "Animal", simpleClassName);
    }

    /**
     * Test that Diurnal inherits from Animal
     */
    @Test
    public void testDiurnalSuperclass() {
        Class aClass = Diurnal.class;
        Class superclass = aClass.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Diurnal class does not inherit from the Animal class.", "Animal", simpleClassName);
    }

    /**
     * Test that Crepuscular inherits from Animal
     */
    @Test
    public void testCrepuscularSuperclass() {
        Class aClass = Crepuscular.class;
        Class superclass = aClass.getSuperclass();

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
    public void testNocturnalgetFeedStartHour() {
        int expectedNocturnalHours = 0;
        int actualNocturnalHours = Nocturnal.getFeedStartHour();

            assertEquals("Nocturnal method getFeedStartHour() does not return correct result.", expectedNocturnalHours, actualNocturnalHours);
    } 
    
    /**
     * Test Diurnal class's static getter method 
     */
    @Test
    public void testDiurnalgetFeedStartHour() {
        int expectedDiurnalHours = 8;
        int  actualDiurnalHours = Diurnal.getFeedStartHour();

            assertEquals("Diurnal method getFeedStartHour() does not return correct result.", expectedDiurnalHours, actualDiurnalHours);
        
    } 

    /**
     * Test Crepuscular class's static getter method
     */
    @Test
    public void testCrepusculargetFeedStartHour() {
        int expectedCrepuscHours = 19;
        int actualCrepuscHours = Crepuscular.getFeedStartHour();

        
            assertEquals("Crepuscular method getFeedStartHour() does not return correct result.", expectedCrepuscHours, actualCrepuscHours);
    } 

    /**
     * Test that Fox inherits from Nocturnal
     */
    @Test
    public void testFoxSuperclass() {
        Class aClass = Fox.class;
        Class superclass = aClass.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Fox class does not inherit from Nocturnal class.", "Nocturnal", simpleClassName);
    }   

    /**
     * Test that Raccoon inherits from Nocturnal
     */
    @Test
    public void testRaccoonSuperclass() {
        Class aClass = Raccoon.class;
        Class superclass = aClass.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Raccoon class does not inherit from Nocturnal class.", "Nocturnal", simpleClassName);
    }   

    /**
     * Test that Beaver inherits from Diurnal
     */
    @Test
    public void testBeaverSuperclass() {
        Class aClass = Beaver.class;
        Class superclass = aClass.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Beaver class does not inherit from Diurnal class.", "Diurnal", simpleClassName);
    }   

    
    /**
     * Test that Porcupine inherits from Crepuscular
     */
    @Test
    public void testPorcupineSuperclass() {
        Class aClass = Porcupine.class;
        Class superclass = aClass.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Porcupine class does not inherit from Crepuscular class.", "Crepuscular", simpleClassName);
    }  
    
    /**
     * Test that Coyote inherits from Crepuscular
     */
    @Test
    public void testCoyoteSuperclass() {
        Class aClass = Coyote.class;
        Class superclass = aClass.getSuperclass();
        String simpleClassName = superclass.getSimpleName();
        assertEquals("Coyote class does not inherit from Crepuscular class.", "Crepuscular", simpleClassName);
    }   


    /* Tests for the Schedule class */

    /**
     * Test that Schedule constructor creates a Schedule object when given valid input
     */
    @Test
    public void testScheduleConstructor() {
        Task task = null;
        Fox fox = new Fox("Snowball", 1);
        try {
            task = new Task("Eyedrops", 25, 1, 22, fox);
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task);
        Schedule schedule = new Schedule(dailyTasks);

        assertNotNull("Time object should not be null", schedule);
    }

    /**
     * Test that Schedule constructor throws an IllegalArgumentException given an invalid Task
     */
    @Test(expected = IllegalArgumentException.class)
    public void testScheduleConstructorException() {
        Fox fox = new Fox("Snowball", 1);
        Task task = new Task("Eyedrops", 25, 1, 30, fox);
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task);

        Schedule schedule = new Schedule(new ArrayList<Task>((Arrays.asList(new Task("Eyedrops", 25, 1, 30, fox)))));
    }

    /**
     *  Test if the sum of each individual task duration is correct in the Schedule class
     */
    @Test
    public void testScheduleTimeUsed() {
        Task task1 = null;
        Task task2 = null;

        Fox fox = new Fox("Snowball", 1);
        Coyote coyote = new Coyote("Narseh", 2);
        try {
            task1 = new Task("Eyedrops", 25, 1, 22, fox);
            task2 = new Task("Give fluid injection", 10, 1, 22, coyote);
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } 

        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task1);
        dailyTasks.add(task2);
        Schedule schedule = new Schedule(dailyTasks);

        int expResult = 35;
        int actResult = Schedule.timeUsed(schedule.getDailyTasks().get(22));

        assertEquals("timeUsed did not return expected result", expResult, actResult);
    }

    /**
     * Test if the tasks are allocated to each hour correctly by the Schedule class
     */
    @Test
    public void testScheduleGetDailyTasks() {
        Task task1 = null;
        Task task2 = null;

        Fox fox = new Fox("Snowball", 1);
        Coyote coyote = new Coyote("Narseh", 2);
        try {
            task1 = new Task("Eyedrops", 25, 1, 22, fox);
            task2 = new Task("Give fluid injection", 10, 1, 22, coyote);
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } 
        ArrayList<Task> dailyTasks0 = new ArrayList<>(24);
        dailyTasks0.add(task1);
        dailyTasks0.add(task2);
        Schedule schedule = new Schedule(dailyTasks0);

        ArrayList<ArrayList<Task>> expextedDailyTasks = new ArrayList<ArrayList<Task>>(24);
        for (int i = 0; i < 24; i++) {
            ArrayList<Task> hourTasks = new ArrayList<>(24);
            expextedDailyTasks.add(hourTasks);
        }
        expextedDailyTasks.set(22, new ArrayList<Task>(Arrays.asList(task1, task2)));

        ArrayList<ArrayList<Task>> actualDailyTasks = schedule.getDailyTasks();

        assertEquals("getDailyTasks did not return expected result; incorrect return value size"
            , expextedDailyTasks.size(), actualDailyTasks.size());

        for (int i = 0; i < expextedDailyTasks.size(); i++) {
            assertEquals("getDailyTasks did not return expected result", expextedDailyTasks.get(i), actualDailyTasks.get(i));
        }
    }

    /* Tests for the Scheduler class */

    /**
     *  Test that the format for the schedule output is correct
     */
    @Test
    public void testSchedulerGetFormatted() {
        Task task1 = null;
        Task task2 = null;

        Fox fox = new Fox("Snowball", 1);
        Coyote coyote = new Coyote("Narseh", 2);

        try {
            task1 = new Task("Eyedrops", 25, 1, 22, fox);
            task2 = new Task("Give fluid injection", 10, 1, 22, coyote);
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task1);
        dailyTasks.add(task2);
        Schedule schedule = new Schedule(dailyTasks);

        String expResult = "Schedule for " + LocalDate.now().plusDays(1) + "\n\n";
        expResult += "22:00\n";
        expResult += "* Eyedrops (Snowball)\n";
        expResult += "* Give fluid injection (Narseh)\n";
        String actResult = Scheduler.getFormatted(schedule.getDailyTasks());

        assertEquals("getFormatted did not return expected result", expResult, actResult);
    }

}

