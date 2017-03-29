/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

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
    Business(int a_id, String a_email, String a_password, String a_name, String a_address, String a_contactNumber)
    {
        super(a_id, a_email, a_password);
        name = a_name;
        address = a_address;
        contactNumber = a_contactNumber;
    }
    
    /*
     * Ruaraidh Leary
     * List of employees for business
     */
    ArrayList<Employee> employees;
    
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
    public boolean bookTimeSlot(TimeSlot slot, Customer customer)
    {
    	
    }
}

