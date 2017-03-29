/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Harry Meskell
 */
public class BusinessTest {
    
    public BusinessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testAddEmployee()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        
        assertTrue(testBus.addEmployee("John Smith")); //Correct adding
        
        assertFalse(testBus.addEmployee("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz")); //Too long
        assertFalse(testBus.addEmployee("2")); //Just a number
        assertFalse(testBus.addEmployee("J0hn")); //Contains a number
        assertFalse(testBus.addEmployee("")); //blank
    }
    
    @Test
    public void testAddTimeslot()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        testBus.addEmployee("Bill Knight");
        //Date(int year, int month, int date, int hrs, int min)
        Date validStartTime = new Date(2017,04,01,10,10);
        Date validEndTime = new Date(2017,04,01,10,30);
        Employee validEmployee = testBus.getEmployees().get(1);

        assertTrue(testBus.createTimeSlots(validStartTime, validEndTime, validEmployee)); //Correct
        
        assertFalse(testBus.createTimeSlots(validStartTime, validEndTime, testBus.getEmployees().get(testBus.getEmployees().size()+1))); //Index out of bounds
        assertFalse(testBus.createTimeSlots(validStartTime, validEndTime, new Employee("New Fella"))); //New employee
        assertFalse(testBus.createTimeSlots(validStartTime, validEndTime, null)); //Employee is null
        
        assertFalse(testBus.createTimeSlots(validStartTime, new Date(2000,01,01,01,01), validEmployee)); //End time already passed
        assertFalse(testBus.createTimeSlots(validStartTime, new Date(2017,04,01), validEmployee)); //End Date has no time
        assertFalse(testBus.createTimeSlots(validStartTime, new Date(2017,04,01,01,01), validEmployee)); //End time is before start time
        assertFalse(testBus.createTimeSlots(validStartTime, new Date(2017,04,02,01,01), validEmployee)); //End time is different date to start time
        assertFalse(testBus.createTimeSlots(validStartTime, null, validEmployee)); //End time is null
        
        assertFalse(testBus.createTimeSlots(new Date(2000,01,01,01,01), validEndTime, validEmployee)); //Start time already passed
        assertFalse(testBus.createTimeSlots(new Date(2017,04,01), validEndTime, validEmployee)); //Start date has no time
        assertFalse(testBus.createTimeSlots(null, validEndTime, validEmployee)); //Start time is null

    }

    
}
