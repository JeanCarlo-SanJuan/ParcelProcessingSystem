import javax.swing.JFrame;
import java.awt.EventQueue;

public class App {
    private static JFrame currentFrame;
    private static AccountController AC = new AccountController();

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    currentFrame = new LoginFrame(AC);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}