import javax.swing.*;
import java.awt.*;

public class CourierPanel extends Panel {
    //We need the frame(parent) to be able to directly change the text
    public JLabel previewID = new JLabel("");
    public JLabel previewStatus = new JLabel("");
    public JLabel previewMode = new JLabel("");
    public CourierPanel(Courier courier, String headerText) {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxlayout);
        
        JLabel title = new JLabel(headerText);
        title.setFont(new Font("Tahoma", Font.BOLD,20));
        title.setOpaque(true);
        this.add(title);

        this.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel col1 = new JLabel("Parcel ID");
        this.add(col1); 
        
        previewID.setText(courier.parcel.getID());
        previewID.setOpaque(true);
        this.add(previewID);

        this.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel col2 = new JLabel("Status");
        this.add(col2);
        
        previewStatus.setText("" + courier.checkProgress());
        previewStatus.setOpaque(true);
        this.add(previewStatus);

        this.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel col3 = new JLabel("Mode");
        this.add(col3);

        previewMode.setText("" + courier.delivery.getMode());
        previewMode.setOpaque(true);
        this.add(previewMode);

        JLabel cols[] = {col1,col2,col3};

        for (JLabel col: cols) {
            col.setFont(new Font("Tahoma", Font.BOLD,15));
        }
    }
}
