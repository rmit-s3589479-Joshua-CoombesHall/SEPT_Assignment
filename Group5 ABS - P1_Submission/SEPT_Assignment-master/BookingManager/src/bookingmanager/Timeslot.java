package bookingmanager;
import java.util.Comparator;
import java.util.Date;

/* @author Tony Tan - s3439530 */
/* # Added employeeID 10:59am - 31/03/2017 - Tony */
public class Timeslot
{
	private Date apptDate;
	private int employeeID;
        private Appointment appt;
	Timeslot(Date a_apptDate, int a_employeeID) {
		apptDate = a_apptDate;
		employeeID = a_employeeID;
                appt = null;
	}

	public Date getDate() {
		return apptDate;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
        
        public void setAppointment(Appointment a_appt)
        {
            appt = a_appt;
        }
        
        public boolean equals(Timeslot comparing)
        {
            if(this.apptDate.compareTo(comparing.getDate()) == 0 && this.employeeID == comparing.getEmployeeID())
            {
                return true;
            }
            else return false;
        }

        /*
        @Override
        public int compare(Timeslot a, Timeslot b) 
        {
            if(a.getDate().after(b.getDate()))
            {
                return 1;
            }
            else if(a.getDate().before(b.getDate()))
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
*/

}
