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

    private ControladorChat() {
    }

    public void nuevaVentana() throws UnknownHostException {
        ControladorPrincipal.getInstance().getVista().minimizarVentana();
        this.vista = new VentanaChat();
        this.vista.setActionListener(this);
        ((VentanaChat) this.vista).setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ((VentanaChat) this.vista).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    recibirMensajesThread.interrupt();
                    Usuario.getInstance().desconectar();
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    ControladorPrincipal.getInstance().getVista().abrirVentana();
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
                if (mensaje != null && !mensaje.isEmpty()) {
                    Usuario.getInstance().enviarMensaje(mensaje);
                    vista.agregarMensaje(Usuario.getInstance().getUsername() + " (Yo): " + mensaje);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void run() {
        try {
            // Lee el primer caracter para checkear que siga establecida la conexion
            int sigueLeyendo = Usuario.getInstance().getSocket().getInputStream().read();
            while (!Usuario.getInstance().getSocket().isInputShutdown() && !Usuario.getInstance().getSocket().isOutputShutdown() && sigueLeyendo != -1) {
                try {
                    String mensaje = (char) sigueLeyendo + Usuario.getInstance().recibirMensaje();
                    if (mensaje != null && !mensaje.isEmpty()) {
                        java.awt.Toolkit.getDefaultToolkit().beep();
                        vista.agregarMensaje(Usuario.getInstance().getSesionActual().getRemoto().getUsername() + ": " + mensaje);
                    }
                } catch (IOException e) {}
                sigueLeyendo = Usuario.getInstance().getSocket().getInputStream().read();
            }
            Usuario.getInstance().desconectar();
            ControladorPrincipal.getInstance().getVista().abrirVentana();
            java.awt.Toolkit.getDefaultToolkit().beep();
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
