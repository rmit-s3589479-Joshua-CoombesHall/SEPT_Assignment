package bookingmanager;
import java.util.Date;

/* @author Tony Tan - s3439530 */
public class Timeslot {
	private Date startTime;
	private Date apptDate;
	
	Timeslot(Date a_startTime, Date a_apptDate) {
		startTime = a_startTime;
		apptDate = a_apptDate;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public Date getDate() {
		return apptDate;
	}
}
