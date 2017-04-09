package bookingmanager;

/*
 * @author Ruaraidh Leary
 * # Added employeeID 11:00am - 31/03/2017 - Tony *
 */
public class Employee
{
	private String firstName;
        private String lastName;
        private String contactNumber;
        private String email;
	private int employeeID;
        
	
	Employee(String a_firstName, String a_lastName, String a_contactNumber, String a_email, int a_employeeID)
	{
            firstName = a_firstName;
            lastName = a_lastName;
            contactNumber = a_contactNumber;
            email = a_email;
            employeeID = a_employeeID;
	}
	
	public String getFirstName()
	{
            return firstName;
	}
        
        public String getLastName()
	{
            return lastName;
	}
        
        public String getContactNumber()
	{
            return contactNumber;
	}
        
        public String getEmail()
	{
            return email;
	}
        
	public int getID()
	{
            return employeeID;
	}
}
