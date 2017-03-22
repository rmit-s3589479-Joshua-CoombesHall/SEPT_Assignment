package samples;

/**
 * @author joshuahall
 */
public abstract class User
{
    protected int id;
    protected String email;
    protected String password;
    User(int a_id, String a_email, String a_password)
    {
        id = a_id;
        email = a_email;
        password = a_password;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getPassword()
    {
        return password;
    }
}

