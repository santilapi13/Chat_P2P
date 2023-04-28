package controller;

import view.IVista;
import view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

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
        String comando = e.getActionCommand().toUpperCase();
        switch (comando) {
            case "":
                break;
        }
    }

}
