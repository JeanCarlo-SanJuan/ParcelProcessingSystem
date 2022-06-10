import java.util.Date;
import java.util.Scanner;

/**
 * @summary A runner class representing a person who works as a courier.
 * @author Jean Carlo M. San Juan
 */
public class Courier {
    public Delivery delivery;
    public final Parcel parcel;
    private Date startTime = new Date();
    private final int SECOND = 1000;
    public Courier(Parcel p, Delivery d) {
        this.parcel = p;
        this.delivery = d;
    }

    public Courier(Parcel p) {
        this.parcel = p;
        this.delivery = new Delivery();
    }

    /**
     * Mutates the delivery state based on an arbitrary value.
     * @summary Simulates the timeline of a parcel being delivered
     */
    public Status checkProgress() {
        long timePassed = (new Date()).getTime() - this.startTime.getTime();
        
        int spdAsSeconds = SECOND * this.delivery.getSpeed();
        if (timePassed > 15 * spdAsSeconds) {
            this.delivery.setState(Status.DELIVERED);
        } else
        if (timePassed > 5 * spdAsSeconds) {
            this.delivery.setState(Status.ON_DELIVERY);
        }

        return this.delivery.getState();
    }
}
