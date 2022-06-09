import java.util.Date;
import java.util.Scanner;

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

    public static Courier sample() {
        return  new Courier(Parcel.sample(), new Delivery(Mode.AIRPLANE));
    }
    public static void main(String[] args) {
        Courier c = sample();
        Scanner sc = new Scanner(System.in);
        while(c.delivery.getState() != Status.DELIVERED) {
            System.out.print("Press enter: ");
            sc.nextLine();
            System.out.println(
                c.checkProgress()
            );
        }
    }
}