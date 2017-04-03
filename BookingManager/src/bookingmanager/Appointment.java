package bookingmanager;

/**
 *
 * @author Harry Meskell
 */
public class Appointment {
    private Timeslot timeslot;
    private Customer customer;
    
    public Appointment(Timeslot inTimeslot, Customer inCustomer)
    {
        timeslot = inTimeslot;
        customer = inCustomer;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public Timeslot getTimeslot()
    {
        return timeslot;
    }
    
}
