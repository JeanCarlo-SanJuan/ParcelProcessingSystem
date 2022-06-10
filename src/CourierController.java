import java.util.ArrayList;
/**
 * @author A singleton that manages access the list of Couriers created during the app's runtime.
 * @author Sons Justin Garcia
 * @author Jean Carlo M. San Juan
 */
public class CourierController {
    private ArrayList<Courier> couriers = new ArrayList<Courier>();

    public void push(Courier c) {
        this.couriers.add(c);
    }

    public ArrayList<Courier> getCouriers() {
        // this makes sure that we can't mutate the inner list.
        return new ArrayList<Courier>(couriers);
    }

    public Courier getCourierWithParcelID(String id) {
        for (Courier c: couriers) {
            if (c.parcel.ID.compareTo(id) == 0) {
                return c;
            }
        }

        return null;
    }

    /**
     * Determines the delivery priority of a parcel based on arbitrary calculations.
     * @param p
     */
    public Mode calculatePriority(Parcel p) {
        int bias = (int) Math.random() * 100;

        if (p.getPrice() < 100) {
            bias += 2;
        } else if (p.getPrice() < 1000) {
            bias += 1;
        } 

        if (p.getDescription() != null && p.getType() == "Mail") {
            if (p.getDescription().length() < 10) {
                bias += 1;
            } else {
                bias += 2;
            }
        }

        if (p.getDimension() != null) {
            double v = p.getDimension().volume;
            if (v > 500) {
                bias += 5;
            }
            if (v > 150) {
                bias += 3;
            } else if (v > 50) {
                bias += 1;
            }
        }

        
        final Mode[] options = Mode.values();
        return options[bias % options.length];
    }

    public void assignCourier(Parcel p) {
        this.push(
            new Courier(
                p, new Delivery(this.calculatePriority(p), Status.PICKUP))
        );
    }
}
