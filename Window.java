import javax.swing.*;

public class Window extends JFrame {
    public static int
        w = 1280,
        h = 720;

    Window() {
        /* for (JButton btn:btns) {
            add(btn);
        } */

    }

    public void paint() {
        setSize(w,h);
        setLayout(null);
        setVisible(true);
    }
}