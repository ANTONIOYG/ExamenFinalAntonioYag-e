package es.examen.modelo;

import java.util.ArrayList;


import es.examen.integracion.TarjetaDAO;


public class Negocio {
private TarjetaDAO tarjetadao = TarjetaDAO.getInstance();
	
	public int DarAlta(String numero, int cupoMaximo, int cupoDisponible, String tipo,
			String numeroComprobacion,String contrasehna){
		 Tarjeta tarjeta= new Tarjeta(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasehna);
	        int id =tarjetadao.darAlta(tarjeta);
	      return  id;
	}
	 /*public ArrayList<Tarjeta> consultarTarjeta(String numero) {
	        ArrayList<Tarjeta> tarjetas=tarjetadao.consultarTarjeta(numero);
	        return tarjetas;
	    }*/
	public Tarjeta consultarUno(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
