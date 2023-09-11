package DAO;

import Clases.ConexionBD;
import Clases.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReservaDAO {
    
    Connection cn;
    ConexionBD cxn = new ConexionBD();
    
    //Clase que prepara la sentencia sql para ser interpretada por JAVA
    PreparedStatement st;
    
    public boolean nuevaReserva(Reserva miReserva) {
        
        String sql = "INSERT INTO reservas(Id,FechaEntrada, FechaSalida," 
                +  "Valor, FormaPago)" 
                + "VALUES(?,?,?,?,?)";
        
        
        try {
            
            //Se prepara la conexion
            cn = cxn.getConexion();
            
            //Se prepara la sentencia sql
            st = cn.prepareStatement(sql);
            
            st.setInt(1, miReserva.getId());
            st.setString(2, miReserva.getFechaEntrada());
            st.setString(3, miReserva.getFechaSalida());
            st.setFloat(4, miReserva.getValor());
            st.setString(5, miReserva.getFormaPago());
            
            
            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        return true;
        
    }
    
    public ArrayList<Reserva> listarReservas() {
        
        var reservas = new ArrayList<Reserva>();
        
        String sql = "SELECT * FROM reservas";
        
        try {
            st = cxn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
                Integer id = rs.getInt("Id");
                Date fechaEntrada = rs.getDate("FechaEntrada");
                Date fechaSalida = rs.getDate("FechaSalida");
                Float valor = rs.getFloat("Valor");
                String formaPago = rs.getString("FormaPago");
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaEntradaStr = dateFormat.format(fechaEntrada);
                String fechaSalidaStr = dateFormat.format(fechaSalida);
                      
                Reserva reserva = new Reserva(id, fechaEntradaStr, fechaSalidaStr, valor, formaPago);
                reservas.add(reserva);
            }
        } catch (Exception e) {
        }
        
        return reservas;
    }
    
     public Reserva consultaReserva(String numeroReserva) {
        
        //Consultar Usuario
            String sql = "SELECT * FROM reservas WHERE Id LIKE ?";
            String reservaBuscada = "%" + numeroReserva + "%";
        
        try {
            
            //Se prepara la sentencia sql
            st = cxn.getConexion().prepareStatement(sql);
            st.setString(1, reservaBuscada);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                
                
                //creamos el objeto con los datos de la BD
                Reserva miReserva= new Reserva(rs.getInt("Id"),
                        rs.getString("FechaEntrada"),
                        rs.getString("FechaSalida"),
                        rs.getFloat("Valor"),
                        rs.getString("FormaPago")
                        );
                //Devolvemos el objeto con los datos de la BD
                        return miReserva;
                        
            } else {
                
                return null;
                
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return null;
        
    }
     
     public Reserva consultaReservaId(int idReserva) {
        
        //Consultar Usuario
            String sql = "SELECT * FROM reservas WHERE Id='"+idReserva+"'";
        
        try {
            
            //Se prepara la sentencia sql
            st = cxn.getConexion().prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                
                
                //creamos el objeto con los datos de la BD
                Reserva miReserva= new Reserva(rs.getInt("Id"),
                        rs.getString("FechaEntrada"),
                        rs.getString("FechaSalida"),
                        rs.getFloat("Valor"),
                        rs.getString("FormaPago")
                        );
                //Devolvemos el objeto con los datos de la BD
                        return miReserva;
                        
            } else {
                
                return null;
                
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return null;
        
    }
     
     public boolean editarReserva(Reserva miReserva){
        
        String sql = "UPDATE reservas SET FechaEntrada=?, FechaSalida=?, Valor=?, FormaPago=?"
            + "WHERE Id=?";
        
        try {
            
            //Se prepara la conexion
            cn = cxn.getConexion();
            
            //Se prepara la sentencia sql
            st = cn.prepareStatement(sql);
            
            st.setString(1, miReserva.getFechaEntrada());
            st.setString(2, miReserva.getFechaSalida());
            st.setFloat(3, miReserva.getValor());
            st.setString(4, miReserva.getFormaPago());
            st.setInt(5, miReserva.getId());

            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        return true;
        
    }
     
     public boolean eliminarReserva(int numeroReserva){
        
        String sql = "DELETE FROM reservas WHERE Id='"+numeroReserva+"'";
        
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
