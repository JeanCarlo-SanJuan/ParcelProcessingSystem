import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.lang.String;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame {
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("Welcome!");

    private AccountController AC;

    public LoginFrame(AccountController ac) {
        this.AC = ac;
        usernameLabel.setBounds(50, 100, 75, 25);
        passwordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        usernameField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = usernameField.getText();
                String phrase = String.valueOf(passwordField.getPassword());

                if (!AC.login(name, phrase)) {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Incorrect credentials!");
                    return;
                }

                messageLabel.setForeground(Color.blue);
                messageLabel.setText("Sign In Successful!");
                LoginFrame.this.setVisible(false);
                MainFrame mainFrame = new MainFrame();

                mainFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        LoginFrame.this.setVisible(true);
                        resetFields();
                    }
                });
                mainFrame.setVisible(true);
            }
        });

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(messageLabel);
        this.add(usernameField);
        this.add(passwordField);
        this.add(loginButton);
        this.add(resetButton);
        this.setSize(420, 420);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
    }

    public void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
}