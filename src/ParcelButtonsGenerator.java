import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ParcelButtonsGenerator {
    static void createButtonsFromList(
        ArrayList<String> parcels, 
        ButtonGroup bG, 
        JPanel jP, 
        int x, 
        int startY, 
        int stepY, 
        int w, 
        int h
    ) {
        for (int i = 0; i < parcels.size(); i++) {
            JRadioButton rd = new JRadioButton("" + (i+1) + ". " + parcels.get(i));
            rd.setFont(new Font("Tahoma", Font.PLAIN, 20));
            rd.setActionCommand("" + i); // Use this to get the actual id
            rd.setBounds(x, i * stepY + startY, w, h);
            bG.add(rd);
            jP.add(rd);
        }
    }
}