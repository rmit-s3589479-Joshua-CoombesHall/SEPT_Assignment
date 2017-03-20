/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author joshuahall
 */
public class LoginMenu extends Menu
{
    private TextField emailField;
    private TextField passwordField;
    
    LoginMenu(MenuManager a_manager)
    {
        super(a_manager);
        initMenu();
    }
    
    @Override
    public void initMenu()
    {
        getPane().setHgap(10);
        getPane().setVgap(10);
        getPane().setPadding(new Insets(0,0,0,0));
        Text loginHeading = new Text("Login");
        getPane().add(loginHeading, 0, 0, 2, 1);
        Text emailLabel = new Text("Email:");
        getPane().add(emailLabel, 0, 1);
        Text passwordLabel = new Text("Password:");
        getPane().add(passwordLabel, 0, 2);
        emailField = new TextField();
        getPane().add(emailField, 1, 1);
        passwordField = new PasswordField();
        getPane().add(passwordField, 1, 2);
        Button loginButton = new Button("Login");
        getPane().add(loginButton, 1, 3);
        loginButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                /*
                boolean loginSuccess = a_manager.getDriver().getLogin().login(emailField.getText(), passwordField.getText());
                if(loginSuccess)
                {
                    a_manager.switchMenu(a_manager.getMainMenu())
                }
                */
            }
        });
        /*
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Hello World!");
            }
        });
        */
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
