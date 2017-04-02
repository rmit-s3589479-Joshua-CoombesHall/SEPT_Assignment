package bookingmanager;
import java.util.Date;

/* @author Tony Tan - s3439530 */
public class Timeslot {
	private Date apptDate;
        private Employee assignedEmployee;
	
	Timeslot(Date a_apptDate, Employee a_employee) 
        {
		apptDate = a_apptDate;
                assignedEmployee = a_employee;
	}

	public Date getDate() {
		return apptDate;
	}
        
        public Employee getEmployee() {
		return assignedEmployee;
	}
}
