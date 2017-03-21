/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author joshuahall
 */
public abstract class Menu
{
    private MenuManager manager;
    private GridPane rootPane;
    
    Menu(MenuManager a_manager)
    {
        manager = a_manager;
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setId("background");
    }
    public MenuManager getManager()
    {
        return manager;
    }
    //Called when we first create the menu.
    public abstract void initMenu();
    
    //Called when the menu is shown.
    public abstract void onEntry();
    
    //Called when we switch to another menu.
    public abstract void onExit();
    
    public GridPane getPane()
    {
        return rootPane;
    }
    
}
