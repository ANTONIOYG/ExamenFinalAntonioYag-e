package es.examen.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import es.examen.modelo.Tarjeta;




public class TarjetaDAO {
	
	    
	     private Connection cx;
	     private static TarjetaDAO tarjetaDao=null;
	     
	     private TarjetaDAO(){
	     }
	     public static TarjetaDAO getInstance(){
	    	 if(TarjetaDAO.tarjetaDao==null)
	    		 TarjetaDAO.tarjetaDao= new TarjetaDAO();
	    	 return TarjetaDAO.tarjetaDao;
	     }
	   
	     private void conectar() {
	     try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANCO","root","root");
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
		public int darAlta(Tarjeta tarjeta) {
			// TODO Auto-generated method stub
			 int id=0;
	            try {
	                
	                //1. conectar
	                conectar();
	              //2.Preparar la sql (query)
	                PreparedStatement ps =cx.prepareStatement("INSERT INTO TARJETACREDITO VALUES(?,?,?,?,?,?,?)"); 
	                  // 2.1 setear los interrogantes...
	                ps.setInt(1, 0);
	                ps.setString(2, tarjeta.getNumero());
	                ps.setInt(3, tarjeta.getCupoMaximo());
	                ps.setInt(4, tarjeta.getCupoDisponible());
	                ps.setString(5, tarjeta.getTipo());
	                ps.setString(6, tarjeta.getNumeroComprobacion());
	                ps.setString(7, tarjeta.getContrasehna());
	                
	                //3. Ejecutar la consulta
	                 int filasAfectadas =ps.executeUpdate();
	               
	                   //4.  hacer el commit....
	                 cx.commit();
	                 if(filasAfectadas>=1) {
	                     id= ultimoId();    
	               }
	               
	            } catch (SQLException e) {
	                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	            }
	            finally {
	                //.5.cerrar la conexión
                 desconectar();
	              }
	         return id;
		}
		private int ultimoId() {
			// TODO Auto-generated method stub
			int  idM=90;
	    	try {
	    		//1. conectar
	    		conectar();
	    		//2. preparar la sentencia
	    		PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM TARJETACREDITO");
	    		//3. ejecutar la consulta
	    		ResultSet consulta = ps.executeQuery();
	    		//4. bajar el resultado de la consulta y ponerlo en el arrayList
	    		if(consulta.next()) {
	    			idM=consulta.getInt("ULTIMO");
	    		}
	    		
	    	} catch (SQLException e) {
	    		    		
	    		 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Calculo ultimo id", e);
	    		
	    		
	    	
	    	}
	    	finally {
                //5.desconectar
                  desconectar();
            }
	    	return idM;
		}
		/*public ArrayList<Tarjeta> consultarTarjeta(String numero) {
			// TODO Auto-generated method stub
			ArrayList<Tarjeta> tarjetas= new ArrayList<Tarjeta>();
	    	try {
	    		//1. conectar
	    		conectar();
	    		//2. preparar la sentencia
	    		PreparedStatement ps = cx.prepareStatement("SELECT * FROM TARJETACREDITO WHERE NUMERO LIKE ?");
	    		// 2.1 setear el interrogante
	    		ps.setString(1, "%"+numero+"%");
	    		//3. ejecutar la consulta
	    		ResultSet consulta = ps.executeQuery();
	    		//4. bajar el resultado de la consulta y ponerlo en el arrayList
	    		while(consulta.next()) {
	    			Tarjeta p = new Tarjeta();
	    			p.setId(consulta.getInt("id"));
	    			p.setNumero(consulta.getString("numero"));
	    			p.setCupoMaximo(consulta.getInt("cupoMaximo"));
	    			p.setCupoDisponible(consulta.getInt("cupoDisponible"));
	    			p.setTipo(consulta.getString("tipo"));
	    			p.setNumeroComprobacion(consulta.getString("numeroComprobacion"));
	    			p.setContrasehna(consulta.getString("contrasehna"));
	    			tarjetas.add(p);
	    		}
	    		
	    	} catch (SQLException e) {
	    		
	    	    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Calculo ultimo id", e);
	    	}
	    	finally {
                //5.desconectar
                  desconectar();
            }
	    	return tarjetas;
		}*/

}
