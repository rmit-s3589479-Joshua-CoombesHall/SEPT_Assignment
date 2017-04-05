/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import bookingmanager.Business;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
public class LoginMenu extends Menu
{
    private TextField emailField;
    private TextField passwordField;
    private Label errorLabel;
    
    LoginMenu(MenuManager a_manager)
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
        Label loginHeading = new Label("Login");
        content.add(loginHeading, 0, 0, 2, 1);
        Label emailLabel = new Label("Email:");
        content.add(emailLabel, 0, 1);
        Label passwordLabel = new Label("Password:");
        content.add(passwordLabel, 0, 2);
        emailField = new TextField();
        content.add(emailField, 1, 1);
        
        passwordField = new PasswordField();
        content.add(passwordField, 1, 2);
        
        //TEST INPUT
        emailField.setText("testBusiness@test.com");
        passwordField.setText("test");
        
        Button loginButton = new Button("Login");
        GridPane.setHalignment(loginButton, HPos.RIGHT);
        content.add(loginButton, 0, 3, 2, 1);
        
        Hyperlink registerLink = new Hyperlink();
        registerLink.setText("Don't have an account? Register here.");
        content.add(registerLink, 0, 4, 2, 1);
        
        errorLabel = new Label("");
        errorLabel.getStyleClass().add("errorLabel");
        getPane().add(errorLabel, 0, 1);
        
        registerLink.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                getManager().switchMenu("Registration");
            }
        });
        
        content.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                if(event.getCode() == KeyCode.ENTER)
                {
                    loginButton.fire();
                }
            }
        });
        
        loginButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                loginSubmitted();
            }
        });
    }
    
    private void loginSubmitted()
    {
        if(!emailField.getText().equals("") && !passwordField.getText().equals(""))
        {
            //Submit to login function
            if(getManager().getDriver().getLogin().login(emailField.getText(), passwordField.getText()))
            {
                if(getManager().getDriver().getLogin().getCurrentUser() instanceof Business)
                {
                    getManager().switchMenu("BusinessMainMenu");
                }
                else
                {
                    getManager().switchMenu("CustomerMainMenu");
                }
            }
            else
            {
                errorLabel.setText("Those details don't match our system. \nPlease try again.");
                passwordField.clear();
            }
        }
        else
        {
            errorLabel.setText("Please fill in both login fields");
            passwordField.clear();
        }
    }
    
    @Override
    public void onEntry()
    {
        getManager().setBackButtonVisibility(false);
    }

    @Override
    public void onExit()
    {
        errorLabel.setText("");
        emailField.setText("");
        passwordField.setText("");
        getManager().setBackButtonVisibility(true);
    }
    
    @Override
    public String getBackLocation()
    {
        return "";
    }
}
