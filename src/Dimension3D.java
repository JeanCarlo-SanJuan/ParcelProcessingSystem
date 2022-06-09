/**
 * An immutable class for a dimension similar to the one provided by java.awt but includes a third dimension
 */
public class Dimension3D {
    public final double length;
    public final double width;
    public final double height;

    public Dimension3D(double l, double w, double h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    public String toString() {
        return "Dimensions(" + this.length + ", " + this.width + ", " + this.height + ")";
    }
}