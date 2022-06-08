import javax.swing.JFrame;
import java.awt.EventQueue;

public class App {
    private static JFrame currentFrame;

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    currentFrame = new LoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}