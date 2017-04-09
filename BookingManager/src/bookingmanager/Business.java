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
    private String ownerFirstName;
    private String ownerLastName;
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
    private ArrayList<Timeslot> timeslots;
    private ArrayList<Appointment> appointments;
    Business(int a_id, String a_email, String a_password, String a_name, String a_ownerFirstName, String a_ownerLastName, String a_address, String a_contactNumber)
    {
        super(a_id, a_email, a_password);
        name = a_name;
        ownerFirstName = a_ownerFirstName;
        ownerLastName = a_ownerLastName;
        address = a_address;
        contactNumber = a_contactNumber;
        employees = new ArrayList<Employee>();
        timeslots = new ArrayList<Timeslot>();
        timeSlotLength = 30;
        openingTimes = new Date[7];
        closingTimes = new Date[7];
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
    
    public void setTimeSlotLength(int a_time)
    {
        timeSlotLength = a_time;
    }
    
    public int getTimeSlotLength()
    {
        return timeSlotLength;
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
    	employees.add(new Employee(name, getNextID()));
    }
    
    public int getNextID()
    {
        int highestID = 0;
        for(int e = 0; e < employees.size(); e++)
        {
            if(employees.get(e).getID() > highestID)
            {
                highestID = employees.get(e).getID();
            }
        }
        return highestID+1;
    }
    

    public ArrayList<Timeslot> getAllTimeslots()
    {
        return timeslots;
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
    public boolean createTimeSlot (Date startTime, Employee workingEmployee) 
    {
            //Checking the validity of proposed Timeslot.
            /* 
             * 
             * */
        Date currentDate = new Date();
        if(startTime.before(currentDate)) 
        {
            return false;
        }
        timeslots.add(new Timeslot(startTime, workingEmployee.getID()));
        return true;
    }
    
    //By Josh.
    public void deleteTimeSlots(Date startTime, Date endTime, Employee workingEmployee)
    {
        for(int i = 0; i < timeslots.size(); i++)
        {
            if(timeslots.get(i).getEmployeeID() == workingEmployee.getID())
            {
                if(timeslots.get(i).getDate().equals(startTime) || (timeslots.get(i).getDate().after(startTime) && timeslots.get(i).getDate().before(endTime)))
                {
                    timeslots.remove(i);
                    i--;
                }
            }
        }
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

