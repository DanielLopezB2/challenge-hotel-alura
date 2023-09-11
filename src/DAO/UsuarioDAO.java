package DAO;

import Clases.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
    
    Connection cn;
    ConexionBD cxn = new ConexionBD();
    
    //Clase que prepara la sentencia sql para ser interpretada por JAVA
    PreparedStatement st;
    
    public boolean validaUsuario(String username, String password) {
        
        String sql = "SELECT 1 FROM usuarios WHERE Username='"+username+"'AND Password='"+password+"'";
        
        try {
            
            st = cxn.getConexion().prepareStatement(sql);
            
            //ResultSet: Permite ejecutar las sentencias SQL preparadas
            ResultSet rs = st.executeQuery();
                    
            //Recorre la tabla
            if (rs.next()) {
                
                return true;
                
            } else {
                
                return false;
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        }
        
    }
    
}
