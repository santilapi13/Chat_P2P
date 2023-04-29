package controller;

import model.Informacion;
import view.IVista;
import view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Observable;
import controller.ControladorChat;

import model.Usuario;

public class ControladorPrincipal implements ActionListener {

    private IVista vista;
    private static ControladorPrincipal instance;
    Usuario usuario;
    
    private ControladorPrincipal() {
        this.vista = new VentanaPrincipal();
        this.vista.setActionListener(this);
        
        try {
			usuario = Usuario.getInstance();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public static ControladorPrincipal getInstance() {
        if (instance == null) {
            instance = new ControladorPrincipal();
        }
        return instance;
    }

    public IVista getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equalsIgnoreCase("")) {
        	usuario.start();
        }

        if (comando.equalsIgnoreCase("SOLICITAR CHAT")) {
            String ip = vista.getDireccionIP();
            String puerto = vista.getPuertoIP();
            int puertoInt = Integer.parseInt(puerto);

            Informacion informacionReceptor = new Informacion(ip, puertoInt, "");
            try {
                usuario.solicitarChat(informacionReceptor);
                //ControladorChat.getInstance();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

}
