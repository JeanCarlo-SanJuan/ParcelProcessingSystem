import java.util.Date;

public class Courier {
    private Delivery delivery;
    private Parcel parcel;
    private Date startTime;
    public Courier(Parcel p, Delivery d) {
        this.parcel = p;
        this.delivery = d;
        this.startTime = new Date();
    }

    public Courier(Parcel p) {
        this.parcel = p;
        this.delivery = new Delivery();
        this.startTime = new Date();
    }

    public Status checkProgress() {
        Date cTime =  new Date();

        int timePassed = cTime.compareTo(this.startTime);

        //Measured in MS
        if (timePassed > 1000 && timePassed < 3000) {
            this.delivery.setState(Status.ON_DELIVERY);
        } else if (timePassed > 6000) {
            this.delivery.setState(Status.DELIVERED);
        }

        return this.delivery.getState();
    }

    public static void main(String[] args) {
        Courier c =  new Courier(p);
    }
}