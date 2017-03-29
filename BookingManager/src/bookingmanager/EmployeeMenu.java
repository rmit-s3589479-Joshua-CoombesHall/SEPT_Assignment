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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author joshuahall
 */
public class EmployeeMenu extends Menu
{
    TextField addEmployeeNameField;
    EmployeeMenu(MenuManager a_manager)
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
        
        Text heading = new Text("Employee Menu");
        content.add(heading, 0, 0);
        HBox innerContent = new HBox();
        content.add(innerContent, 0, 1);
        GridPane employeePane = new GridPane();
        innerContent.getChildren().add(employeePane);
        VBox employeeListPane = new VBox();
        employeePane.add(employeeListPane, 0, 0);
        for(int i = 0; i < 5; i++)
        {
            employeeListPane.getChildren().add(new Label("Employee " + i));
        }
        GridPane addEmployeePane = new GridPane();
        employeePane.add(addEmployeePane, 0, 1);
        Label addEmployeeHeading = new Label("Add Employee");
        addEmployeePane.add(addEmployeeHeading, 0, 0);
        addEmployeeNameField = new TextField();
        addEmployeeNameField.setPromptText("Employee Name");
        addEmployeePane.add(addEmployeeNameField, 0, 1);
        
        Button addEmployeeButton = new Button("Add");
        addEmployeePane.add(addEmployeeButton, 1, 1);
        addEmployeeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //Validate employee field and add them to the business.
            }
        });
        
        /*for(int i = 0; i < getEmployeeList().length(); i++)
        {
            employeeListPane.getChildren().add(new Label(getEmployeeList().get(i).getName()))
        }*/
        
        /*registerButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });*/

    }
    
    /*private ArrayList<User> getEmployeeList()
    {
        return getManager().getDriver().getLogin().getCurrentUser().getEmployees();
    }*/
    
    @Override
    public void onEntry()
    {
        
    }

    @Override
    public void onExit()
    {

    }
}
