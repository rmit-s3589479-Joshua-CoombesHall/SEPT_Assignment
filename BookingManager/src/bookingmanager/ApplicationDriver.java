/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author joshuahall
 */
public class ApplicationDriver extends Application
{
    private MenuManager menuManager;
    private Login login;
    @Override
    public void start(Stage primaryStage)
    {
        menuManager = new MenuManager(this, primaryStage);
        login = new Login();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    public Login getLogin()
    {
        return login;
    }
}
