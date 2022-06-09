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

    public Parcel(String name, String desc, double price, double weight, double tax_factor, Dimension3D dimension3d, ContactData sender, ContactData receiver) {
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
        return Parcel(
            "Sample", "a sample parcel", 100.0, 15.0, 0, new Dimension3D(10, 10, 10),
            new ContactData(),
        )
    }
}