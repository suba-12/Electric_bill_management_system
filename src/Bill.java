import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Bill extends JFrame implements ActionListener{

    JTextField tfunits;
    JButton next;
    JLabel lblname, labeladdress;
    JLabel lblbillamount;
    Choice meternumber, cmonth;
    Bill() {
        setSize(600, 500);
        
        setLocationRelativeTo(null);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.black);
        add(p);
        UIManager.put("Label.foreground", Color.orange);
      UIManager.put("Label.font", new Font("Serif", Font.BOLD, 15));
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
        heading.setBounds(150, 10, 400, 25);
      
        p.add(heading);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100, 80, 100, 20);
        p.add(lblmeternumber);
       
        
         
        JTextField meternumber = new JTextField();
        meternumber.setBounds(240, 80, 200, 20);
        p.add(meternumber);
        
        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        JTextField lblname = new JTextField();
        lblname.setBounds(240, 120, 200, 20);
        p.add(lblname);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        JTextField labeladdress = new JTextField();
                labeladdress.setBounds(240, 160, 200, 20);
        p.add(labeladdress);
        
        
        
        
        
        JLabel lblcity = new JLabel("Units used");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);
        
        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);
        
        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);
        
        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);
        
        next = new JButton("Submit");
        next.setBounds(250, 320, 100, 25);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        
        p.add(next);

         lblbillamount = new JLabel();
        lblbillamount.setBounds(200, 400, 300, 20);
        lblbillamount.setForeground(Color.red);
        
                p.add(lblbillamount);

        
        
        
        add(p, BorderLayout.CENTER);
        getContentPane().setBackground(new Color(0X78DEC7));
        
        setVisible(true);
        
    }
  /*   public void actionPerformed(ActionEvent e) {
        double kWhUsed = Double.parseDouble(tfunits.getText());
        
        double billAmount = kWhUsed * 3.4;
        lblbillamount.setText("Your electric bill amount is: $" + billAmount);
    } */
    /*public void actionPerformed(ActionEvent e) {
        double kWhUsed = Double.parseDouble(tfunits.getText());
    
        // Get the meter number entered by the user
        String meterNumber = meternumber.getText();
    
        // Fetch customer data from the database based on the meter number
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/suba", "root", "subashini");
            Statement stmt = conn.createStatement();
    
            // Execute the select query
            String query = "SELECT name, address FROM customer WHERE meter_no = '" + meterNumber + "'";
            ResultSet rs = stmt.executeQuery(query);
    
            // Check if the result set has data
            if (rs.next()) {
                // Retrieve customer name and address from the result set
                String name = rs.getString("name");
                String address = rs.getString("address");
    
                // Display the customer name and address on the billing page
                lblname.setText(name);
                labeladdress.setText(address);
    
                // Calculate and display the bill amount
                double billAmount = kWhUsed * 3.4;
                lblbillamount.setText("Your electric bill amount is: $" + billAmount);
            } else {
                // If no customer data found for the entered meter number, display an error message
                JOptionPane.showMessageDialog(null, "Customer data not found for the meter number: " + meterNumber);
            }
    
            // Close database connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving customer data");
        }
    }

    public void actionPerformed(ActionEvent e) {
        double kWhUsed = Double.parseDouble(tfunits.getText());
    
        // Get the meter number entered by the user
        String meterNumber = meternumber.getText();
    
        // Fetch customer data from the database based on the meter number
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/suba", "root", "subashini");
            Statement stmt = conn.createStatement();
    
            // Execute the select query
            String query = "SELECT name, address FROM customer WHERE meter_no = '" + meterNumber + "'";
            ResultSet rs = stmt.executeQuery(query);
    
            // Check if the result set has data
            if (rs.next()) {
                // Retrieve customer name and address from the result set
                String name = rs.getString("name");
                String address = rs.getString("address");
    
                // Display the customer name and address on the billing page
                lblname.setText(name);
                labeladdress.setText(address);
    
                // Calculate and display the bill amount
                double billAmount = kWhUsed * 3.4;
                lblbillamount.setText("Your electric bill amount is: $" + billAmount);
            } else {
                // If no customer data found for the entered meter number, display an error message
                JOptionPane.showMessageDialog(null, "Customer data not found for the meter number: " + meterNumber);
            }
    
            // Close database connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving customer data");
        }
    }/* */
    public void actionPerformed(ActionEvent e) {
        double kWhUsed = Double.parseDouble(tfunits.getText());
    
        // Get the meter number entered by the user
        String meterNumber = meternumber.getSelectedItem();
    
        // Fetch customer data from the database based on the meter number
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/suba", "root", "subashini");
            Statement stmt = conn.createStatement();
    
            // Execute the select query
            String query = "SELECT name, address FROM customer WHERE meter_no = '" + meterNumber + "'";
            ResultSet rs = stmt.executeQuery(query);
    
            // Check if the result set has data
            if (rs.next()) {
                // Retrieve customer name and address from the result set
                String name = rs.getString("name");
                String address = rs.getString("address");
    
                // Display the customer name and address on the billing page
                lblname.setText(name);
                labeladdress.setText(address);
    
                // Calculate and display the bill amount
                double billAmount = kWhUsed * 3.4;
                lblbillamount.setText("Your electric bill amount is: $" + billAmount);
            } else {
                // If no customer data found for the entered meter number, display an error message
                JOptionPane.showMessageDialog(null, "Customer data not found for the meter number: " + meterNumber);
            }
    
            // Close database connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving customer data");
        }
    }
    
     
    public static void main(String[] args) {
        Bill form = new Bill();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


