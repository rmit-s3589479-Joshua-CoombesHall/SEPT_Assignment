
package samples;
import java.util.ArrayList;
import java.util.Date;

public class Login 
{	
	ArrayList<User> users;
	User currentUser;
	Login()
	{
		users = new ArrayList<User>();
		currentUser = null;
                users.add(new Customer(1, "test@test.com", "password", "John", "Smith", new Date(), "0477123123"));
                users.add(new Customer(2, "test@hello.com", "passw0rd", "Jane", "Smith", new Date(), "0477123123"));
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
                        System.out.println("Password correct");
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
