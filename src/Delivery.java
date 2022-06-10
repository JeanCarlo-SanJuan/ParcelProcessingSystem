
/**
 * @summary A class that holds the relevant info about a delivery.
 * @author Jean Carlo M. San Juan
 */
public class Delivery {
    private Mode mode;
    private Status state;

    public Delivery(Mode m, Status s) {
        this.mode = m;
        this.state = s;
    }
    
    //Default creation
    public Delivery() {
        this.mode = Mode.VEHICLE;
        this.state = Status.PICKUP;
    }

    public void setState(Status s) {
        this.state = s;
    }

    public void setMode(Mode m) {
        this.mode = m;
    }

    public Status getState() {
        return this.state;
    }

    public Mode getMode() {
        return this.mode;
    }

    public int getSpeed() {
        return this.mode.ordinal() + 1;
    }
}