
package bookingmanager;
import java.util.ArrayList;
import java.util.Date;
import org.json;

public class Login 
{	
	ArrayList<User> users;
	User currentUser;
	Login()
	{
            users = new ArrayList<User>();
            loadTestUsers();
            currentUser = null;
	}
	public boolean login(String email, String password) 
        {
            for(int i = 0; i < users.size(); i++) 
            {
                if(email.equals(users.get(i).getEmail())) 
                {
                    System.out.println("User Found");
                    if(password.equals(users.get(i).getPassword())) 
                    {
                        currentUser = users.get(i);
                        return true;
                    } 
                    else 
                    {
                        System.out.println("Password Invalid");
                        return false;
                    }
                }
            }
            return false;
	}
        
        //Test Data.
        public void loadTestUsers()
        {
            users.add(new Customer(0, "test@test.com", "test", "Jim", "Jenson", new Date(), "00000000"));
        }
        

        
        /* Adds new customer to customer array. Returns false if email is already in list, otherwise adds user and returns true
         * Doesn't save to file yet
         * @author Ruaraidh Leary
         */
        public boolean addCustomer(int id, String email, String password, String fname, String lname)
        {
        	/* Check if user already registered */
        	for(int i = 0; i < users.size(); i++)
        	{
        		if(email == users.get(i).getEmail())
        		{
        			return false;
        		}
        	}
        	users.add(new Customer(id, email, password, fname, lname,));
        	return true;

        	}
        }
}