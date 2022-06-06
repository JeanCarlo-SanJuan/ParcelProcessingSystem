/**
 * ITE 012 - Java Project
 *
 * @author Ashleigh Nelson L. Milana
 * @version Prototype
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.lang.String;

public class LoginSection implements ActionListener
{
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("Welcome!");
    
    AccountController AC;

    public LoginSection (AccountController ac)
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
        loginButton.addActionListener(this);
        
        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==resetButton)
        {
            usernameField.setText("");
            passwordField.setText("");
        }
        
        if(e.getSource()==loginButton)
        {
            String name = usernameField.getText();
            String phrase = String.valueOf(passwordField.getPassword());
            
            if (LoginSection.this.AC.login(name, phrase)) {
                messageLabel.setForeground(Color.blue);
                messageLabel.setText("Sign In Successful!");
                frame.dispose();
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
            else 
            {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Incorrect credentials!");
            }
        }
    }
}