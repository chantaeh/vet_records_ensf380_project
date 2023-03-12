/**
 * JUnit Tester class
 * @author Group 25
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

public class Tester {

    /**
     * Tests if Nocturnal class's static getter method works
     */
    @Test
    public void testNocturnalGetFeedingHours() {
        int[] expectedNocturnalHours = {0, 1, 2};
        int[] actualNocturnalHours = Nocturnal.getFeedingHours();

        for (int i = 0; i < expectedNocturnalHours.length; i++) {
            assertEquals(expectedNocturnalHours[i], actualNocturnalHours[i]);
        }
    } 
    
    /**
     * Tests if Diurnal class's static getter method works
     */
    @Test
    public void testDiurnalGetFeedingHours() {
        int[] expectedDiurnalHours = {8, 9, 10};
        int[] actualDiurnalHours = Diurnal.getFeedingHours();

        for (int i = 0; i < expectedDiurnalHours.length; i++) {
            assertEquals(expectedDiurnalHours[i], actualDiurnalHours[i]);
        }
    } 

    /**
     * Tests if Crepuscular class's static getter method works
     */
    @Test
    public void testCrepuscularGetFeedingHours() {
        int[] expectedCrepuscHours = {19, 20, 21};
        int[] actualCrepuscHours = Crepuscular.getFeedingHours();

        for (int i = 0; i < expectedCrepuscHours.length; i++) {
            assertEquals(expectedCrepuscHours[i], actualCrepuscHours[i]);
        }
    } 

}