import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Newcustomer extends JFrame implements ActionListener{

    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
    JButton next;
    JTextField lblmeter;
    Newcustomer() {
        setSize(700, 500);
        setLocation(400, 100);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.black);
        add(p);
       UIManager.put("Label.foreground", Color.orange);
      UIManager.put("Label.font", new Font("Serif", Font.BOLD, 14));
        
        JLabel heading = new JLabel("New Customer");
        heading.setForeground(Color.orange);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
        heading.setBounds(150, 10, 400, 25);
        p.add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setForeground(Color.orange);
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(240, 80, 200, 20);
        p.add(tfname);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setForeground(Color.orange);
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        lblmeter = new JTextField();
        lblmeter.setBounds(240, 120, 200, 20);
        p.add(lblmeter);
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setForeground(Color.orange);
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(240, 160, 200, 20);
        p.add(tfaddress);
        
        JLabel lblcity = new JLabel("City");
        lblname.setForeground(Color.orange);
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(240, 200, 200, 20);
        p.add(tfcity);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100, 240, 100, 20);
        lblname.setForeground(Color.orange);
        p.add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(240, 240, 200, 20);
        p.add(tfstate);
        
        JLabel lblemail = new JLabel("Email");
        lblname.setForeground(Color.orange);
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(240, 280, 200, 20);
        p.add(tfemail);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblname.setForeground(Color.orange);
        lblphone.setBounds(100, 320, 100, 20);
        p.add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(240, 320, 200, 20);
        p.add(tfphone);
        
        next = new JButton("Submit");
        next.setBounds(250, 390, 100,25);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        p.add(next);
        
        setLayout(new BorderLayout());
        
        add(p, "Center");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("new-cust.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"East");
        
        
        
        getContentPane().setBackground(Color.BLACK);
        
        setVisible(true);
    }
    
   /*  public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";
            
            try {
                Conn c = new Conn();
                
                
                JOptionPane.showMessageDialog(null, "Successful");
                setVisible(false);
            } catch (Exception e) {
            }
        } 
    }/* */
    
    // ...

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        // Retrieve customer data
        String name = tfname.getText();
        String meter = lblmeter.getText();
        String address = tfaddress.getText();
        String city = tfcity.getText();
        String state = tfstate.getText();
        String email = tfemail.getText();
        String phone = tfphone.getText();

        // Execute insert queries
        String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
        //String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";

        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/suba", "root", "subashini");
            Statement stmt = conn.createStatement();

            // Execute insert queries
            stmt.executeUpdate(query1);
            //stmt.executeUpdate(query2);

            // Close database connection
            stmt.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data stored successfully");
            setVisible(false);

            new Homepage();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error storing data");
        }
    }
}

// 

    public static void main(String[] args) {
        new Newcustomer();
    }
}
