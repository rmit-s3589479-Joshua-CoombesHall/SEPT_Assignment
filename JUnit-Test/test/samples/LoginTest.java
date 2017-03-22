package samples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Harry Meskell
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of login method, of class Login.
     */
    @Test
    public void testLogin() {
        String emailOne = "test@test.com";
        String passwordOne = "password";
        String emailTwo = "test@hello.com";
        String passwordTwo = "passw0rd";
        String wrongEmail = "wrong@wrong.com";
        String wrongPassword = "wrong";
        
        Login testLogin = new Login();

        assertTrue(testLogin.login(emailOne, passwordOne));  //User one, correct
        assertTrue(testLogin.login(emailTwo, passwordTwo)); //User two, correct
        assertFalse(testLogin.login(emailOne, passwordTwo)); //Email one + password two
        assertFalse(testLogin.login(wrongEmail, passwordOne)); //Wrong email + correct password
        assertFalse(testLogin.login(emailOne, wrongPassword)); //Correct email + wrong password
        assertFalse(testLogin.login(wrongEmail, wrongPassword)); //Wrong email + password
        assertFalse(testLogin.login("", passwordOne)); //Blank email
        assertFalse(testLogin.login(emailOne, "")); //Blank password
        assertFalse(testLogin.login("","")); //Everything blank
    }
    
}
