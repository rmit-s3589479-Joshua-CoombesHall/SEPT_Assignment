/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

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
public class BusinessMainMenu extends Menu
{
    
    BusinessMainMenu(MenuManager a_manager)
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
        
        Text heading = new Text("Customer Main Menu");
        content.add(heading, 0, 0);
        
        Button loginButton = new Button("Button1");
        GridPane.setHalignment(loginButton, HPos.CENTER);
        content.add(loginButton, 0, 1);

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
