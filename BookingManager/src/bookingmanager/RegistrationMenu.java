/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import java.time.LocalDate;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author joshuahall
 */
public class RegistrationMenu extends Menu
{
    
    private TextField emailField;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField contactNumberField;
    private TextField passwordField1;
    private TextField passwordField2;
    private DatePicker dobField;
    private Label errorLabel;
    
    //Validation Elements
    private final int FIRST_NAME_MAX_LEN = 50;
    private final int LAST_NAME_MAX_LEN = 50;
    private final int PHONE_NUMBER_LEN = 10;
    private final int PASSWORD_MIN_LEN = 8;
    private final int PASSWORD_MAX_LEN = 24;
    private final int DOB_MIN_YEAR = 1900;
    
    RegistrationMenu(MenuManager a_manager)
    {
        super(a_manager);
        initMenu();
    }
    
    @Override
    public void initMenu()
    {
        GridPane content = new GridPane();
        getPane().add(content, 0, 0);
        content.setId("root");
        content.setHgap(10);
        content.setVgap(10);
        content.setPadding(new Insets(0,0,0,0));
        
        Text heading = new Text("Registration Menu");
        content.add(heading, 0, 0, 2, 1);
        
        emailField = new TextField();
        emailField.setPromptText("Email");
        content.add(emailField, 0, 1, 2, 1);
        
        firstNameField = new TextField();
        firstNameField.setPromptText("First");
        content.add(firstNameField, 0, 2);
        
        lastNameField = new TextField();
        lastNameField.setPromptText("Last");
        content.add(lastNameField, 1, 2);
        
        dobField = new DatePicker();
        dobField.setPromptText("Date of birth");
        dobField.setValue(LocalDate.of(1980, 1, 1));
        GridPane.setHalignment(dobField, HPos.CENTER);
        content.add(dobField, 0, 3, 2, 1);
        
        contactNumberField = new TextField();
        contactNumberField.setPromptText("Contact Number");
        content.add(contactNumberField, 0, 4, 2, 1);
        
        passwordField1 = new PasswordField();
        passwordField1.setPromptText("Password");
        content.add(passwordField1, 0, 5, 2, 1);
        
        passwordField2 = new PasswordField();
        passwordField2.setPromptText("Re-enter Password");
        content.add(passwordField2, 0, 6, 2, 1);
        
        Button registerButton = new Button("Register");
        GridPane.setHalignment(registerButton, HPos.CENTER);
        content.add(registerButton, 0, 7, 2, 1);
        
        errorLabel = new Label("");
        errorLabel.getStyleClass().add("errorLabel");
        getPane().add(errorLabel,0,1);
        
        
        content.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                if(event.getCode() == KeyCode.ENTER)
                {
                    registerButton.fire();
                }
            }
        });
        
        registerButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                registrationSubmitted();
            }
        });

    }
    
    private void registrationSubmitted()
    {
        if(fieldsAreValid())
        {
            //getManager().getDriver().getLogin().addCustomer();
        }
    }
    
    private boolean fieldsAreValid()
    {
        boolean fieldsValid = true;
        if(!fieldsHaveInput())
        {
            errorLabel.setText("Please fill in all fields.");
            fieldsValid = false;
        }
        else if(!passwordsMatch())
        {
            errorLabel.setText("Passwords do not match.");
            fieldsValid = false;
        }
        else if(!inputLengthsValid())
        {
            fieldsValid = false;
        }
        else if(!fieldsValidFormat())
        {
            fieldsValid = false;
        }
        
        if(fieldsValid)
        {
            return true;
        }
        else
        {
            passwordField1.setText("");
            passwordField2.setText("");
            return false;
        }
    }
    
    private boolean fieldsHaveInput()
    {
        if(emailField.getText().equals("") || 
            firstNameField.getText().equals("") || 
            lastNameField.getText().equals("") || 
            contactNumberField.getText().equals("") || 
            passwordField1.getText().equals("") || 
            passwordField2.getText().equals(""))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private boolean passwordsMatch()
    {
        if(passwordField1.getText().equals(passwordField2.getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean inputLengthsValid()
    {
        boolean lengthsValid = true;
        if(firstNameField.getText().length() > FIRST_NAME_MAX_LEN)
        {
            errorLabel.setText("First name is too long. ("+ FIRST_NAME_MAX_LEN + " Characters)");
            lengthsValid = false;
        }
        else if(lastNameField.getText().length() > LAST_NAME_MAX_LEN)
        {
            errorLabel.setText("Last name is too long. ("+ LAST_NAME_MAX_LEN + " Characters)");
            lengthsValid = false;
        }
        else if(contactNumberField.getText().length() != PHONE_NUMBER_LEN)
        {
            errorLabel.setText("Contact number is not " + PHONE_NUMBER_LEN + " digits.");
            lengthsValid = false;
        }
        else if(passwordField1.getText().length() < PASSWORD_MIN_LEN || passwordField1.getText().length() > PASSWORD_MAX_LEN)
        {
            errorLabel.setText("Password is not a valid length. (" + PASSWORD_MIN_LEN + "-" + PASSWORD_MAX_LEN + " Characters.");
            lengthsValid = false;
        }
        else if(dobField.getValue().isAfter(LocalDate.now()))
        {
            errorLabel.setText("Time traveller! But seriously, you can't be born after the current date.");
        }
        else if(dobField.getValue().isBefore(LocalDate.of(1900, 1, 1)))
        {
            errorLabel.setText("No offense, but I doubt you are that old. You can lie to us if you need to.");
        }
        if(!lengthsValid)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private boolean fieldsValidFormat()
    {
        for(int i = 0; i < contactNumberField.getText().length(); i++)
        {
            if(!Character.isDigit(contactNumberField.getText().charAt(i)))
            {
                errorLabel.setText("Phone number can only be digits.");
                return false;
            }
        }
        for(int i = 0; i < firstNameField.getText().length(); i++)
        {
            if(!Character.isAlphabetic(firstNameField.getText().charAt(i)))
            {
                errorLabel.setText("First name can only be characters.");
                return false;
            }
        }
        for(int i = 0; i < lastNameField.getText().length(); i++)
        {
            if(!Character.isAlphabetic(lastNameField.getText().charAt(i)))
            {
                errorLabel.setText("Last name can only be characters.");
                return false;
            }
        }
        
        /* THis wasn't working.
        Pattern ptr = Pattern.compile(("[a-zA-Z0-9.-]*@[a-zA-Z0-9.-]*"));
        if(ptr.matcher(emailField.getText()).matches())
        {
            errorLabel.setText("That is not a valid email address.");
            return false;
        }
        */
        return true;
        
    }
    
    @Override
    public void onEntry()
    {
        
    }

    @Override
    public void onExit()
    {

    }
}
