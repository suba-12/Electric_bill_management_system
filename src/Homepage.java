import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame {

    /**
     * 
     */
    Homepage() {
        setTitle("My Homepage");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(500, 400);
        setLocationRelativeTo(null); // center the frame on the screen

        // Create a content pane and set a background image
        JPanel contentPane = new JPanel(new BorderLayout()) {
            ImageIcon bgImage = new ImageIcon("D:\\java_program\\java\\Project\\src\\online.jpg");

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        setContentPane(contentPane);
        setLayout(new BorderLayout());

        // Create a menu bar and add menus to it
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18)); // set font size to 20
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Login log = new Login();
        log.setVisible(true);
    }
});
buttonPanel.add(loginButton);

JButton newCustomerButton = new JButton("New Customer");
newCustomerButton.setFont(new Font("Arial", Font.PLAIN, 18)); // set font size to 20
newCustomerButton.setForeground(Color.black);
newCustomerButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Newcustomer cust = new Newcustomer();
        cust.setVisible(true);
    }
});
buttonPanel.add(newCustomerButton);


JButton calculateBillButton = new JButton("Calculate Bill");
calculateBillButton.setFont(new Font("Arial", Font.PLAIN, 18)); // set font size to 20
calculateBillButton.setForeground(Color.BLACK);
calculateBillButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Bill bill = new Bill();
        bill.setVisible(true);
    }
});
buttonPanel.add(calculateBillButton);


contentPane.add(buttonPanel, BorderLayout.NORTH);
        
        // Create a label and add it to the content pane
         // Add other components on top of the background
       
        setVisible(true);
    }






    

    public static void main(String[] args) {
        new Homepage();
    }
}
