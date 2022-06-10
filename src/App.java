import javax.swing.JFrame;
import java.awt.EventQueue;


/**
 * @summary The entry point GUI.
 * @author Antonio Gabriel Abelardo
 * @author Sons Justin Garcia
 * @author Jean Carlo M. San Juan.
 */
public class App {
    private static JFrame currentFrame;
    private static AccountController AC = new AccountController();
    private static CourierController CC = new CourierController();

    public static void main(String[] args) {
        CC.push(createSampleCourier());
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        currentFrame = new LoginFrame(AC, CC);
                        currentFrame.setVisible(true);
                        currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public static Parcel createSampleParcel() {
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

    public static Courier createSampleCourier() {
        return new Courier(createSampleParcel(), new Delivery(Mode.AIRPLANE, Status.PICKUP));
    }
}
