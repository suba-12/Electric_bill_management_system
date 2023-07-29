
import java.sql.*;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton, cancelButton;

    public Login() {
        super("Login Page");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);
        

        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create GUI components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel loginAsLabel = new JLabel("Log in as:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign up");
        cancelButton = new JButton("Cancel");
        usernameLabel.setForeground(Color.ORANGE); // sets the text color to red
        passwordLabel.setForeground(Color.ORANGE);
        loginAsLabel.setForeground(Color.ORANGE);
        loginButton.setForeground(Color.ORANGE);
        signUpButton.setForeground(Color.ORANGE);
        cancelButton.setForeground(Color.ORANGE);
        loginButton.setBackground(Color.BLACK);
        signUpButton.setBackground(Color.BLACK);
        cancelButton.setBackground(Color.black);

        // Add action listeners to buttons
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Add components to the JPanel
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setBackground(Color.BLACK);

        constraints.insets = new Insets(5, 5, 5, 5); // Add some padding

        // Add username label and field
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(usernameField, constraints);

        // Add password label and field
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;

        
        panel.add(passwordField, constraints);

        // Add login as label and radio buttons
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(loginAsLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        JRadioButton adminButton = new JRadioButton("Admin");
        JRadioButton userButton = new JRadioButton("User");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(adminButton);
        buttonGroup.add(userButton);
        panel.add(adminButton, constraints);
        adminButton.setForeground(Color.ORANGE);
        userButton.setForeground(Color.ORANGE);
        adminButton.setBackground(Color.BLACK);
        userButton.setBackground(Color.BLACK);

        constraints.gridx = 2;
        constraints.gridy = 2;
        panel.add(userButton, constraints);

        // Add login, sign up, and cancel buttons
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(loginButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(signUpButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        panel.add(cancelButton, constraints);

        add(panel);

        // Display the login page in full screen
        setVisible(true);
        adminButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean isAdmin = false;
             
           if (validateLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successfilly");
                Homepage homepage = new Homepage();
                homepage.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
            //Homepage homepage = new Homepage();
             //   homepage.setVisible(true);
              //  setVisible(false);
        }
         else if (e.getSource() == signUpButton) {
            JOptionPane.showMessageDialog(this, "Sign up button clicked!");
            Signup signUp = new Signup();
        signUp.setVisible(true);
        setVisible(false);
        } 
        else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }


    private boolean validateLogin(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/page"; // Replace 'mydatabase' with your database name
        String dbUsername = "root"; // Replace 'your-username' with your MySQL username
        String dbPassword = "subashini"; // Replace 'your-password' with your MySQL password
    
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
    
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
    
            ResultSet resultSet = statement.executeQuery();
            boolean isValid = resultSet.next();
    
            resultSet.close();
            statement.close();
            connection.close();
    
            return isValid;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        Login loginPage = new Login();
}

}
