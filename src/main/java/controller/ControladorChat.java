package controller;

import model.Usuario;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

public class ControladorChat implements ActionListener  {

    private IVista vista;
    private static ControladorChat instance;
    Usuario usuario;

    private Thread recibirMensajesThread;

    public ControladorChat() {
        this.vista = new VentanaChat();
        this.vista.setActionListener(this);
        iniciarHiloRecibirMensajes();
        try {
            usuario = Usuario.getInstance();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static ControladorChat getInstance() {
        if (instance == null) {
            instance = new ControladorChat();
        }
        return instance;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equalsIgnoreCase("ENVIAR")) {
          String mensaje = usuario.getPuerto() + vista.getText() ;
            try {
                System.out.println(mensaje);
                usuario.enviarMensaje(mensaje);  //Validar que mensaje no este vacio.
                vista.agregarMensaje(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }



    }

    private void iniciarHiloRecibirMensajes() {
        recibirMensajesThread = new Thread(() -> {
            while (true) { //cambiar a sesiona activa.
                try {
                    String mensaje = usuario.recibirMensaje();
                    System.out.println(mensaje);
                    vista.agregarMensaje(mensaje);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        recibirMensajesThread.start();
    }
}
