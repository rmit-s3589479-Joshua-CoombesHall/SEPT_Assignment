package bookingmanager;

/*
 * @author Ruaraidh Leary
 * # Added employeeID 11:00am - 31/03/2017 - Tony *
 */
public class Employee
{
	private String name;
	private int employeeID;
	
	Employee(String a_name, int a_employeeID)
	{
		name = a_name;
		employeeID = a_employeeID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getID()
	{
		return employeeID;
	}
}
