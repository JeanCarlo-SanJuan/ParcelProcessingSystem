public class Parcel {
    public final Dimension3D dimension;
    public final ContactData sender, receiver;

    public final String 
        name,
        description;

    public final double
        price,
        weight,
        tax_factor;

    public Parcel(String name, String desc, double price, double weight, double tax_factor) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.weight = weight;
        this.tax_factor = tax_factor;
    }
}