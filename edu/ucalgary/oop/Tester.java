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

    @Test
    public void testGetFeedMins() {
        Fox fox = new Fox();
        assertEquals(5, fox.getFeedMins());
    }

    @Test
    public void testGetFeedinPrepMins() {
        Fox fox = new Fox();
        assertEquals(5, fox.getFeedinPrepMins());
    }

    @Test
    public void testGetCageCleanMins() {
        Fox fox = new Fox();
        assertEquals(5, fox.getCageCleanMins());
    }

    /*trash panda tests */

    @Test
    public void testGetFeedMins() {
        Raccoon raccoon = new Raccoon();
        assertEquals(5, racoon.getFeedMins());
    }

    @Test
    public void testGetFeedinPrepMins() {
        Raccoon raccoon = new Raccoon();
        assertEquals(0, raccoon.getFeedinPrepMins());
    }

    @Test
    public void testGetCageCleanMins() {
        Raccoon raccoon = new Raccoon();
        assertEquals(5, raccoon.getCageCleanMins());
    }    

    /*beaver tests */

    @Test
    public void testGetFeedMins() {
        Beaver beaver = new Beaver();
        assertEquals(5, beaver.getFeedMins());
    }

    @Test
    public void testGetFeedinPrepMins() {
        Beaver beaver = new Beaver();
        assertEquals(0, beaver.getFeedinPrepMins());
    }

    @Test
    public void testGetCageCleanMins() {
        Beaver beaver = new Beaver();
        assertEquals(5, beaver.getCageCleanMins());
    }    

    /*porcupine tests */

    @Test
    public void testGetFeedMins() {
        Porcupine porcupine = new Porcupine();
        assertEquals(5, porcupine.getFeedMins());
    }

    @Test
    public void testGetFeedinPrepMins() {
        Porcupine porcupine = new Porcupine();
        assertEquals(0, porcupine.getFeedinPrepMins());
    }

    @Test
    public void testGetCageCleanMins() {
        Porcupine porcupine = new Porcupine();
        assertEquals(10, porcupine.getCageCleanMins());
    }
    /*coyote tests */ 

    @Test
    public void testGetFeedMins() {
        Coyote coyote = new Coyote();
        assertEquals(5, coyote.getFeedMins());
    }

    @Test
    public void testGetFeedinPrepMins() {
        Coyote coyote = new Coyote();
        assertEquals(10, coyote.getFeedinPrepMins());
    }

    @Test
    public void testGetCageCleanMins() {
        Coyote coyote = new Coyote();
        assertEquals(5, coyote.getCageCleanMins());
    }              
}
