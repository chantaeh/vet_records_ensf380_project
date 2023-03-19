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

    /**
     * Test that Nocturnal inherits from Animal
     */
    @Test
    public void testNocturnalSuperclass() {
        Class superclass = Nocturnal.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Animal", simpleClassName);
    }

    /**
     * Test that Diurnal inherits from Animal
     */
    @Test
    public void testDiurnalSuperclass() {
        Class superclass = Diurnal.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Animal", simpleClassName);
    }

    /**
     * Test that Crepuscular inherits from Animal
     */
    @Test
    public void testCrepuscularSuperclass() {
        Class superclass = Crepuscular.getSuperclass();

        String simpleClassName = superclass.getSimpleName();
        assertEquals("Animal", simpleClassName);
    }

    /**
     * Test that Nocturnal is an abstract class
     */
    @Test
    public void testNocturnalAbstract() {
        Class aClass = Nocturnal.class;
        int modifiers = aClass.getModifiers();
        assertTrue(Modifier.isAbstract(modifiers));
    }

    /**
     * Test that Diurnal is an abstract class
     */
    @Test
    public void testDiurnalAbstract() {
        Class aClass = Diurnal.class;
        int modifiers = aClass.getModifiers();
        assertTrue(Modifier.isAbstract(modifiers));
    }

    /**
     * Test that Crepuscular is an abstract class
     */
    @Test
    public void testCrepuscularAbstract() {
        Class aClass = Crepuscular.class;
        int modifiers = aClass.getModifiers();
        assertTrue(Modifier.isAbstract(modifiers));
    }

    /**
     * Test Nocturnal class's static getter method
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
     * Test Diurnal class's static getter method 
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
     * Test Crepuscular class's static getter method
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