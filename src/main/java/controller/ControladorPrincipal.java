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

import javax.swing.*;

public class ControladorPrincipal implements ActionListener {

    private IVista vista;
    private static ControladorPrincipal instance;
    
    private ControladorPrincipal() {
        this.vista = new VentanaPrincipal();
        this.vista.setActionListener(this);
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
        try {
            if (comando.equalsIgnoreCase("")) {
                if (!Usuario.getInstance().isEscuchando()) {
                    Usuario.getInstance().setUsername(((VentanaPrincipal) vista).getUsername());
                    Thread hilo = new Thread(Usuario.getInstance());
                    hilo.start();
                } else {
                    Usuario.getInstance().desactivarModoEscucha();
                }
            }
            if (comando.equalsIgnoreCase("SOLICITAR CHAT")) {
                String ip = vista.getDireccionIP();
                String puerto = vista.getPuertoIP();
                Usuario.getInstance().setUsername(((VentanaPrincipal) vista).getUsername());
                int puertoInt = Integer.parseInt(puerto);
                Informacion informacionReceptor = new Informacion(ip, puertoInt, "");
                Usuario.getInstance().solicitarChat(informacionReceptor);
            }
        } catch (UnknownHostException ex1) {
            JOptionPane.showMessageDialog(null, "ERROR: Compruebe IP ingresada.");
        } catch (IOException ex2) {
            JOptionPane.showMessageDialog(null, "ERROR: Compruebe Puerto e IP ingresados.");
        }

    }

}
