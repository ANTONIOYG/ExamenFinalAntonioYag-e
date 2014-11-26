package es.examen.modelo;

import java.util.ArrayList;


import es.examen.integracion.TarjetaDAO;


public class negociot {
private TarjetaDAO tarjetadao = TarjetaDAO.getInstance();
	
	public int DarAlta(int numero, int cupoMaximo, int cupoDisponible, String tipo,
			int numeroComprobacion, int contrasehna){
		 Tarjeta tarjeta= new Tarjeta(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasehna);
	        int id =tarjetadao.darAlta(tarjeta);
	      return  id;
	}
	 public ArrayList<Tarjeta> consultarTarjeta(int numero) {
	        ArrayList<Tarjeta> tarjetas=tarjetadao.consultarTarjeta(numero);
	        return tarjetas;
	    }

}
