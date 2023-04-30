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

    private Thread recibirMensajesThread;

    private ControladorChat() throws UnknownHostException {
        this.vista = new VentanaChat();
        this.vista.setActionListener(this);
        iniciarHiloRecibirMensajes();
    }

    public static ControladorChat getInstance() throws UnknownHostException {
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
            ((VentanaChat) vista).vaciarTextField();
            try {
                if (mensaje != null && !mensaje.isEmpty())
                    Usuario.getInstance().enviarMensaje(mensaje);
                vista.agregarMensaje(Usuario.getInstance().getUsername() + "(YO): " + mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void iniciarHiloRecibirMensajes() {
        recibirMensajesThread = new Thread(() -> {
            while (true) { //cambiar a sesion activa.
                try {
                    String mensaje = Usuario.getInstance().recibirMensaje();
                    vista.agregarMensaje(Usuario.getInstance().getSesionActual().getRemoto().getUsername() + ": " + mensaje);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        recibirMensajesThread.start();
    }
}
