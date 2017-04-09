package bookingmanager;

/**
 *
 * @author Harry Meskell
Appointment
This class represents an appointment that a customer has booked. It acts as the link
between a Timeslot and a Customer.
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
