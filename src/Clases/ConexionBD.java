package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    
    private Connection cx;
    
    private String usr = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost/hotel_alura";
    
    public ConexionBD() {
        
        try {
            
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                
                cx = DriverManager.getConnection(url, usr, pass);
                
                if (cx != null) {
                    
                    System.err.println("Conexión establecida");
                    
                }
                
            } catch (SQLException ex) {
                
                System.err.println("Error de conexión");
            }
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public Connection getConexion() {
        
        return this.cx;
    }
    
    public static void main(String[] args) {
        
        ConexionBD conx = new ConexionBD();
        
    }
    
}
