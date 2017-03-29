/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import bookingmanager.ApplicationDriver;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    private HBox header;
    
    //Menus
    private LoginMenu loginMenu;
    private RegistrationMenu registrationMenu;
    private BusinessMenu businessMenu;
    private EmployeeMenu employeeMenu;
    
    
    public MenuManager(ApplicationDriver a_driver, Stage a_primaryStage)
    {
        driver = a_driver;
        primaryStage = a_primaryStage;
        loginMenu = new LoginMenu(this);
        registrationMenu = new RegistrationMenu(this);
        businessMenu = new BusinessMenu(this);
        employeeMenu = new EmployeeMenu(this);
        currentMenu = loginMenu;
        initMainPane();
        initStage();
        
    }
    
    public ApplicationDriver getDriver()
    {
        return driver;
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
        header = new HBox();
        header.setId("header");
        header.setAlignment(Pos.CENTER);
        Label heading = new Label("Appointment Booking System");
        heading.setId("heading");
        header.getChildren().add(heading);
        mainPane.setTop(header);
    }
    
    private void initStage()
    {
        primaryStage.setTitle("Appointment Booking System");
        menuScene = new Scene(mainPane, windowWidth, windowHeight);
        menuScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        primaryStage.setScene(menuScene);
        menuScene.setRoot(mainPane);
        primaryStage.show();
    }
    
    /*
    Menu References:
    Login
    Registration
    RegistrationSuccess
    CustomerMainMenu
    BusinessMainMenu
    
    */
    public void switchMenu(String a_menuRef)
    {
        Menu targetMenu = null;
        //Switch statement here.
        if(a_menuRef.equals("Login"))
        {
            targetMenu = loginMenu;
        }
        else if(a_menuRef.equals("Registration"))
        {
            targetMenu = registrationMenu;
        }
        else if(a_menuRef.equals("RegistrationSuccess"))
        {
            targetMenu = registrationMenu;
        }
        else if(a_menuRef.equals("RegistrationSuccess"))
        {
            //targetMenu = registrationMenu;
        }
        else if(a_menuRef.equals("CustomerMainMenu"))
        {
            //targetMenu = registrationMenu;
        }
        else if(a_menuRef.equals("BusinessMainMenu"))
        {
            targetMenu = businessMenu;
        }
        else if(a_menuRef.equals("EmployeeMenu"))
        {
            targetMenu = employeeMenu;
        }
        
        if(targetMenu!=null)
        {
            targetMenu.onEntry();
        }
        currentMenu.onExit();
        currentMenu = targetMenu;
        
        mainPane.setCenter(currentMenu.getPane());
    }
}
