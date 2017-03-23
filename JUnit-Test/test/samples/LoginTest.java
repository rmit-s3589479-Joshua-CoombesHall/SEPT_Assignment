package samples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

/**
 *
 * @author Harry Meskell
 */
public class LoginTest {
    
    @Test
    public void testLogin() {
        String emailOne = "test@test.com";
        String passwordOne = "test";
        String emailTwo = "test@hello.com";
        String passwordTwo = "password";
        String wrongEmail = "wrong@wrong.com";
        String wrongPassword = "wrong";
        
        Login testLogin = new Login();
        testLogin.loadTestUsers();

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
    
    @Test
    public void testAddCustomers()
    {
        /* addCustomer(email:String, password:String, firstName:String, lastName:String, 
           dateOfBirth:Date, contactNumber:String):boolean */
        
        Login testLogin = new Login();
        
        String validEmail = "test@test.com";
        String validPass = "password";
        String validFName = "John";
        String validLName = "Smith";
        Date validDOB = new Date(1997, 1, 1);
        String validNumber = "0477123123";
        
        
        assertTrue(testLogin.addCustomer(validEmail, validPass, validFName, validLName, validDOB, validNumber));//Everything valid, registration successful
        
        assertFalse(testLogin.addCustomer(validEmail, validPass, "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", validLName, validDOB, validNumber)); //First name too long (more than 50 chars)
        assertFalse(testLogin.addCustomer(validEmail, validPass, "hell0", validLName, validDOB, validNumber));//First name contains numbers
        assertFalse(testLogin.addCustomer(validEmail, validPass, "", validLName, validDOB, validNumber));//First name blank
        
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", validDOB, validNumber));//Surname too long (more than 50 chars)
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, "hell0", validDOB, validNumber));//Surname contains numbers
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, "", validDOB, validNumber));//Surname blank
        
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, validLName, validDOB, "123456789f"));//Phone number contains non-number characters
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, validLName, validDOB, "12"));//Phone number too short (less than 10 digits)
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, validLName, validDOB, ""));//Phone number blank
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, validLName, validDOB, "12345678901"));//Phone number too long (more than 10 digits)
        
        assertFalse(testLogin.addCustomer("testtest.com", validPass, validFName, validLName, validDOB, validNumber));//Email address missing @
        assertFalse(testLogin.addCustomer("test@test", validPass, validFName, validLName, validDOB, validNumber));//Email address missing .com (or similar)
        assertFalse(testLogin.addCustomer("@test.com", validPass, validFName, validLName, validDOB, validNumber));//Email address missing chars before @
        assertFalse(testLogin.addCustomer("test@.com", validPass, validFName, validLName, validDOB, validNumber));//Email address missing domain
        assertFalse(testLogin.addCustomer("", validPass, validFName, validLName, validDOB, validNumber));//Email address blank
        
        assertFalse(testLogin.addCustomer(validEmail, "pass", validFName, validLName, validDOB, validNumber));//Password too short (less than 8 chars)
        assertFalse(testLogin.addCustomer(validEmail, "passwordisfartoolongandthisshouldbemorethan24", validFName, validLName, validDOB, validNumber));//Password too long (more than 24 chars)
        assertFalse(testLogin.addCustomer(validEmail, "", validFName, validLName, validDOB, validNumber));//Password blank
        
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, validLName, new Date(1899, 1, 1), validNumber));//DOB year not before 1900
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, validLName, new Date(3000, 1, 1), validNumber));//DOB year not after current year
        assertFalse(testLogin.addCustomer(validEmail, validPass, validFName, validLName, null, validNumber));//DOB not blank
        
        
        
    }
    
}
