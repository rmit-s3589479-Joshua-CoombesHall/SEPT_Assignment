
package bookingmanager;
import java.util.ArrayList;

public class Login 
{	
	ArrayList<User> users;
	User currentUser;
	Login()
	{
		users = new ArrayList<User>();
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
}
