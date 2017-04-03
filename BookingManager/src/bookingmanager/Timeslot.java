package bookingmanager;
import java.util.Date;

/* @author Tony Tan - s3439530 */
/* # Added employeeID 10:59am - 31/03/2017 - Tony */
public class Timeslot {
	private Date apptDate;
	private int employeeID;
	
	Timeslot(Date a_apptDate, int a_employeeID) {
		apptDate = a_apptDate;
		employeeID = a_employeeID;
	}

	public Date getDate() {
		return apptDate;
	}
	
	public int getID() {
		return employeeID;
	}
        
        public boolean equals(Timeslot comparing)
        {
            if(this.apptDate.compareTo(comparing.getDate()) == 0 && this.employeeID == comparing.getID())
            {
                return true;
            }
            else return false;
        }
}
