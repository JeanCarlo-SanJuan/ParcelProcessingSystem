import java.util.Date;
import java.util.Scanner;

import javax.print.attribute.DateTimeSyntax;

public class Courier {
    private Delivery delivery;
    private Parcel parcel;
    private Date startTime;
    private final int SECOND = 1000;
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
        long timePassed = (new Date()).getTime() - this.startTime.getTime();

        if (timePassed > SECOND * 20) {
            this.delivery.setState(Status.DELIVERED);
        } else
        if (timePassed > SECOND * 10) {
            this.delivery.setState(Status.ON_DELIVERY);
        }

        return this.delivery.getState();
    }

    public static void main(String[] args) {
        Courier c =  new Courier(Parcel.sample());
        Scanner sc = new Scanner(System.in);
        System.out.print("Press enter: ");
        sc.nextLine();
        System.out.println(
            c.checkProgress()
        );
    }
}