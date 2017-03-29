package bookingmanager;
import java.util.Date;

/* @author Tony Tan - s3439530 */
public class Timeslot {
	private Date apptDate;
	
	Timeslot(Date a_apptDate) {
		apptDate = a_apptDate;
	}

	public Date getDate() {
		return apptDate;
	}
}
