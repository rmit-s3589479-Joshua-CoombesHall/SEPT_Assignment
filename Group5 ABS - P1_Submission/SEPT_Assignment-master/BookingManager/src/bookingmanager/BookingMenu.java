/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import static java.util.Comparator.comparing;
import javafx.scene.control.CheckBox;

/**
 *
 * @author joshuahall
 */
public class BookingMenu extends Menu
{   
    ArrayList<Business> businessArray = new ArrayList();
    ComboBox employeeField;
    ComboBox dateField;
    CheckBox anyEmployeeSelector;
    Business selectedBusiness = null;
    VBox businessList;
    GridPane employeeSelector;
    GridPane dateSelector;
    GridPane apptSelectorShell;
    GridPane apptSelector;
    BookingMenu(MenuManager a_manager)
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
        Label heading = new Label("Booking Menu");
        content.add(heading, 0, 0, 2, 1);
        GridPane businessPanel = new GridPane();
        content.add(businessPanel, 0, 1, 1, 3);
        Label businessHeading = new Label("Business Selection");
        businessPanel.add(businessHeading, 0, 0);
        businessList = new VBox();
        ScrollPane scrollableBusinessList = new ScrollPane(businessList);
        scrollableBusinessList.setPrefHeight(300);
        scrollableBusinessList.setPrefWidth(200);
        scrollableBusinessList.setPadding(new Insets(10));
        businessPanel.add(scrollableBusinessList, 0, 1);
        
        employeeSelector = new GridPane();
        content.add(employeeSelector, 1, 1);
        Label employeeSelectorLabel = new Label("Please select the staff member you would prefer: ");
        employeeSelector.add(employeeSelectorLabel, 0, 0);
        employeeSelector.setVisible(false);
        
        /*
        dateSelector = new GridPane();
        content.add(dateSelector, 1, 2);
        Label dateSelectorHeading = new Label("Please select the day you would prefer");
        dateSelector.add(dateSelectorHeading, 0, 0);
        dateSelector.setVisible(false);
        */

