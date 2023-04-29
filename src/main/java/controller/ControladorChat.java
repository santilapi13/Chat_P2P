package controller;

import model.Usuario;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControladorChat implements ActionListener  {

    private IVista vista;
    private static ControladorChat instance;
    Usuario usuario;

    private Thread recibirMensajesThread;

    public ControladorChat() {
        this.vista = new VentanaChat();
        this.vista.setActionListener(this);
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
          String mensaje = vista.getText();
            try {
                usuario.enviarMensaje(mensaje);  //Validar que mensaje no este vacio.
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }



    }

    private void iniciarHiloRecibirMensajes() {
        recibirMensajesThread = new Thread(() -> {
            while (true) {
                try {
                    String mensaje = usuario.recibirMensaje();
                    //vista.mostrarMensajeRecibido(mensaje);  MANDAR MENSAJE A VISTA
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        recibirMensajesThread.start();
    }
}
