import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.lang.String;

public class LoginFrame extends JFrame{
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("Welcome!");
    
    AccountController AC;

    public LoginFrame (AccountController ac)
    {

        AC = ac;
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
                
                if (AC.login(name, phrase)) {
                    messageLabel.setForeground(Color.blue);
                    messageLabel.setText("Sign In Successful!");
                    LoginFrame.this.dispose(); //Control is returned to the Main class
                }
                else 
                {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Incorrect credentials!");
                }
            }
        });
        
        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
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
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}