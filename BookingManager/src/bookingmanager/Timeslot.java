import java.util.Date;

/* @author Tony Tan - s3439530 */
public class Timeslot {
	private int startTime;
	private Date apptDate;
	
	Timeslot(int a_startTime, Date a_apptDate) {
		startTime = a_startTime;
		apptDate = a_apptDate;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public Date getDate() {
		return apptDate;
	}
}
