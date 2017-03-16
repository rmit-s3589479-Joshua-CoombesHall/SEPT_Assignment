/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

/**
 *
 * @author joshuahall
 */
public class MenuManager
{
    private int windowWidth = 900;
    private int windowHeight = 600;
    private ApplicationDriver driver;
    private Stage primaryStage;
    private Menu currentMenu;
    private Scene menuScene;
    private BorderPane mainPane;
    
    //Menus
    private LoginMenu loginMenu;
    MenuManager(ApplicationDriver a_driver, Stage a_primaryStage)
    {
        driver = a_driver;
        primaryStage = a_primaryStage;
        loginMenu = new LoginMenu(this);
        currentMenu = loginMenu;
        initMainPane();
        initStage();
        
    }
    
    private void initMainPane()
    {
        mainPane = new BorderPane();
        mainPane.setCenter(currentMenu.getPane());
        initHeader();
    }
    
    private void initHeader()
    {
        //This is where I will add the header info.
    }
    
    private void initStage()
    {
        primaryStage.setTitle("Appointment Booking System");
        primaryStage.setScene(new Scene(mainPane, windowWidth, windowHeight));
        primaryStage.show();
    }
    
    private void switchMenu(Menu a_newMenu)
    {
        a_newMenu.onEntry();
        currentMenu.onExit();
        currentMenu = a_newMenu;
        mainPane.setCenter(currentMenu.getPane());
    }
}
