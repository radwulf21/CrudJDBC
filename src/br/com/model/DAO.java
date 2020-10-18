package br.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public void openConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/crud_jdbc";
            String user = "root";
            String password = "";
            
            conn = (Connection)
            DriverManager.getConnection(url, user, password);
            System.out.println("Successful connection.");
        
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Class not found, add the driver to the libraries.");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (SQLException e) {
            
            System.out.println(e);
            throw new RuntimeException(e);
        
        }
    }
    
    public void closeQuery() throws SQLException {
        if (ps != null) {
            ps.close();
            System.out.println("Query closed.");
        }
    }
}
