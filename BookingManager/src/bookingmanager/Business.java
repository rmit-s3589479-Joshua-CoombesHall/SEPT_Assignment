/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author joshuahall
 */
public class Business extends User
{
    private String name;
    private String address;
    private String contactNumber;
    private int timeSlotLength;
    private Date[] openingTimes;
    private Date[] closingTimes;
        /*
     * Ruaraidh Leary
     * List of employees for business
     */
    private ArrayList<Employee> employees;
    ArrayList<Timeslot> timeslots;
    Business(int a_id, String a_email, String a_password, String a_name, String a_address, String a_contactNumber)
    {
        super(a_id, a_email, a_password);
        name = a_name;
        address = a_address;
        contactNumber = a_contactNumber;
        employees = new ArrayList<Employee>();
        timeslots = new ArrayList<Timeslot>();
        openingTimes = new Date[7];
        closingTimes = new Date[7];
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public String getContactNumber()
    {
        return contactNumber;
    }
    
    public void setTimeSlotLength(int a_time)
    {
        timeSlotLength = a_time;
    }
    
    public void setOpeningTimes(Date[] times)
    {
        for(int i = 0; i < 7; i++)
        {
            openingTimes[i] = new Date(0, 0, 0, times[i].getHours(), times[i].getMinutes());
        }
    }
    
    public void setClosingTimes(Date[] times)
    {
        for(int i = 0; i < 7; i++)
        {
            closingTimes[i] = new Date(0, 0, 0, times[i].getHours(), times[i].getMinutes());
        }
    }
    
    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }
    
    /*
     * Ruaraidh Leary
     * Adds employee to business' list of employees
     */
    public void addEmployee(String name)
    {
    	employees.add(new Employee(name));
    }
    
    /*
     * Ruaraidh Leary
     * Books time slot
     */
    public boolean bookTimeSlot(Timeslot slot, Customer customer)
    {
    	return false;
    }
    
    //By Tony
    public boolean createTimeSlot (Date startTime, Date endTime, Employee workingEmployee) 
    {
            //Checking the validity of proposed Timeslot.
            /* 
             * 
             * */
        Date currentDate = new Date();
        if(startTime.after(endTime) || startTime.before(currentDate)) 
        {
            return false;
        }
        timeslots.add(new Timeslot(startTime, workingEmployee));
        return true;
    }
}

