package es.examen.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class TarjetaDao {
	
	    
	     private Connection cx;
	     private static TarjetaDao tarjetadao=null;
	     
	     private tarjetaDAO(){
	     }
	     public static TarjetaDAO getInstance(){
	    	 if(TarjetaDAO.tarjetaDao==null)
	    		 TarjetaDAO.tarjetaDao= new TarjetaDAO();
	    	 return TarjetaDAO.tarjetaDao;
	     }
	   
	     private void conectar() {
	     try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","root");
	            cx.setAutoCommit(false);
	     }
   catch(SQLException e) {
            
       Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error en SQL ", e);
        }
	     catch(ClassNotFoundException e) {
	         Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No se encuentra lib mySQL ", e);
        }
    
	    
	    
	      
	     }
	     private void desconectar() {
	         try {
	             if(cx!=null)
	                cx.close();
	        } catch (SQLException e) {
	           
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
	        }
	         
	         
	     }

}
