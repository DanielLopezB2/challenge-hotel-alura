package DAO;

import Clases.ConexionBD;
import Clases.Huesped;
import Clases.Reserva;
import java.awt.List;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HuespedDAO {
    
    Connection cn;
    ConexionBD cxn = new ConexionBD();
    
    //Clase que prepara la sentencia sql para ser interpretada por JAVA
    PreparedStatement st;
    
    public boolean nuevohuesped(Huesped miHuesped) {
        
        String sql = "INSERT INTO huespedes(Nombre, Apellido," 
                +  "FechaNacimiento, Nacionalidad, Telefono, IdReserva)" 
                + "VALUES(?,?,?,?,?,?)";
        
        
        try {
            
            //Se prepara la conexion
            cn = cxn.getConexion();
            
            //Se prepara la sentencia sql
            st = cn.prepareStatement(sql);
            
            BigInteger telefonoBigInteger = miHuesped.getTelefono();
            BigDecimal telefonoBigDecimal = new BigDecimal(telefonoBigInteger);
            
            st.setString(1, miHuesped.getNombre());
            st.setString(2, miHuesped.getApellido());
            st.setString(3, miHuesped.getFechaNacimiento());
            st.setString(4, miHuesped.getNacionalidad());
            st.setBigDecimal(5, telefonoBigDecimal);
            st.setInt(6, miHuesped.getIdReserva());

            
            
            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(HuespedDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        return true;
        
    }    
    
    public ArrayList<Huesped> listarHuespedes() {
        
        var huespedes = new ArrayList<Huesped>();
        
        String sql = "SELECT * FROM huespedes";
        
        try {
            st = cxn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                Date fechaNacimiento = rs.getDate("FechaNacimiento");
                String nacionalidad = rs.getString("Nacionalidad");
                int idReserva = rs.getInt("IdReserva");
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaNacimientoStr = dateFormat.format(fechaNacimiento);
                
                String telefonoStr = rs.getString("Telefono");
                BigInteger telefonoBigInt = new BigInteger(telefonoStr);
                
                Huesped huesped = new Huesped(nombre, apellido, fechaNacimientoStr, nacionalidad, telefonoBigInt, idReserva);
                huespedes.add(huesped);
            }
        } catch (Exception e) {
        }
        
        return huespedes;
    }

    
    public Huesped consultaHuesped(String nombreHuesped) {
        
        //Consultar Usuario
            String sql = "SELECT * FROM huespedes WHERE nombre LIKE ?";
            String nombreBuscado = "%" + nombreHuesped + "%";
        
        try {
            
            //Se prepara la sentencia sql
            st = cxn.getConexion().prepareStatement(sql);
            st.setString(1, nombreBuscado);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                
                
                //creamos el objeto con los datos de la BD
                Huesped miHuesped= new Huesped(rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Nacionalidad"),
                        rs.getBigDecimal("Telefono").toBigInteger(),
                        rs.getInt("IdReserva")
                        );
                //Devolvemos el objeto con los datos de la BD
                        return miHuesped;
                        
            } else {
                
                return null;
                
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(HuespedDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return null;
        
    }
    
    public Huesped consultaHuespedId(int numeroReserva) {
        
        //Consultar Usuario
            String sql = "SELECT * FROM huespedes WHERE IdReserva='"+numeroReserva+"'";
        
        try {
            
            //Se prepara la sentencia sql
            st = cxn.getConexion().prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                
                
                //creamos el objeto con los datos de la BD
                Huesped miHuesped= new Huesped(rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Nacionalidad"),
                        rs.getBigDecimal("Telefono").toBigInteger(),
                        rs.getInt("IdReserva")
                        );
                //Devolvemos el objeto con los datos de la BD
                        return miHuesped;
                        
            } else {
                
                return null;
                
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(HuespedDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return null;
        
    }
    
    public boolean editarHuesped(Huesped miHuesped){
        
        String sql = "UPDATE huespedes SET Nombre=?, Apellido=?, FechaNacimiento=?, Nacionalidad=?, Telefono=? "
            + "WHERE IdReserva=?";
        
        try {
            
            //Se prepara la conexion
            cn = cxn.getConexion();
            
            //Se prepara la sentencia sql
            st = cn.prepareStatement(sql);

            BigInteger telefonoBigInteger = miHuesped.getTelefono();
            BigDecimal telefonoBigDecimal = new BigDecimal(telefonoBigInteger);
            
            st.setString(1, miHuesped.getNombre());
            st.setString(2, miHuesped.getApellido());
            st.setString(3, miHuesped.getFechaNacimiento());
            st.setString(4, miHuesped.getNacionalidad());
            st.setBigDecimal(5, telefonoBigDecimal);
            st.setInt(6, miHuesped.getIdReserva());
            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(HuespedDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        return true;
        
    }
    
    public boolean eliminarHuesped(int numeroReserva){
        
        String sql = "DELETE FROM huespedes WHERE IdReserva='"+numeroReserva+"'";
        
        try {
            
            //Se prepara la conexion
            cn = cxn.getConexion();
            
            //Se prepara la sentencia sql
            st = cn.prepareStatement(sql);
            
            int estado = st.executeUpdate();

            
            if (estado > 0) {
                
                return true;
                
            }
            
            else {
                
                return false;
                
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(HuespedDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
    }
}
