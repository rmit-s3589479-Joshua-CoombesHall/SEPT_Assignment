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

//    @Test
//    public void testAddEmployeeValid()
//    {
//        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
//        assertTrue(testBus.addEmployee("John Smith")); //Correct adding
//    }
//    
//    @Test
//    public void testAddEmployeeInvalid()
//    {
//        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
//
//        assertFalse(testBus.addEmployee("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz")); //Too long
//        assertFalse(testBus.addEmployee("2")); //Just a number
//        assertFalse(testBus.addEmployee("J0hn")); //Contains a number
//        assertFalse(testBus.addEmployee("")); //blank
//    }

    
    @Test
    public void testAddTimeslotValid()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        testBus.addEmployee("Bill Knight");
        //Date(int year, int month, int date, int hrs, int min)
        Date validStartTime = new Date(2017,04,01,10,10);
        Employee validEmployee = testBus.getEmployees().get(0);

        assertTrue(testBus.createTimeSlot(validStartTime, validEmployee)); //Correct
    }
    @Test
    public void testAddTimeslotInvalidEmployee()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        testBus.addEmployee("Bill Knight");
        //Date(int year, int month, int date, int hrs, int min)
        Date validStartTime = new Date(2017,04,01,10,10);
        
        assertFalse(testBus.createTimeSlot(validStartTime, new Employee("New Fella", 0101))); //New employee
        assertFalse(testBus.createTimeSlot(validStartTime, null)); //Employee is null
    }

    
    @Test
    public void testAddTimeslotInvalidStartTime()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        testBus.addEmployee("Bill Knight");
        //Date(int year, int month, int date, int hrs, int min)
        Employee validEmployee = testBus.getEmployees().get(0);
        
        assertFalse(testBus.createTimeSlot(new Date(2000,01,01,01,01), validEmployee)); //Start time already passed
        assertFalse(testBus.createTimeSlot(new Date(2017,04,01), validEmployee)); //Start date has no time
        assertFalse(testBus.createTimeSlot(null, validEmployee)); //Start time is null
    }
    
    @Test
    public void testGetAvailableTimeslotsValid()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        testBus.addEmployee("John Smith");
        testBus.addEmployee("Jane Smith");
        Employee testEmployee = testBus.getEmployees().get(0);
        Employee secondEmployee = testBus.getEmployees().get(1);
        Date testDate = new Date(202,1,1);
        Date testDateTwo = new Date(202,1,2);
        testBus.createTimeSlot(testDate, testEmployee);
        testBus.createTimeSlot(testDateTwo, secondEmployee);
        
        ArrayList<Timeslot> testArray = testBus.getAvailableTimeslots();
        
        assertEquals(testArray.get(0).getEmployeeID(), testEmployee.getID()); //First timeslot correct
        assertEquals(testArray.get(1).getEmployeeID(), secondEmployee.getID()); //Second timeslot correct
        assertEquals(2, testArray.size()); //Amount of timeslots correct
    }
    
    @Test
    public void testGetAvailableTimeslotsOneBooked()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        Customer testCustomer = new Customer(0, "test", "test", "test", "test", new Date(), "test");
        testBus.addEmployee("John Smith");
        testBus.addEmployee("Jane Smith");
        Employee testEmployee = testBus.getEmployees().get(0);
        Employee secondEmployee = testBus.getEmployees().get(1);
        Date testDate = new Date(202,1,1);
        Date testDateTwo = new Date(202,1,2);
        
        testBus.createTimeSlot(testDate, testEmployee);
        testBus.createTimeSlot(testDateTwo, secondEmployee);
        testBus.bookTimeSlot(testBus.getAvailableTimeslots().get(0), testCustomer);
        
        ArrayList<Timeslot> testArray = testBus.getAvailableTimeslots();
        
        assertEquals(testArray.get(1).getEmployeeID(), secondEmployee.getID()); //Timeslot correct
        assertEquals(1, testArray.size()); //Amount of timeslots correct
    }
    
    @Test
    public void testGetAvailableTimeslotsBlank()
    {
        Business testBus = new Business(0, "business@test.com", "businessPass", "Incompetech", "101 Test Street", "0412345678");
        
        ArrayList<Timeslot> testArray = testBus.getAvailableTimeslots();
        
        assertEquals(0, testArray.size());

    }

    
}
