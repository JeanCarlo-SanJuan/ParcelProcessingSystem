import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    private static AccountController ac = new AccountController();
    private static States state = States.login;
    private static JFrame currentFrame;

    // Global variable because the name field will be used later
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    update();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

    static void setState(States s) {
        state = s;
    }

    static void update() {
        if (currentFrame != null)
            currentFrame.dispose();

        switch (state) {
            case login:
                currentFrame = new LoginFrame(ac);
                break;
            case main:
                currentFrame = new MainFrame();
                break;
            case input:
                break;
            case courier:

                break;
        }

        if (currentFrame == null)
            return;

        currentFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // your code
                nextState(state);
            }
        });
        currentFrame.setVisible(true);
    }

    static void nextState(States s) {
        switch(s) {
            case login:
                if (ac.getUser() != "") {
                    setState(States.main);
                }
                break;
            case main:
                break;
            case input:
                break;
            case courier:

            break;
        }

        update();
    }
}

enum States {
    login,
    main,
    input,
    courier
}