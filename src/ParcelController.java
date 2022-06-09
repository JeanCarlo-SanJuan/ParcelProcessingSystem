import java.util.ArrayList;

public class ParcelController {
    private ArrayList<Parcel> currentParcels = new ArrayList<Parcel>();

    public void push(Parcel parcel) {
        this.currentParcels.add(parcel);
    }

    public ArrayList<Parcel> getParcels() {
        // this makes sure that we can't mutate the inner list.
        return new ArrayList<Parcel>(currentParcels);
    }
}
