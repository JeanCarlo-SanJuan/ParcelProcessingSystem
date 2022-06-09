import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CourierFrame extends JFrame {
    public CourierFrame(Courier courier, BufferedImage image) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.gridx=0;
        gc.gridy=0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1.0;
        gc.gridwidth = 3;
        JLabel title = new JLabel("Parcel Tracker");
        title.setFont(new Font("Tahoma", Font.BOLD,40));
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title, gc);

        gc.gridx=0;
        gc.gridy=1;
        gc.weightx = 1;
        gc.gridwidth = 1;
        JLabel col1 = new JLabel("Parcel ID");
        col1.setFont(new Font("Tahoma", Font.BOLD,20));
        col1.setBackground(Color.LIGHT_GRAY);
        col1.setOpaque(true);
        col1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(col1, gc);
        
        gc.gridx=1;
        gc.gridy=1;   
        gc.weightx = 1;
        gc.gridwidth = 1;
        JLabel col2 = new JLabel("Status");
        col2.setFont(new Font("Tahomar", Font.BOLD,20));
        col2.setBackground(Color.LIGHT_GRAY);
        col2.setOpaque(true);
        col2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(col2, gc);
        
        gc.gridx=2;
        gc.gridy=1;
        gc.weightx = 1;
        gc.gridwidth = 1;        
        JLabel col3 = new JLabel("Mode");
        col3.setBackground(Color.LIGHT_GRAY);
        col3.setFont(new Font("Tahoma", Font.BOLD,20));
        col3.setOpaque(true);
        col3.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(col3, gc);
        
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx=0;
        gc.gridy=2;
        gc.weighty = 1.0;
        gc.gridwidth = 1;        
        JLabel info1 = new JLabel(courier.parcel.parcelId);
        info1.setOpaque(true);
        info1.setHorizontalAlignment(SwingConstants.CENTER);
        info1.setVerticalAlignment(SwingConstants.NORTH);
        panel.add(info1, gc);
        
        gc.gridx=1;
        gc.gridy=2;
        JLabel info2 = new JLabel("" + courier.checkProgress());
        info2.setOpaque(true);
        info2.setHorizontalAlignment(SwingConstants.CENTER);
        info2.setVerticalAlignment(SwingConstants.NORTH);
        panel.add(info2, gc);
        
        gc.gridx=2;
        gc.gridy=2;
        JLabel info3 = new JLabel("" + courier.delivery.mode);
        info3.setOpaque(true);
        info3.setHorizontalAlignment(SwingConstants.CENTER);
        info3.setVerticalAlignment(SwingConstants.NORTH);
        panel.add(info3, gc);
        
        //Todo: paint image

        this.add(panel);
        this.setTitle("Courier");
        this.setMinimumSize(new Dimension(800,600));
    }

    public static void main(String[] args) {
        /* CourierFrame c = new CourierFrame();
        c.setLocationRelativeTo(null);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true); */
    }
}