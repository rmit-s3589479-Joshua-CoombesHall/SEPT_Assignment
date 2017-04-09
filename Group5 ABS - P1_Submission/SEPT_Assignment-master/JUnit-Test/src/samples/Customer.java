package samples;

import java.util.Date;

/**
 *
 * @author joshuahall
 */
public class Customer extends User
{
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String contactNumber;
    Customer(int a_id, String a_email, String a_password, String a_firstName, String a_lastName, Date a_dateOfBirth, String a_contactNumber)
    {
        super(a_id, a_email, a_password);
        firstName = a_firstName;
        lastName = a_lastName;
        dateOfBirth = a_dateOfBirth;
        contactNumber = a_contactNumber;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    public String getContactNumber()
    {
        return contactNumber;
    }
}
