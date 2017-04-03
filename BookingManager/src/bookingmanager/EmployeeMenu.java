/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import java.util.ArrayList;
import java.util.Date;
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
    TextField timeSlotLengthField;
    Business currentBusiness;
    VBox employeeListPane;
    
    Button[][] calender = new Button[7][3];
    TextField[][] openingTimes = new TextField[7][2];
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
        employeeListPane = new VBox();
        employeePane.add(employeeListPane, 0, 0);
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
                if(!addEmployeeNameField.getText().equals(""))
                {
                    currentBusiness.addEmployee(addEmployeeNameField.getText());
                    updateEmployeeList();
                }
            }
        });
        
        GridPane calenderPane = new GridPane();
        innerContent.getChildren().add(calenderPane);
        
        Date today = new Date();
        for(int i = 0; i < 7; i++)
        {
            String curHeading = "";
            switch((today.getDay()+i)%7)
            {
                case 0:
                {
                    curHeading += "Sun";
                    break;
                }
                case 1:
                {
                    curHeading += "Mon";
                    break;
                }
                case 2:
                {
                    curHeading += "Tue";
                    break;
                }
                case 3:
                {
                    curHeading += "Wed";
                    break;
                }
                case 4:
                {
                    curHeading += "Thu";
                    break;
                }
                case 5:
                {
                    curHeading += "Fri";
                    break;
                }
                case 6:
                {
                    curHeading += "Sat";
                    break;
                }
            }
            Date targetDayDate = new Date();
            targetDayDate.setDate(today.getDate()+ i);
            Label newDate = new Label(curHeading + "\n" + targetDayDate.getDate() + "/" + (targetDayDate.getMonth()+1));
            calenderPane.add(newDate, i+1, 0);
        }
        
        for(int i = 0; i < 3; i++)
        {
            Label time = new Label("9:00 A.M");
            calenderPane.add(time, 0, i+1);
        }
        
        for(int i = 0; i < 7; i++)
        {
            for(int x = 0; x < 3; x++)
            {
                calender[i][x] = new Button();
                calenderPane.add(calender[i][x], i+1, x+1);
            }
        }
        
        GridPane settingsPane = new GridPane();
        content.add(settingsPane, 0, 2);
        
        Label settingsHeading = new Label("Business Settings");
        settingsPane.add(settingsHeading, 0, 0);
        
        Label timeSlotLengthLabel = new Label("Time Slot Length: ");
        settingsPane.add(timeSlotLengthLabel, 0, 1);
        timeSlotLengthField = new TextField();
        settingsPane.add(timeSlotLengthField, 0, 2);
        
        GridPane openTimesPanel = new GridPane();
        settingsPane.add(openTimesPanel, 1, 0 ,1, 2);

        Label openTimesHeadingLabel = new Label("Operating Hours");
        openTimesPanel.add(openTimesHeadingLabel, 0, 0, 3, 1);
        Label openLabel = new Label("Opening");
        openTimesPanel.add(openLabel, 1, 1);
        Label closeLabel = new Label("Closing");
        openTimesPanel.add(closeLabel, 2, 1);
        Label monLabel = new Label("Mon");
        openTimesPanel.add(monLabel, 0, 2);
        Label tueLabel = new Label("Tue");
        openTimesPanel.add(tueLabel, 0, 3);
        Label wedLabel = new Label("Wed");
        openTimesPanel.add(wedLabel, 0, 4);
        Label thurLabel = new Label("Thur");
        openTimesPanel.add(thurLabel, 0, 5);
        Label friLabel = new Label("Fri");
        openTimesPanel.add(friLabel, 0, 6);
        Label satLabel = new Label("Sat");
        openTimesPanel.add(satLabel, 0, 7);
        Label sunLabel = new Label("Sun");
        openTimesPanel.add(sunLabel, 0, 8);
        for(int i = 0; i < 7; i++)
        {
            openingTimes[i][0] = new TextField();
            openTimesPanel.add(openingTimes[i][0], 1, i+3);
            openingTimes[i][1] = new TextField();
            openTimesPanel.add(openingTimes[i][1], 2, i+3);
        }
        
        /*registerButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });*/

    }
    
    private void applySettings()
    {
        if(Integer.getInteger(timeSlotLengthField.getText()) != null)
        {
            currentBusiness.setTimeSlotLength(Integer.parseInt(timeSlotLengthField.getText()));
        }
    }
    
    private void updateEmployeeList()
    {
        employeeListPane.getChildren().clear();
        for(int i = 0; i < getEmployeeList().size(); i++)
        {
            employeeListPane.getChildren().add(new Label(getEmployeeList().get(i).getName()));
        }
    }
    
    private ArrayList<Employee> getEmployeeList()
    {
        return currentBusiness.getEmployees();
    }
    
    @Override
    public void onEntry()
    {
        currentBusiness = (Business)getManager().getDriver().getLogin().getCurrentUser();
        updateEmployeeList();
    }

    @Override
    public void onExit()
    {

    }
}
