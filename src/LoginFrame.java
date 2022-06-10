import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame implements ActionListener 
{
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel usernameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel messageLabel = new JLabel("Welcome!");
    int attempt = 0;

    private AccountController AC;
    private CourierController CC;

    public LoginFrame(AccountController ac, CourierController cc) 
    {
    /**
     * The reason for why the Login Frame and its components are fixed and can't be dynamically resized
     * is because of simplicity and not really necessary for the login frame, as the contents features of the login frame 
     * aren't that many to justify a minimum and maximum size.
     */
        setResizable(false);
        this.AC = ac;
        this.CC = cc;

        // Configure component children
        usernameLabel.setBounds(50, 100, 75, 25);
        passwordLabel.setBounds(50, 150, 75, 25);
        
        messageLabel.setBounds(75, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setActionCommand("login");
        this.getRootPane().setDefaultButton(loginButton); // Allows the enter key to attempt a login.

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setActionCommand("reset");

        // Add children
        add(usernameLabel);
        add(passwordLabel);
        add(messageLabel);
        add(usernameField);
        add(passwordField);
        add(loginButton);
        add(resetButton);

        // Configure self
        setSize(420, 420);
        setLayout(null);
        setTitle("Login");
    }

    private void resetFields() 
    {
        usernameField.setText("");
        passwordField.setText("");
    }

    private void onLoginFail() 
    {
        messageLabel.setForeground(Color.red);
        messageLabel.setText("Invalid credentials!");
    }

    private void onLoginSuccess() 
    {
        setVisible(false);

        messageLabel.setForeground(Color.GREEN);
        messageLabel.setText("Sign In Successful!");

        MainFrame mainFrame = new MainFrame(CC);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        mainFrame.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosed(WindowEvent e) 
            {
                setVisible(true);
                resetFields();
                messageLabel.setText("You have signed out!");
                messageLabel.setForeground(Color.BLUE);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand()) 
        {
            case "login":
                if (AC.login(usernameField.getText(), String.valueOf(passwordField.getPassword()))) 
                {
                    onLoginSuccess();
                } else 
                {
                    attempt += 1;
                    onLoginFail();
                }
                break;
            case "reset":
                resetFields();
                break;
            default:
                System.out.println("Unkown action event: " + e.getActionCommand());
        }
        
        if(attempt == 5)
        {
            JOptionPane.showMessageDialog(null, "Too many failed attempts, the system will now shut down.","Login System", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
