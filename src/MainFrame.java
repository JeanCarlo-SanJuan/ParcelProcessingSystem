import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPane;

    public MainFrame() {
        setTitle("Main Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        mainPane = new JPanel();
        mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPane);
        mainPane.setLayout(null);

        JLabel lblProcessed = new JLabel("Processed Parcels: Sorted by ID");
        lblProcessed.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblProcessed.setBounds(40, 60, 700, 80);
        mainPane.add(lblProcessed);

        JButton btn_add_parcel = new JButton("NEW PARCEL");
        btn_add_parcel.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_add_parcel.setBounds(1000, 120, 200, 80);
        btn_add_parcel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ParcelFrame frame = new ParcelFrame();
                frame.setPreferredSize(new Dimension(720, 720));
                frame.pack();
                frame.setVisible(true);
            }
        });
        mainPane.add(btn_add_parcel);

        JButton btn_logout = new JButton("LOG OUT");
        btn_logout.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_logout.setBounds(1000, 240, 200, 80);
        btn_logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.dispose();
            }
        });
        mainPane.add(btn_logout);

        JButton btn_delivery = new JButton("Delivery Status");
        btn_delivery.setFont(new Font("Tahoma", Font.BOLD, 19));
        btn_delivery.setBounds(1000, 360, 200, 80);
        btn_delivery.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        mainPane.add(btn_delivery);

        JButton btn_info = new JButton("Parcel Info");
        btn_info.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_info.setBounds(1000, 480, 200, 80);
        btn_info.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        mainPane.add(btn_info);
        ArrayList<String> parcel_id = new ArrayList<>();
        parcel_id.add("1234 - 5678 - 9012 - 3456");
        parcel_id.add("7890 - 1234 - 5678 - 9012");
        parcel_id.add("3456 - 7890 - 1234 - 5678");
        ButtonGroup id = new ButtonGroup();
        ParcelButtonsGenerator.createButtonsFromList(parcel_id, id, mainPane, 76, 194, 50, 300, 23);
    }
}