        apptSelectorShell = new GridPane();
        Label apptSelectorHeading = new Label("Please select the appointment you would like:");
        apptSelectorShell.add(apptSelectorHeading, 0, 0);
        apptSelector = new GridPane();
        apptSelector.setHgap(10);
        apptSelector.setVgap(10);
        apptSelectorShell.add(apptSelector, 0, 1);
        apptSelector.setVisible(false);
        ScrollPane apptSelectorScrollable = new ScrollPane(apptSelector);
        apptSelectorScrollable.setPrefWidth(500);
        apptSelectorScrollable.setPrefHeight(400);
        content.add(apptSelectorScrollable, 1, 2);
    }
    
    
  
    private void updateBusinessList()
    {
        businessList.getChildren().clear();
        for(int i = 0; i < getManager().getDriver().getApp().getUsers().size(); i++)
        {
            if(getManager().getDriver().getApp().getUsers().get(i) instanceof Business)
            {
                Business curBus = (Business)getManager().getDriver().getApp().getUsers().get(i);
                businessArray.add(curBus);
                GridPane thisBusinessRecord = new GridPane();
                businessList.getChildren().add(thisBusinessRecord);
                Label thisBusinessNameLabel = new Label(curBus.getName());
                Label thisBusinessPhoneLabel = new Label(curBus.getContactNumber());
                Label thisBusinessAddressLabel = new Label(curBus.getAddress());
                thisBusinessRecord.add(thisBusinessNameLabel, 0, 0);
                thisBusinessRecord.add(thisBusinessPhoneLabel, 0, 1);
                thisBusinessRecord.add(thisBusinessAddressLabel, 0, 2);
                thisBusinessRecord.getStyleClass().add("businessRecord");
                thisBusinessRecord.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        for(int i = 0; i < businessList.getChildren().size(); i++)
                        {
                            if(businessList.getChildren().get(i).equals(event.getSource()))
                            {
                                selectedBusiness = businessArray.get(i);
                                updateEmployeeList();
                            }
                        }
                    }
                });
                
            }
        }
    }
    
    private void updateEmployeeList()
    {
        employeeSelector.setVisible(true);
        //dateSelector.setVisible(false);
        apptSelector.setVisible(false);
        ObservableList<String> options = FXCollections.observableArrayList();
        for(int i = 0; i < selectedBusiness.getEmployees().size(); i++)
        {
            options.add(selectedBusiness.getEmployees().get(i).getName());
        }
        
        employeeField = new ComboBox(options);
        employeeField.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    updateApptTimes();
                }
            });
        employeeSelector.add(employeeField, 0, 1);
        anyEmployeeSelector = new CheckBox();
        anyEmployeeSelector.setText("I dont mind who I see");
        anyEmployeeSelector.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    if(anyEmployeeSelector.isSelected())
                    {
                        employeeField.setDisable(true);
                        updateApptTimes();
                    }
                    else
                    {
                        employeeField.setDisable(false);
                    }
                }
            });
        employeeSelector.add(anyEmployeeSelector, 0, 2);
    }
    
    /*
    private void updateTimeChooser()
    {
        dateSelector.setVisible(true);
        apptSelectorShell.setVisible(false);
        ObservableList<String> options = FXCollections.observableArrayList();
        for(int i = 0; i < selectedBusiness.getEmployees().size(); i++)
        {
            options.add(selectedBusiness.getEmployees().get(i).getName());
        }
        
        employeeField = new ComboBox(options);
        employeeField.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    updateApptTimes();
                }
            });
        employeeSelector.add(employeeField, 0, 1);
    }
    */
    
    private void updateApptTimes()
    {
        apptSelector.getChildren().clear();
        apptSelector.setVisible(true);
        ArrayList<Timeslot> availableSlots = selectedBusiness.getAvailableTimeslots();
        Date curDate = new Date();
        for(int d = 0; d < 7; d++)
        {
            //This sets the time to be early so that on days that aren't the current day, any time can be booked.
            if(d==1)
            {
                curDate.setHours(0);
                curDate.setMinutes(0);
            }
            ArrayList<Timeslot> todaysSlots = new ArrayList();
            for(int i = 0; i < availableSlots.size(); i++)
            {
                if(availableSlots.get(i).getDate().getDay() == curDate.getDay() && 
                    availableSlots.get(i).getDate().getMonth() == curDate.getMonth() &&
                    availableSlots.get(i).getDate().getYear() == curDate.getYear() &&
                    availableSlots.get(i).getDate().after(curDate))
                {
                    todaysSlots.add(availableSlots.get(i));
                }
            }
            Collections.sort(todaysSlots, comparing(Timeslot::getDate));
            String colHeading = "";
            Date today = new Date();
            today.setDate(today.getDate()+d);
            Label colHeadingLabel = new Label(getDay(today.getDay()) + " (" + today.getDate() + "/" + (today.getMonth()+1) + ")");
            apptSelector.add(colHeadingLabel, d+1, 0);
            
            //Provides a sidebar with times if we are just looking at an individual employee.
            //I made a design decision against the sidebar, however I will keep it for now.
            //populateApptSelectorSidebar();
            
            int selectedEmployeeID = -1;
            if(!anyEmployeeSelector.isSelected())
            {
                selectedEmployeeID = selectedBusiness.getEmployees().get(employeeField.getSelectionModel().getSelectedIndex()).getID();
            }
            int curRow = 1;
            for(int i = 0; i < todaysSlots.size(); i++)
            {
                if(anyEmployeeSelector.isSelected() || todaysSlots.get(i).getEmployeeID() == selectedEmployeeID)
                {
                    Employee curEmployee = null;
                    for(int e = 0; e < selectedBusiness.getEmployees().size(); e++)
                    {
                        if(selectedBusiness.getEmployees().get(e).getID() == todaysSlots.get(i).getEmployeeID())
                        {
                            curEmployee = selectedBusiness.getEmployees().get(e);
                        }
                    }
                    Label thisApptTime = new Label(String.format("%1$tH:%1$tM", todaysSlots.get(i).getDate()) + " - " + curEmployee.getName());
                    apptSelector.add(thisApptTime, d+1, curRow);
                    curRow++;
                }
            }
            curDate.setDate(curDate.getDate()+1);
        }
    }
    
    private void populateApptSelectorSidebar()
    {
        if(!anyEmployeeSelector.isSelected())
        {
            Date startingTime = new Date();
            startingTime.setHours(9);
            startingTime.setMinutes(0);

            Date endingTime = new Date();
            endingTime.setHours(17);
            endingTime.setMinutes(1);
            int row = 0;
            while(startingTime.before(endingTime))
            {
                Label sideLabel = new Label(String.format("%1$tH:%1$tM", startingTime));   
                apptSelector.add(sideLabel, 0, row+1);
                startingTime.setMinutes(startingTime.getMinutes()+30);
                row++;
            }
        }
    }
    
    //This converts an int to a day's name in a string, based on the Date.getDay() function.
    private String getDay(int dateDay)
    {
        switch((dateDay)%7)
        {
            case 0:
            {
                return "Sun";
            }
            case 1:
            {
                return "Mon";
            }
            case 2:
            {
                return "Tue";
            }
            case 3:
            {
                return "Wed";
            }
            case 4:
            {
                return "Thu";
            }
            case 5:
            {
                return "Fri";
            }
            case 6:
            {
                return "Sat";
            }
            default:
            {
                return "";
            }
        }
    }
    
    @Override
    public void onEntry()
    {
        updateBusinessList();
    }

    @Override
    public void onExit()
    {
        
    }

    @Override
    public String getBackLocation()
    {
        return "CustomerMainMenu";
    }
}
