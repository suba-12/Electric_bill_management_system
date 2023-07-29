/*import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        //create DB connection
        Connection connect= null;// to establish 
        
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver"); // to mention jar file import
            //to define connection
            connect =DriverManager.getConnection("jdbc:mysql://localhost:3306/ele", "root", "subashini"); 
        } catch (Exception e) {
        e.printStackTrace();
        }
        //to execute query
        try{
            //to create statement to execute
            Statement stmt = connect.createStatement();
            String sql = "CREATE DATABASE ELECTRIC";
            stmt.executeQuery(sql);
            
            System.out.println("database created");

            String sql = "CREATE TABLE ele tablename (name varachar(20), pass int)";
            stmt.executeUpdate(sql);

            System.out.println("Table created successfully.");

            // Insert values into the table
            sql = "INSERT INTO ele values('alice', 123)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO ele values('alice', 123)";
            stmt.executeUpdate(sql);
            System.out.println("Values inserted successfully.");



            // ResultSet rs=null; //to store output
            // rs = stmt.executeQuery("select * from elelog"); //input your own  query
            // while(rs.next()){ 
            //     System.out.print(rs.getInt(1));
            //     System.out.println(" " + rs.getString(2));
            // }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
} 
/* */
/*import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Create DB connection
        Connection connect = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Specify the JDBC driver
            // Define connection
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "subashini");
            System.out.println("DB Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        try {
            // Create a statement
            Statement stmt = connect.createStatement();
            String sql;

            // Use the database
            //sql = "USE ELECTRIC";
            //stmt.executeUpdate(sql);

            // Create the table
            sql = "CREATE TABLE ele (name VARCHAR(20), pass INT)";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

            // Insert values into the table
            sql = "INSERT INTO ele VALUES('alice', 123)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO ele VALUES('bob', 456)";
            stmt.executeUpdate(sql);
            System.out.println("Values inserted successfully");

            // Retrieve data from the table
            ResultSet rs = stmt.executeQuery("SELECT * FROM ele");
            while (rs.next()) {
                String name = rs.getString("name");
                int pass = rs.getInt("pass");
                System.out.println("Name: " + name + ", Password: " + pass);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connect != null) {
                connect.close();
            }
        }*/
    
/* */
