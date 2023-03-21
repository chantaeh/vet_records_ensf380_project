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
        Nocturnal nocturnal = Fox;  // Upcast to Diurnal
        
        int[] expected = {0, 1, 2};
        int[] actual = nocturnal.getFeedingHours();
        
        assertArrayEquals(expected, actual);
    }
    /*test fox constructor */
    @Test
    public void testFox() {
        String name = "Fox";
        int numAnimals = 1;
        
        Fox fox = new Fox(name, numAnimals);
        
        assertEquals(name, fox.getName());
        assertEquals(numAnimals, fox.getNumAnimals());
        }
    /*test fox methods */
    @Test
    public void testFoxGetFeedMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals(5, fox.getFeedMins());
    }

    @Test
    public void testFoxGetFeedinPrepMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals(5, fox.getFeedinPrepMins());
    }

    @Test
    public void testFoxGetCageCleanMins() {
        Fox fox = new Fox("Fox", 1);
        assertEquals(5, fox.getCageCleanMins());
    }

    /*trash panda tests */
    /*test getFeedingHours inherited from nocturnal*/
    @Test
    public void testRaccoonGetFeedingHours() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        Nocturnal nocturnal = Raccoon;  // Upcast to Diurnal
        
        int[] expected = {0, 1, 2};
        int[] actual = nocturnal.getFeedingHours();
        
        assertArrayEquals(expected, actual);
    }
    /*test raccoon constructor */
    @Test
    public void testRaccoon() {
        String name = "Raccoon";
        int numAnimals = 1;
        
        Raccoon raccoon = new Raccoon(name, numAnimals);
        
        assertEquals(name, raccoon.getName());
        assertEquals(numAnimals, raccoon.getNumAnimals());
        }
    /*test raccoon methods */
    @Test
    public void testRaccoonGetFeedMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals(5, raccoon.getFeedMins());
    }

    @Test
    public void testRaccoonGetFeedinPrepMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals(0, raccoon.getFeedinPrepMins());
    }

    @Test
    public void testRaccoonGetCageCleanMins() {
        Raccoon raccoon = new Raccoon("Raccoon", 1);
        assertEquals(5, raccoon.getCageCleanMins());
    }    

    /*beaver tests */
    /*test getFeedingHours inherited from diurnal  */
    @Test
    public void testBeaverGetFeedingHours() {
        Beaver beaver = new Beaver("Beaver", 1);
        Diurnal diurnal = beaver;  // Upcast to Diurnal
        
        int[] expected = {8, 9, 10};
        int[] actual = diurnal.getFeedingHours();
        
        assertArrayEquals(expected, actual);
    }
    /*test beaver constructor */
    @Test
    public void testBeaver() {
        String name = "Beaver";
        int numAnimals = 1;
        
        Beaver beaver = new Beaver(name, numAnimals);
        
        assertEquals(name, beaver.getName());
        assertEquals(numAnimals, beaver.getNumAnimals());
        }

    /*test beaver methods */
    @Test
    public void testBeaverGetFeedMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals(5, beaver.getFeedMins());
    }

    @Test
    public void testBeaverGetFeedinPrepMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals(0, beaver.getFeedinPrepMins());
    }

    @Test
    public void testBeaverGetCageCleanMins() {
        Beaver beaver = new Beaver("Beaver", 1);
        assertEquals(5, beaver.getCageCleanMins());
    }    

    /*porcupine tests */
    /*test getFeedingHours inherited from nocturnal*/
    @Test
    public void testPorcupineGetFeedingHours() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        Crepuscular crepuscular = porcupine;  // Upcast to Diurnal
        
        int[] expected = {0, 1, 2};
        int[] actual = nocturnal.getFeedingHours();
        
        assertArrayEquals(expected, actual);
    }
    /*test porcupine constructor */
    @Test
    public void testPorcupine() {
        String name = "Porcupine";
        int numAnimals = 1;
        
        Porcupine porcupine = new Porcupine(name, numAnimals);
        
        assertEquals(name, porcupine.getName());
        assertEquals(numAnimals, porcupine.getNumAnimals());
        }
    /*test porcupine methods */
    @Test
    public void testPorcurpineGetFeedMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals(5, porcupine.getFeedMins());
    }

    @Test
    public void testPorcurpineGetFeedinPrepMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals(0, porcupine.getFeedinPrepMins());
    }

    @Test
    public void testPorcurpineGetCageCleanMins() {
        Porcupine porcupine = new Porcupine("Porcupine", 1);
        assertEquals(10, porcupine.getCageCleanMins());
    }
    /*coyote tests */
   /*test getFeedingHours inherited from nocturnal*/
   @Test
   public void testCoyoteGetFeedingHours() {
       Coyote coyote = new Coyote("Coyote", 1);
       Crepuscular crepuscular = Coyote;  // Upcast to Diurnal
       
       int[] expected = {0, 1, 2};
       int[] actual = nocturnal.getFeedingHours();
       
       assertArrayEquals(expected, actual);
   }
   /*test coyote constructor */
   @Test
   public void testCoyote() {
       String name = "Coyote";
       int numAnimals = 1;
       
       Coyote coyote = new Coyote(name, numAnimals);
       
       assertEquals(name, coyote.getName());
       assertEquals(numAnimals, coyote.getNumAnimals());
       }
    /*test coyote methods*/
    @Test
    public void testCoyoteGetFeedMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals(5, coyote.getFeedMins());
    }

    @Test
    public void testCoyoteGetFeedinPrepMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals(10, coyote.getFeedinPrepMins());
    }

    @Test
    public void testCoyoteGetCageCleanMins() {
        Coyote coyote = new Coyote("Coyote", 1);
        assertEquals(5, coyote.getCageCleanMins());
    }              
}
