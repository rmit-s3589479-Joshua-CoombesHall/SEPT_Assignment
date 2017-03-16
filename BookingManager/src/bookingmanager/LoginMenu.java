/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

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
        TextField emailField = new TextField();
        getPane().add(emailField, 1, 1);
        PasswordField passwordField = new PasswordField();
        getPane().add(passwordField, 1, 2);
        Button loginButton = new Button("Login");
        getPane().add(loginButton, 1, 3);
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
