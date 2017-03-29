import java.util.ArrayList;
import java.util.Date;

public class CreateTimeSlot {
	/* @author Tony Tan - S3439530 */ 
	
	ArrayList<Timeslot> timeslots;
	CreateTimeSlot()
	{
		timeslots = new ArrayList<Timeslot>();
	}
	
	public boolean createTimeSlot (Date startTime, Date endTime, Employee workingEmployee) {
		//Checking the validity of proposed Timeslot.
		/* 
		 * 
		 * */
		Date currentDate = new Date();
		if(startTime.after(endTime) || startTime.before(currentDate)) {
			return false;
			}
		timeslots.add(new Timeslot(startTime));
		return true;
		}
}
