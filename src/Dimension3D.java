/**
 * An immutable class for a dimension similar to the one provided by java.awt but includes a 3D dimension
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
}