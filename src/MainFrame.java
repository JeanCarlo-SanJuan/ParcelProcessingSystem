import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
	private JPanel mainPane;
	private JTextField txt_a;
	private JTextField txt_b;

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

		JLabel lbl_a = new JLabel("1. Place holder text");
		lbl_a.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_a.setBounds(40, 180, 460, 50);
		mainPane.add(lbl_a);

		JLabel lbl_b = new JLabel("2. Place holder text");
		lbl_b.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_b.setBounds(40, 300, 460, 50);
		mainPane.add(lbl_b);

		JButton btn_add_parcel = new JButton("NEW PARCEL");
		btn_add_parcel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_add_parcel.setBounds(1000, 120, 200, 100);
		btn_add_parcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ParcelFrame frame = new ParcelFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setPreferredSize(new Dimension(720, 720));
				frame.pack();
				frame.setVisible(true);
			}
		});
		mainPane.add(btn_add_parcel);

		JButton btn_logout = new JButton("LOG OUT");
		btn_logout.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_logout.setBounds(1000, 260, 200, 80);
		btn_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
			}
		});
		mainPane.add(btn_logout);
		
		JButton btn_delivery = new JButton("Delivery Request");
		btn_delivery.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_delivery.setBounds(1000, 380, 200, 80);
		mainPane.add(btn_delivery);

		JButton btn_info = new JButton("Parcel Info");
		btn_info.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_info.setBounds(1000, 500, 200, 80);
		mainPane.add(btn_info);
	}
}