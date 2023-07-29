
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Signup() {
        setTitle("Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setLocationRelativeTo(null);
       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
    

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        
        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(this);
        panel.add(signupButton);

        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/page", "root", "subashini");

            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            statement.close();
            connection.close();

            JOptionPane.showMessageDialog(null, "Signup successful!");
            dispose();
            
            // Open the home page window
            SwingUtilities.invokeLater(Homepage::new);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Signup failed!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Signup::new);
    }
}
/* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Signup() {
        setTitle("Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setLocationRelativeTo(null);
       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
    
        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        
        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(this);
        panel.add(signupButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        String url = "jdbc:mysql://localhost:3306/page"; // Replace 'project' with your database name
        String dbUsername = "root"; // Replace 'root' with your MySQL username
        String dbPassword = "subashini"; // Replace 'subashini' with your MySQL password

        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            statement.close();
            connection.close();

            JOptionPane.showMessageDialog(null, "Signup successful!");
            dispose();
            
            // Open the home page window
            SwingUtilities.invokeLater(Homepage::new);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Signup failed!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Signup::new);
    }
}
