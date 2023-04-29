package Pruebas;

import java.net.UnknownHostException;

import controller.ControladorPrincipal;
import model.Usuario;

public class Prueba1 {

	
	
	public static void main(String[] args) throws UnknownHostException {
		
		Usuario.getInstance();
		System.out.println("Mi puerto es: " + Usuario.getInstance().getPuerto());
		ControladorPrincipal principal = ControladorPrincipal.getInstance();

	}

}
