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
}
