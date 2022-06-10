import java.util.UUID;

/**
 * @summary A structure that holds relevant information about a parcel.
 * @author Sons Justin Garcia
 * @author Jean Carlo M. San Juan.
 */
public class Parcel {
    public Dimension3D dimension;
    public Addresses sender, receiver;
    public final String ID = UUID.randomUUID().toString();

    private String 
        name,
        type,
        description;
    private boolean
        isPerishable,
        isTaxable;
    private double
        price,
        weight,
        tax_factor;

    public Parcel() {
        //Do nothing
    }

    public Parcel(String name, String desc, double price, double weight, double tax_factor, Dimension3D dimension3d, Addresses sender, Addresses receiver, boolean isTaxable, boolean isPerishable) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.weight = weight;
        this.tax_factor = tax_factor;
        this.dimension = dimension3d;
        this.sender = sender;
        this.receiver = receiver;
        this.isTaxable = isTaxable;
        this.isPerishable =isPerishable;
    }

    public Dimension3D getDimension() {
        return this.dimension;
    }

    public void setDimension(Dimension3D dimension) {
        this.dimension = dimension;
    }

    public Addresses getSender() {
        return this.sender;
    }

    public void setSender(Addresses sender) {
        this.sender = sender;
    }

    public Addresses getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Addresses receiver) {
        this.receiver = receiver;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsPerishable() {
        return this.isPerishable;
    }

    public boolean getIsPerishable() {
        return this.isPerishable;
    }

    public void setIsPerishable(boolean isPerishable) {
        this.isPerishable = isPerishable;
    }

    public boolean isIsTaxable() {
        return this.isTaxable;
    }

    public boolean getIsTaxable() {
        return this.isTaxable;
    }

    public void setIsTaxable(boolean isTaxable) {
        this.isTaxable = isTaxable;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTax_factor() {
        return this.tax_factor;
    }

    public void setTax_factor(double tax_factor) {
        this.tax_factor = tax_factor;
    }

    static Parcel sample() {
        String[]ss = {"Line 1", "Line 2", "Line 3", "Line 4"};
        String[]rs = {"Line 01", "Line 02", "Line 03", "Line 04"};
        return new Parcel(
            "Sample", "a sample parcel", 
            100.0, 15.0, 0.0, 
            new Dimension3D(10, 10, 10),
            new Addresses(ss), new Addresses(rs), 
            false, false
        );
    }
}
