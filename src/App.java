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
        
        String[]ss = {"ACM headquarters", "1601 Broadway, 10th Floor New York, NY 10019-7434", "None", "None"};
        String[]rs = {"938 Aurora Boulevard, Cubao, Quezon City", "363 Pascual Casal St", "1338 Arlegui St., Quiapo Manila", "None"};
        return new Parcel(
            "Notice on accreditation", "Contains information about the accreditation results.",
            500.0, 0.1, 0.0,
            new Dimension3D(22.0, 28.0, 2.0),
            new Addresses(ss), new Addresses(rs),
            false, false, "Mail"
        );
    }

    public static Courier createSampleCourier() {
        return new Courier(createSampleParcel(), new Delivery(Mode.VEHICLE, Status.PICKUP));
    }
}
