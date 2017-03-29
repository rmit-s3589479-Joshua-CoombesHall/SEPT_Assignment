
package bookingmanager;
import java.util.ArrayList;
import java.util.Date;

public class Login 
{	
	private ArrayList<User> users;
	private User currentUser;
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
        
        public User getCurrentUser()
        {
            return currentUser;
        }
        
        //Test Data.
        public void loadTestUsers()
        {
            users.add(new Customer(0, "testCustomer@test.com", "test", "Jim", "Jenson", new Date(), "00000000"));
            users.add(new Business(0, "testBusiness@test.com", "test", "Globocom", "5 Fake St, Fakesville", "00000000"));
        }
}
