import javax.swing.JFrame;
import java.awt.EventQueue;

public class App {
    private static JFrame currentFrame;
    private static AccountController AC = new AccountController();
    private static CourierController CC = new CourierController();

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					currentFrame = new LoginFrame(AC, CC);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
