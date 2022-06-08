import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
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

		txt_a = new JTextField();
		txt_a.setText("");
		txt_a.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_a.setBounds(100, 180, 400, 50);
		txt_a.setColumns(10);
		mainPane.add(txt_a);

		txt_b = new JTextField();
		txt_b.setText("");
		txt_b.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_b.setBounds(100, 300, 400, 50);
		txt_b.setColumns(10);
		mainPane.add(txt_b);

		JButton btn_a = new JButton("NEW PARCEL");
		btn_a.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_a.setBounds(1000, 120, 200, 100);
		mainPane.add(btn_a);

		JButton btn_logout = new JButton("LOG OUT");
		btn_logout.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_logout.setBounds(1000, 300, 200, 100);
		btn_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
			}
		});
		mainPane.add(btn_logout);
	}
}