import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CourierPanel extends Panel {
    public CourierPanel(Courier courier) {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxlayout);
        GridBagConstraints gc = new GridBagConstraints();
        
        JLabel title = new JLabel("Preview");
        title.setFont(new Font("Tahoma", Font.BOLD,20));
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);

        JLabel col1 = new JLabel("Parcel ID");
        col1.setFont(new Font("Tahoma", Font.BOLD,15));
        col1.setBackground(Color.LIGHT_GRAY);
        col1.setOpaque(true);
        col1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(col1);
        
        JLabel info1 = new JLabel(courier.parcel.parcelId);
        info1.setOpaque(true);
        info1.setHorizontalAlignment(SwingConstants.CENTER);
        info1.setVerticalAlignment(SwingConstants.NORTH);
        this.add(info1);

        JLabel col2 = new JLabel("Status");
        col2.setFont(new Font("Tahomar", Font.BOLD,15));
        col2.setBackground(Color.LIGHT_GRAY);
        col2.setOpaque(true);
        col2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(col2);
        
        JLabel info2 = new JLabel("" + courier.checkProgress());
        info2.setOpaque(true);
        info2.setHorizontalAlignment(SwingConstants.CENTER);
        info2.setVerticalAlignment(SwingConstants.NORTH);
        this.add(info2);

        JLabel col3 = new JLabel("Mode");
        col3.setBackground(Color.LIGHT_GRAY);
        col3.setFont(new Font("Tahoma", Font.BOLD,15));
        col3.setOpaque(true);
        col3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(col3);

        JLabel info3 = new JLabel("" + courier.delivery.getMode());
        info3.setOpaque(true);
        info3.setHorizontalAlignment(SwingConstants.CENTER);
        info3.setVerticalAlignment(SwingConstants.NORTH);
        this.add(info3);
        
        //TODO: paint image

        this.setMinimumSize(new Dimension(800,600));
    }
}