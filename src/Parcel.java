import java.util.UUID;

public class Parcel {
    public Dimension3D dimension;
    public Addresses sender, receiver;
    public String parcelId = UUID.randomUUID().toString();

    public String 
        name,
        type,
        description;
    public boolean
        isPerishable,
        isTaxable;
    public double
        price,
        weight,
        tax_factor;
    
    public Parcel() {
        //Do nothing
    }

    public Parcel(String name, String desc, double price, double weight, double tax_factor, Dimension3D dimension3d, Addresses sender, Addresses receiver) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.weight = weight;
        this.tax_factor = tax_factor;
        this.dimension = dimension3d;
        this.sender = sender;
        this.receiver = receiver;
    }

    static Parcel sample() {
        String[]ss = {"Line 1", "Line 2", "Line 3", "Line 4"};
        String[]rs = {"Line 01", "Line 02", "Line 03", "Line 04"};
        return new Parcel(
            "Sample", "a sample parcel", 
            100.0, 15.0, 0.0, 
            new Dimension3D(10, 10, 10),
            new Addresses(ss), new Addresses(rs)
        );
    }
}
