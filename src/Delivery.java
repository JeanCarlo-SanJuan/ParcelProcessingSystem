enum Mode {
    VEHICLE,
    BOAT,
    AIRPLANE
};

enum Status {
    PICKUP,
    ON_DELIVERY,
    DELIVERED,
    FAIL
}

public class Delivery {
    private final Mode mode;
    private Status state;

    public Delivery(Mode m, Status s) {
        this.mode = m;
        this.state = s;
    }

    
    public Delivery() {
        this.mode = Mode.VEHICLE;
        this.state = Status.PICKUP;
    }

    public Delivery(Mode m) {
        this.mode = m;
        this.state = Status.PICKUP;
    }

    public Delivery(Status s) {
        this.mode = Mode.VEHICLE;
        this.state = s;
    }

    public void setState(Status s) {
        this.state = s;
    }

    public Status getState() {
        return this.state;
    }
}