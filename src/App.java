import javax.swing.JFrame;
import java.awt.EventQueue;

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
