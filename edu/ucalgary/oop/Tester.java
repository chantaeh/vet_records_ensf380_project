/**
 * JUnit Tester class
 * @author Group 25
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.*;
import java.lang.reflect.*;

public class Tester {
      
    /*fox tests */
    /*test getFeedingHours inherited from nocturnal*/
    @Test
    public void testFoxGetFeedingHours() {
        Fox fox = new Fox("Fox", 1);
        
        int[] expected = {0, 1, 2};
        int[] actual = fox.getFeedingHours();
        
        assertArrayEquals("Fox class is not inheriting getFeedingHours from Nocturnal class", expected, actual);
    }
    /*test fox constructor */
    @Test
    public void testFox() {
        String name = "Fox";
        int numAnimals = 1;
        
        Fox fox = new Fox(name, numAnimals);
        
        assertEquals("Fox Constructor does not return 'name' correctly", name, fox.getAnimalNickname());
        assertEquals("Fox Constructor does not return 'numAnimals' correctly", numAnimals, fox.getNumAnimals());
        }

    
    /*test fox methods */
    @Test
    public void testFoxGetFeedMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals("Fox method GetFeedMins() does not return correct time.", 5, fox.getFeedMins());
    }

    @Test
    public void testFoxGetFeedingPrepMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals("Fox method GetFeedingPrepMins() does not return correct time.",5, fox.getFeedingPrepMins());
    }

    @Test
    public void testFoxGetCageCleanMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals("Fox method GetCageCleanMins() does not return correct time.", 5, fox.getCageCleanMins());
    }

    /* raccoon tests */
    /*test getFeedingHours inherited from nocturnal*/
    @Test
    public void testRaccoonGetFeedingHours() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        
        int[] expected = {0, 1, 2};
        int[] actual = raccoon.getFeedingHours();
        
        assertArrayEquals("Raccoon class is not inheriting getFeedingHours from Nocturnal class",expected, actual);
    }
    /*test raccoon constructor */
    @Test
    public void testRaccoon() {
        String name = "Raccoon";
        int numAnimals = 1;
        
        Raccoon raccoon = new Raccoon(name, numAnimals);
        
        assertEquals("Raccoon Constructor does not return 'name' correctly", name, raccoon.getAnimalNickname());
        assertEquals("Raccoon Constructor does not return 'numAnimals' correctly", numAnimals, raccoon.getNumAnimals());
        }
    /*test raccoon methods */
    @Test
    public void testRaccoonGetFeedMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals("Raccoon method GetFeedMins() does not return correct time.", 5, raccoon.getFeedMins());
    }

    @Test
    public void testRaccoonGetFeedingPrepMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals("Raccoon method GetFeedingPrepMins() does not return correct time.", 0, raccoon.getFeedingPrepMins());
    }

    @Test
    public void testRaccoonGetCageCleanMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals("Raccoon method GetCageCleanMins() does not return correct time.", 5, raccoon.getCageCleanMins());
    }    

    /*beaver tests */
    /*test getFeedingHours inherited from diurnal  */
    @Test
    public void testBeaverGetFeedingHours() {
        Beaver beaver = new Beaver("Beaver", 1);
        
        int[] expected = {8, 9, 10};
        int[] actual = beaver.getFeedingHours();
        
        assertArrayEquals("Beaver class is not inheriting getFeedingHours from Diurnal class", expected, actual);
    }
    /*test beaver constructor */
    @Test
    public void testBeaver() {
        String name = "Beaver";
        int numAnimals = 1;
        
        Beaver beaver = new Beaver(name, numAnimals);
        
        assertEquals("Beaver Constructor does not return 'name' correctly", name, beaver.getAnimalNickname());
        assertEquals("Beaver Constructor does not return 'numAnimals' correctly", numAnimals, beaver.getNumAnimals());
        }

    /*test beaver methods */
    @Test
    public void testBeaverGetFeedMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals("Beaver method GetFeedMins() does not return correct time.", 5, beaver.getFeedMins());
    }

    @Test
    public void testBeaverGetFeedingPrepMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals("Beaver method GetFeedingPrepMins() does not return correct time.", 0, beaver.getFeedingPrepMins());
    }

    @Test
    public void testBeaverGetCageCleanMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals("Beaver method GetCageCleanMins() does not return correct time.", 5, beaver.getCageCleanMins());
    }    

    /*porcupine tests */
    /*test getFeedingHours inherited from crepuscular*/
    @Test
    public void testPorcupineGetFeedingHours() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        Crepuscular crepuscular = porcupine;  // Upcast to crepuscular
        
        int[] expected = {0, 1, 2};
        int[] actual = nocturnal.getFeedingHours();
        
        assertArrayEquals("Porcupine class is not inheriting getFeedingHours from Crepuscular class",expected, actual);
    }
    /*test porcupine constructor */
    @Test
    public void testPorcupine() {
        String name = "Porcupine";
        int numAnimals = 1;
        
        Porcupine porcupine = new Porcupine(name, numAnimals);
        
        assertEquals("Porcupine Constructor does not return 'name' correctly", name, porcupine.getName());
        assertEquals("Porcupine Constructor does not return 'numAnimals' correctly", numAnimals, porcupine.getNumAnimals());
        }
    /*test porcupine methods */
    @Test
    public void testPorcurpineGetFeedMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals("Porcupine method GetFeedMins() does not return correct time.", 5, porcupine.getFeedMins());
    }

    @Test
    public void testPorcurpineGetFeedingPrepMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals("Porcupine method GetFeedingPrepMins() does not return correct time.", 0, porcupine.getFeedingPrepMins());
    }

    @Test
    public void testPorcurpineGetCageCleanMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals("Porcupine method GetCageCleanMins() does not return correct time.", 10, porcupine.getCageCleanMins());
    }
    /*coyote tests */
   /*test getFeedingHours inherited from crepuscular*/
   @Test
   public void testCoyoteGetFeedingHours() {
       Coyote coyote = new Coyote("Coyote", 1);
       Crepuscular crepuscular = Coyote;  // Upcast to crepuscular
       
       int[] expected = {0, 1, 2};
       int[] actual = nocturnal.getFeedingHours();
       
       assertArrayEquals("Coyote class is not inheriting getFeedingHours from Crepuscular class",expected, actual);
   }
   /*test coyote constructor */
   @Test
   public void testCoyote() {
       String name = "Coyote";
       int numAnimals = 1;
       
       Coyote coyote = new Coyote(name, numAnimals);
       
       assertEquals("Coyote Constructor does not return 'name' correctly", name, coyote.getName());
       assertEquals("Coyote Constructor does not return 'numAnimals' correctly", numAnimals, coyote.getNumAnimals());
       }
    /*test coyote methods*/
    @Test
    public void testCoyoteGetFeedMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals("Coyote method GetFeedMins() does not return correct time.", 5, coyote.getFeedMins());
    }

    @Test
    public void testCoyoteGetFeedingPrepMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals("Coyote method GetFeedingPrepMins() does not return correct time.", 10, coyote.getFeedingPrepMins());
    }

    @Test
    public void testCoyoteGetCageCleanMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals("Coyote method GetCageCleanMins() does not return correct time.", 5, coyote.getCageCleanMins());
    }   
    
    /*TESTS FOR ILLEGALARGUMENTEXCEPTION OF THE CONSTRUCTORS FOR FOX, RACCOON, ETC. */
    /*Fox constructor test for illegalargumentexception*/
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
        

    /*Raccoon constructor test for illegalargumentexception*/
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

    /*Beaver constructor test for illegalargumentexception*/
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

    /*Porcupine constructor test for illegalargumentexception*/
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

    /*Coyote constructor test for illegalargumentexception*/
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
        Animal animal = new Animal(animalNickname, numAnimals);
        animal.setNumAnimals(numAnimals);
        assertEquals("NumAnimals was not set correctly", numAnimals, animal.getNumAnimals());
    }



    

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

        // Test if Schedule is created when provided with a valid input

        assertNotNull("Time object should not be null", schedule);
    }

    @Test
    public void testScheduleConstructorException() {
        Fox fox = new Fox("Snowball", 1);
        Task task = new Task("Eyedrops", 25, 1, 30, fox);
        ArrayList<Task> dailyTasks = new ArrayList<>();
        dailyTasks.add(task);

        // Test if invalid task throws an exception 

        assertThrows("Invalid tasks should throw an exception", IllegalArgumentException.class, () -> {
            Schedule schedule = new Schedule(dailyTasks);
        });
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

        // Test if the sum of each individual task duration is correct

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

        // Test if the tasks are allocated to each hours correctly

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

        // Test if the format for the schedule output is correct

        assertEquals("getFormatted did not return expected result", expResult, actResult);
    }

}

