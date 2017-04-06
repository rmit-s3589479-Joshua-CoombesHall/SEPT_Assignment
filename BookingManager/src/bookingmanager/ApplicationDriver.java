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
 */
//Test (Harry)
public class ApplicationDriver extends Application
{
    private MenuManager menuManager;
    private App app;
    private ReadFile reader;
    private WriteFile writer;
    @Override
    public void start(Stage primaryStage)
    {
        menuManager = new MenuManager(this, primaryStage);
        app = new App();
        reader = new ReadFile();
        writer = new WriteFile();
        app.setUsers(reader.readFromFile());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void stop()
    {
        writer.writetoFile(app.getUsers());
    }
    
    public App getApp()
    {
        return app;
    }
}
