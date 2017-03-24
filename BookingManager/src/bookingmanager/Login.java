
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
        
        /*
        public void loadData()
        {
        	Customer newUser;
        	jsonArray = new JSONArray();
        	for(int i =0; jsonArray.length(); i++)
        	{
        		newUser.a_id = (JSONObject) jsonArray.get("id");
        		newUser.a_email = (JSONObject) jsonArray.get("email");
        		newUser.a_password = (JSONObject) jsonArray.get("password");
        		newUser.a_firstName = (JSONObject) jsonArray.get("fname");
        		newUser.a_lastName = (JSONObject) jsonArray.get("lname");
        		newUser.a_dob = (JSONObject) jsonArray.get("dob");
        		newUser.a_number = (JSONObject) jsonArray.get("number");
        	}
        	
        	users.add(newUser);
        }
        */
        public boolean addCustomer(int id, String email, String password, String fname, String lname, Date dob, String number)
        {
        	users.add(new Customer(id, email, password, fname, lname, dob, number));
        	/* Check if user added */
        	for(int i = 0; i < users.size(); i++)
        	{
        		if(id == users.get(i).getId())
        		{
        			return true;
        		}
        		else
        		{
        			return false;
        		}
        	}
        }
}