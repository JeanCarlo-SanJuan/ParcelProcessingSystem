import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.lang.String;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame implements ActionListener {
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel usernameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel messageLabel = new JLabel("Welcome!");

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
        loginButton.addActionListener(this);
        loginButton.setActionCommand("login");

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setActionCommand("reset");
        add(usernameLabel);
        add(passwordLabel);
        add(messageLabel);
        add(usernameField);
        add(passwordField);
        add(loginButton);
        add(resetButton);
        setSize(420, 420);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    private void onLoginFail() {
        messageLabel.setForeground(Color.red);
        messageLabel.setText("Incorrect credentials!");
    }

    private void onLoginSuccess() {
        messageLabel.setForeground(Color.GREEN);
        messageLabel.setText("Sign In Successful!");

        setVisible(false);
        MainFrame mainFrame = new MainFrame();

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setVisible(true);
                clearFields();
                messageLabel.setText("You have signed out!");
                messageLabel.setForeground(Color.BLUE);
            }
        });
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "login":
                if (AC.login(
                    usernameField.getText(), 
                    String.valueOf(passwordField.getPassword()))
                ) {
                    onLoginSuccess();
                } else {
                    onLoginFail();
                }
            break;
            case "reset":
                clearFields();
            break;
            default:
                System.out.println("Unkown action event: " + e.getActionCommand());
        }
    }
}