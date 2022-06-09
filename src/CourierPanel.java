import javax.swing.*;
import java.awt.*;

public class CourierPanel extends Panel {
    //We need the frame(parent) to be able to directly change the text
    public JLabel previewID = new JLabel("");
    public JLabel previewStatus = new JLabel("");
    public JLabel previewMode = new JLabel("");
    
    public CourierPanel(Courier courier) {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxlayout);
        
        JLabel title = new JLabel("Preview");
        title.setFont(new Font("Tahoma", Font.BOLD,20));
        title.setOpaque(true);
        this.add(title);

        JLabel col1 = new JLabel("Parcel ID");
        col1.setFont(new Font("Tahoma", Font.BOLD,15));
        col1.setBackground(Color.LIGHT_GRAY);
        col1.setOpaque(true);
        this.add(col1); 
        
        previewID.setText(courier.parcel.parcelId);
        previewID.setOpaque(true);
        this.add(previewID);

        JLabel col2 = new JLabel("Status");
        col2.setFont(new Font("Tahomar", Font.BOLD,15));
        col2.setBackground(Color.LIGHT_GRAY);
        col2.setOpaque(true);
        this.add(col2);
        
        previewStatus.setText("" + courier.checkProgress());
        previewStatus.setOpaque(true);
        this.add(previewStatus);

        JLabel col3 = new JLabel("Mode");
        col3.setBackground(Color.LIGHT_GRAY);
        col3.setFont(new Font("Tahoma", Font.BOLD,15));
        col3.setOpaque(true);
        this.add(col3);

        previewMode.setText("" + courier.delivery.getMode());
        previewMode.setOpaque(true);
        this.add(previewMode);
    }
}