/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author joshuahall
ApplicationDriver
This class drives the program by starting MenuManager, and by separating the menus
from the functionality. It also handles saving to file on program quit.
*/
//Test (Harry)
public class ApplicationDriver extends Application
{
    private MenuManager menuManager;
    private App app;
    private WriteFile writer;
    @Override
    public void start(Stage primaryStage)
    {
        menuManager = new MenuManager(this, primaryStage);
        app = new App();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    //This saves the current program state to file on exiting.
    @Override
    public void stop()
    {
        writer = new WriteFile();
        writer.writetoFile(app.getUsers());
    }
    
    public App getApp()
    {
        return app;
    }
}
