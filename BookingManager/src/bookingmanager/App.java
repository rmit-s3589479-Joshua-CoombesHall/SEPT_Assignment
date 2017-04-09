
package bookingmanager;
import java.util.ArrayList;
import java.util.Date;

/*
App
This class is the heart of the program which manages all of the users, and is the main channel that connects
the menus to the functionality.
*/
public class App 
{	
    private ArrayList<User> users;
    private User currentUser;
    private ReadFile reader;
    App()
    {
        users = new ArrayList();
        reader = new ReadFile();
        //Loads the users from file.
        users.addAll(reader.readFromFile());
        //If there was no file to load, loads the test data.
        if(users.isEmpty())
        {
            loadTestUsers();
        }
        currentUser = null;
    }
    //Logs the user in.
    public boolean login(String email, String password) 
    {
        for(int i = 0; i < users.size(); i++) 
        {
            if(email.equals(users.get(i).getEmail())) 
            {
                if(password.equals(users.get(i).getPassword())) 
                {
                    currentUser = users.get(i);
                    return true;
                } 
                else 
                {
                    return false;
                }
            }
        }
        return false;
    }
    
    public void setUsers(ArrayList<User> newUsers)
    {
        users = newUsers;
    }
    
    public ArrayList<User> getUsers()
    {
        return users;
    }
    
    //Gets the user who is currently logged in.
    public User getCurrentUser()
    {
        return currentUser;
    }

    //Test Data.
    public void loadTestUsers()
    {
        users.add(new Customer(0, "testCustomer1@test.com", "test", "Greg", "Gregson", new Date(), "00000000"));
        users.add(new Customer(0, "testCustomer2@test.com", "test", "Jim", "Jimson", new Date(), "00000000"));
        users.add(new Customer(0, "testCustomer3@test.com", "test", "Jenny", "Jenson", new Date(), "00000000"));
        users.add(new Business(0, "testBusiness1@test.com", "test", "Globocom", "Ownerman", "McOwner", "5 Fake St, Fakesville", "00000000"));
        users.add(new Business(0, "testBusiness2@test.com", "test", "WorldWideAutomation", "Rob", "Otto", "7 Fake St, Fakesville", "00000000"));
        users.add(new Business(0, "testBusiness3@test.com", "test", "Evilcom", "Snevil", "Manly", "9 Fake St, Fakesville", "00000000"));
    }



    /* Adds new customer to customer array. Returns false if email is already in list, otherwise adds user and returns true
     * Doesn't save to file yet
     * @author Ruaraidh Leary
     */
    public boolean addCustomer(int id, String email, String password, String fname, String lname, Date dob, String contactNumber)
    {
        /* Check if user already registered */
        for(int i = 0; i < users.size(); i++)
        {
            if(email.equals(users.get(i).getEmail()))
            {
                    return false;
            }
        }
        users.add(new Customer(id, email, password, fname, lname, dob, contactNumber));
        return true;
    }
}
