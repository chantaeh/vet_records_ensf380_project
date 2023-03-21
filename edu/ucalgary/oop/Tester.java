/**
 * JUnit Tester class
 * @author Group 25
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

public class Tester {
      
    /*fox tests */
    /*test getFeedingHours inherited from nocturnal*/
    @Test
    public void testFoxGetFeedingHours() {
        Fox fox = new Fox("Fox", 1);
        Nocturnal nocturnal = Fox;  // Upcast to nocturnal
        
        int[] expected = {0, 1, 2};
        int[] actual = nocturnal.getFeedingHours();
        
        assertArrayEquals("Fox class is not inheriting getFeedingHours from Nocturnal class", expected, actual);
    }
    /*test fox constructor */
    @Test
    public void testFox() {
        String name = "Fox";
        int numAnimals = 1;
        
        Fox fox = new Fox(name, numAnimals);
        
        assertEquals("Fox Constructor does not return 'name' correctly", name, fox.getName());
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
        Nocturnal nocturnal = Raccoon;  // Upcast to nocturnal
        
        int[] expected = {0, 1, 2};
        int[] actual = nocturnal.getFeedingHours();
        
        assertArrayEquals("Raccoon class is not inheriting getFeedingHours from Nocturnal class",expected, actual);
    }
    /*test raccoon constructor */
    @Test
    public void testRaccoon() {
        String name = "Raccoon";
        int numAnimals = 1;
        
        Raccoon raccoon = new Raccoon(name, numAnimals);
        
        assertEquals("Raccoon Constructor does not return 'name' correctly", name, raccoon.getName());
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
        Diurnal diurnal = beaver;  // Upcast to Diurnal
        
        int[] expected = {8, 9, 10};
        int[] actual = diurnal.getFeedingHours();
        
        assertArrayEquals("Beaver class is not inheriting getFeedingHours from Diurnal class", expected, actual);
    }
    /*test beaver constructor */
    @Test
    public void testBeaver() {
        String name = "Beaver";
        int numAnimals = 1;
        
        Beaver beaver = new Beaver(name, numAnimals);
        
        assertEquals("Beaver Constructor does not return 'name' correctly", name, beaver.getName());
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




}

