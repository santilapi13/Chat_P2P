package controller;

import model.Usuario;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;

public class ControladorChat implements ActionListener, Runnable  {

    private IVista vista;
    private static ControladorChat instance;

    private Thread recibirMensajesThread;

    private ControladorChat() throws UnknownHostException {
        this.vista = new VentanaChat();
        this.vista.setActionListener(this);
        ((VentanaChat) this.vista).setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ((VentanaChat) this.vista).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    recibirMensajesThread.interrupt();
                    Usuario.getInstance().desconectar();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
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
                vista.agregarMensaje(Usuario.getInstance().getUsername() + "(Yo): " + mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void run() {
        try {
            while (!Usuario.getInstance().getSocket().isInputShutdown() && !Usuario.getInstance().getSocket().isOutputShutdown()) { //cambiar a sesion activa.
                try {
                    String mensaje = Usuario.getInstance().recibirMensaje();
                    if (mensaje != null && !mensaje.isEmpty())
                        vista.agregarMensaje(Usuario.getInstance().getSesionActual().getRemoto().getUsername() + ": " + mensaje);
                } catch (IOException e) {}
            }
            System.out.println("SE SALIO DEL WHILE");
            Usuario.getInstance().desconectar();
            ((VentanaChat) vista).dispose();
        } catch (IOException e) {
            System.out.println("TERMINO EL RUN DEL HILO CON EXCEPCION");
        }
    }

    private void iniciarHiloRecibirMensajes() {
        recibirMensajesThread = new Thread(this);
        recibirMensajesThread.start();
    }

}
