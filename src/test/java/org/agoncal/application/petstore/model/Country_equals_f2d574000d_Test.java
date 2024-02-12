// ********RoostGPT********
/*
Test generated by RoostGPT for test pomXmlTest using AI Type Open AI and AI Model gpt-4

1. Scenario: Test when the 'o' object is the same as 'this' object.
   - Input: Pass 'this' object as an argument to the equals function.
   - Expected Result: The function returns true since both are the same objects.

2. Scenario: Test when the 'o' object is null.
   - Input: Pass null as an argument to the equals function.
   - Expected Result: The function returns false since the object is null.

3. Scenario: Test when the 'o' object is not null but of a different class.
   - Input: Pass an object of a different class as an argument to the equals function.
   - Expected Result: The function returns false since the classes of the objects are not the same.

4. Scenario: Test when the 'o' object is not null and of the same class, but the isoCode is different.
   - Input: Pass an object of the Country class with a different isoCode as an argument to the equals function.
   - Expected Result: The function returns false since the isoCode of the objects are not the same.

5. Scenario: Test when the 'o' object is not null, of the same class, and the isoCode is the same.
   - Input: Pass an object of the Country class with the same isoCode as an argument to the equals function.
   - Expected Result: The function returns true since both the objects are of the Country class and have the same isoCode.

6. Scenario: Test when the isoCode of the 'this' object is null.
   - Input: Set the isoCode of 'this' object to null and pass an object of the Country class with a non-null isoCode.
   - Expected Result: The function should throw a NullPointerException as it attempts to access a null object.

7. Scenario: Test when the isoCode of the 'o' object is null.
   - Input: Pass an object of the Country class with a null isoCode.
   - Expected Result: The function should return false as the isoCodes are not the same (one is null).
*/

// ********RoostGPT********
package org.agoncal.application.petstore.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Country_equals_f2d574000d_Test {

    @Test
    public void testEqualsSameObject() {
        Country country1 = new Country("isoCode1", "name1", "printableName1", "iso31", "numcode1");
        assertTrue(country1.equals(country1));
    }

    @Test
    public void testEqualsNullObject() {
        Country country1 = new Country("isoCode1", "name1", "printableName1", "iso31", "numcode1");
        assertFalse(country1.equals(null));
    }

    @Test
    public void testEqualsDifferentClassObject() {
        Country country1 = new Country("isoCode1", "name1", "printableName1", "iso31", "numcode1");
        String stringObject = new String("some string");
        assertFalse(country1.equals(stringObject));
    }

    @Test
    public void testEqualsDifferentIsoCode() {
        Country country1 = new Country("isoCode1", "name1", "printableName1", "iso31", "numcode1");
        Country country2 = new Country("isoCode2", "name2", "printableName2", "iso32", "numcode2");
        assertFalse(country1.equals(country2));
    }

    @Test
    public void testEqualsSameIsoCode() {
        Country country1 = new Country("isoCode1", "name1", "printableName1", "iso31", "numcode1");
        Country country2 = new Country("isoCode1", "name2", "printableName2", "iso32", "numcode2");
        assertTrue(country1.equals(country2));
    }

    @Test
    public void testEqualsThisIsoCodeNull() {
        Country country1 = new Country(null, "name1", "printableName1", "iso31", "numcode1");
        Country country2 = new Country("isoCode2", "name2", "printableName2", "iso32", "numcode2");
        assertThrows(NullPointerException.class, () -> {
            country1.equals(country2);
        });
    }

    @Test
    public void testEqualsOtherIsoCodeNull() {
        Country country1 = new Country("isoCode1", "name1", "printableName1", "iso31", "numcode1");
        Country country2 = new Country(null, "name2", "printableName2", "iso32", "numcode2");
        assertFalse(country1.equals(country2));
    }

}
