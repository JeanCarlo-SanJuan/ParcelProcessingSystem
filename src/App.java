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
		CC.push(new Courier(Parcel.sample()));

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
}
