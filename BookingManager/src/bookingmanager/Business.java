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
        /*
     * Ruaraidh Leary
     * List of employees for business
     */
    private ArrayList<Employee> employees;
    private ArrayList<Timeslot> timeslots;
    private ArrayList<Appointment> appointments;
    Business(int a_id, String a_email, String a_password, String a_name, String a_address, String a_contactNumber)
    {
        super(a_id, a_email, a_password);
        name = a_name;
        address = a_address;
        contactNumber = a_contactNumber;
        employees = new ArrayList<Employee>();
        timeslots = new ArrayList<Timeslot>();
        appointments = new ArrayList<Appointment>();
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
        timeslots.add(new Timeslot(startTime));
        return true;
    }
    
    /* Harry Meskell
     * Cycles through all timeslots, comparing each one to appointments
     * If the timeslot is not in an appointment already, it is available
     * and is added to an arrayList which is returned.
    */
    public ArrayList<Timeslot> getAvailableTimeslots()
    {
        ArrayList<Timeslot> availableTimes = new ArrayList<Timeslot>();
        boolean found = false;
        
         for(int i=0; i<timeslots.size();i++)
         {
             for(int j=0; j<appointments.size();j++)
             {
                 if(appointments.get(j).getTimeslot().equals(timeslots.get(i)))
                 {
                     found = true;
                     break;
                 }
             }
             if(found == true) found = false;
             else availableTimes.add(timeslots.get(i));
         }
         
         return availableTimes;
    }
}

